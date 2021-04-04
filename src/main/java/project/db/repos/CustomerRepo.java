package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
            "       FROM Customer_Card", nativeQuery = true)
    List<String> getAllCities();



    @Query(value = "SELECT C1.cust_surname as cust_surname, C1.cust_name as cust_name, C1.cust_patronymic as cust_patronymic, C1.phone_number as phone_number, C1.card_number as card_number, C1.percent as percent" +
            "       FROM Customer_Card AS C1" +
            "       WHERE NOT EXISTS (" +
            "                          SELECT * " +
            "                          FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number" +
            "                          INNER JOIN Sale ON Recipe.check_number=Sale.check_number" +
            "                          INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC)"+
            "                          WHERE C1.card_number=Customer_Card.card_number AND Store_Product.promotional_product=0)", nativeQuery = true)
    List<Customer_info> getClientsWhoBuysOnlyPromoProducts();
    interface Customer_info {
        String getCust_surname();
        String getCust_name();
        String getCust_patronymic();
        String getPhone_number();
        String getCard_number();
        int getPercent();
    }

}
