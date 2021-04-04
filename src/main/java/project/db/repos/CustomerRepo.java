package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Category;
import project.db.dto.Customer_Card;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer_Card, String> {

    @Query(value = "SELECT Customer_Card.card_number as card_number, cust_surname, cust_name, SUM(sum_total) as total " +
            "FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number) " +
            "GROUP BY Customer_Card.card_number", nativeQuery = true)
    List<CustomerSpends> getCustomersSpends();
    interface CustomerSpends {
        String getCard_number();
        String getCust_surname();
        String getCust_name();
        double getTotal();
    }

    @Query(value = "SELECT DISTINCT (Customer_Card.city) as city " +
            "FROM Customer_Card ", nativeQuery = true)
    List<String> getAllCities();
}
