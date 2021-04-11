package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Product;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT *" +
            "       FROM Product AS P1" +
            "       WHERE NOT EXISTS (" +
            "                           SELECT *" +
            "                           FROM Customer_Card AS C1" +
            "                           WHERE C1.city=:city AND P1.id_product NOT IN (" +
                                                                                "SELECT  Product.id_product " +
                                                                                "FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number" +
                                                                                "                    INNER JOIN Sale ON Recipe.check_number=Sale.check_number" +
                                                                                "                    INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC" +
                                                                                "                    INNER JOIN Product ON Store_Product.id_product=Product.id_product) " +
                                                                                "WHERE Customer_Card.card_number=C1.card_number))" +
            "             AND EXISTS (SELECT * " +
            "                         FROM Customer_Card AS C2 " +
            "                         WHERE C2.city=:city) ", nativeQuery = true)
    List<Product> getAllProductsThatAllClientsFromCityNBuy(@Param("city") String city);


    @Query(value = "SELECT  Product.id_product, category_number, product_name, characteristics " +
            "FROM (Customer_Card INNER JOIN Recipe ON Customer_Card.card_number=Recipe.card_number" +
            "                    INNER JOIN Sale ON Recipe.check_number=Sale.check_number" +
            "                    INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC" +
            "                    INNER JOIN Product ON Store_Product.id_product=Product.id_product) " +
            "WHERE Customer_Card.city=:city", nativeQuery = true)
    List<Product> getAllProductsThatClientsFromCityNBuy(@Param("city") String city);

    @Query(value = "SELECT  Product.id_product, category_number, product_name, characteristics " +
            "FROM Product ", nativeQuery = true)
    List<Product> getAllProducts();

}
