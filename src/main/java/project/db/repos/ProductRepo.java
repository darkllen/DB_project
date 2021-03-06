package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.db.dto.Product;

import javax.transaction.Transactional;
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


    @Query(value = "SELECT  Store_product.UPC AS UPC " +
            "FROM Store_product " +
            "WHERE id_product=:id ", nativeQuery = true)
    List<String> getUpcsForProduct(@Param("id") int id);


    @Query(value = "SELECT  * " +
            "FROM Product " +
            "WHERE id_product=?1 ", nativeQuery = true)
    Product getProductByIdProduct(int id_product);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Product " +
            "WHERE id_product=?1 ", nativeQuery = true)
    void removeProductByIdProduct(int id_product);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Product " +
            "SET product_name=?2, category_number=?3, `characteristics`=?4 " +
            "WHERE id_product=?1 ", nativeQuery = true)
    void editProduct(Integer id_product, String product_name, Integer category_number, String characteristics);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Product (category_number, product_name, `characteristics`) VALUES (?2, ?1, ?3)", nativeQuery = true)
    void addProduct(String product_name, Integer category_number, String characteristics);

    @Query(value = "SELECT  * " +
            "FROM Product " +
            "WHERE category_number=?1 " +
            "ORDER BY product_name", nativeQuery = true)
    List<Product> get_products_by_category_sorted_name(int category_number);

    @Query(value = "SELECT  * " +
            "FROM Product " +
            "ORDER BY product_name ", nativeQuery = true)
    List<Product> get_all_products_sorted_name();

    @Query(value = "SELECT  * " +
            "FROM Product " +
            "WHERE category_number=?1 ", nativeQuery = true)
    List<Product> get_all_products_by_category(int category_number);

    @Query(value = "SELECT  Product.id_product AS id_product, Store_Product.selling_price AS selling_price, Store_Product.products_number AS products_number, Product.product_name AS product_name, Product.characteristics AS characteristics " +
            "FROM Product INNER JOIN Store_Product ON Product.id_product=Store_Product.id_product " +
            "WHERE Store_Product.UPC=?1 ", nativeQuery = true)
    ProductInfo get_product_info_by_upc(String upc);

    @Query(value = "SELECT  product_name " +
            "FROM Product " +
            "ORDER BY product_name", nativeQuery = true)
    List<String> get_all_products_name();

    @Query(value = "SELECT DISTINCT Product.id_product AS id_product, category_number, product_name, `characteristics` " +
            "FROM (Sale INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC) " +
            "          INNER JOIN Product ON Store_Product.id_product=Product.id_product " +
            "WHERE Sale.check_number=?1 ", nativeQuery = true)
    List<Product> get_products_by_check_number(int check_number);

    @Query(value = "SELECT Store_Product.selling_price AS selling_price, Store_Product.products_number AS products_number " +
            "FROM Product INNER JOIN Store_Product ON Product.id_product=Store_Product.id_product " +
            "WHERE Store_Product.UPC=?1 ", nativeQuery = true)
    ProductInfoShort get_product_info_short_by_upc(String upc);


    interface ProductInfoShort{
        double getSelling_price();
        int getProducts_number();
    }

    interface ProductInfo{
        int getId_product();
        double getSelling_price();
        int getProducts_number();
        String getProduct_name();
        String getCharacteristics();
    }
}
