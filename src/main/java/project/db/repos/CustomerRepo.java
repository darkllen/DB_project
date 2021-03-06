package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Customer_Card;
import project.db.dto.Product;


import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer_Card, String> {

    @Query(value = "SELECT Customer_Card.card_number as card_number, cust_surname, cust_name, SUM(sum_total) as total " +
            "FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number) " +
            "GROUP BY Customer_Card.card_number", nativeQuery = true)
    List<CustomerSpends> getCustomersSpends();

    @Query(value = "SELECT * " +
            "FROM Customer_Card " +
            "WHERE card_number=?1", nativeQuery = true)
    Customer_Card getCustomerCardByCardNumber(String card_number);

    @Transactional
    @Modifying
    @Query(value = "SELECT * " +
            "FROM Customer_Card " +
            "WHERE card_number=?1", nativeQuery = true)
    void removeCustomerCardByCardNumber(String card_number);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Customer_Card " +
            "SET card_number=?2, cust_name=?3, cust_surname=?4, cust_patronymic=?5, phone_number=?6, city=?7, street=?8, zip_code=?9, `percent`=?10 " +
            "WHERE card_number=?1", nativeQuery = true)
    void editCustomerCard(String prev_card_number,
                          String card_number,
                          String cust_name,
                          String cust_surname,
                          String cust_patronymic,
                          String phone_number,
                          String city,
                          String street,
                          String zip_code,
                          Integer percent);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Customer_Card VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    void addCustomerCard(String card_number, String cust_surname, String cust_name, String cust_patronymic, String phone_number, String city, String street, String zip_code, Integer percent);

    @Query(value = "SELECT * " +
            "FROM Customer_Card " +
            "WHERE `percent`=?1", nativeQuery = true)
    List<Customer_Card> get_customers_by_percent(int percent);

    @Query(value = "SELECT * " +
            "FROM Customer_Card " +
            "WHERE LCASE(cust_surname) LIKE %?1%", nativeQuery = true)
    List<Customer_Card> get_customers_by_surname(String toLowerCase);

    @Query(value = "SELECT cust_surname " +
            "FROM Customer_Card ", nativeQuery = true)
    List<String> get_all_cust_surname();

    interface CustomerSpends {
        String getCard_number();
        String getCust_surname();
        String getCust_name();
        double getTotal();
    }

    @Query(value = "SELECT * " +
            "FROM Customer_Card ", nativeQuery = true)
    List<Customer_Card> getAllCustomerCards();


    @Query(value = "SELECT DISTINCT (Customer_Card.city) as city " +
            "       FROM Customer_Card", nativeQuery = true)
    List<String> getAllCities();



    @Query(value = "SELECT C1.cust_surname AS cust_surname, C1.cust_name AS cust_name, C1.cust_patronymic AS cust_patronymic, C1.phone_number AS phone_number, C1.card_number AS card_number, C1.percent AS percent" +
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



    @Query(value = "SELECT C1.cust_surname AS cust_surname, C1.cust_name AS cust_name, C1.cust_patronymic AS cust_patronymic, C1.phone_number AS phone_number, C1.card_number AS card_number, C1.percent AS percent" +
            "       FROM Customer_Card AS C1" +
            "       WHERE NOT EXISTS (" +
            "                           SELECT *" +
            "                           FROM Category AS Cat1" +
            "                           WHERE Cat1.category_number NOT IN (" +
                                                        "SELECT Product.category_number " +
                                                        "FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number" +
                                                        "                    INNER JOIN Sale ON Recipe.check_number=Sale.check_number" +
                                                        "                    INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC" +
                                                        "                    INNER JOIN Product ON Store_Product.id_product=Product.id_product) " +
                                                        "WHERE C1.card_number=Customer_Card.card_number" +
                                                        "                           ))",nativeQuery = true)
    List<Customer_info> ClientsWhoBuysAllCategoriesProducts();

}
