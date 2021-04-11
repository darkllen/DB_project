package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Product;
import project.db.dto.Sale;
import project.db.dto.SaleId;

import javax.transaction.Transactional;
import java.util.List;

public interface SaleRepo  extends JpaRepository<Sale, SaleId> {

    @Query(value = "SELECT  * " +
            "FROM Sale ", nativeQuery = true)
    List<Sale> getAllSales();

    @Query(value = "SELECT  * " +
            "FROM Sale " +
            "WHERE UPC=?1 AND check_number=?2", nativeQuery = true)
    Sale getSaleByUpcCheckNumber(String upc, String check_number);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Sale " +
            "WHERE UPC=?1 AND check_number=?2", nativeQuery = true)
    void removeSaleByUpcCheckNumber(String upc, String check_number);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Sale " +
            "SET product_number=?3, selling_price=?4 " +
            "WHERE UPC=?1 AND check_number=?2", nativeQuery = true)
    void editSale(String upc, String check_number, Integer product_number, double selling_price);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Sale VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void addSale(String upc, String check_number, Integer product_number, double selling_price);

    @Query(value = "SELECT  Sale.UPC AS upc, Sale.check_number AS check_number, Sale.product_number AS product_number, Sale.selling_price AS selling_price, Product.product_name AS product_name  " +
            "FROM Sale INNER JOIN Store_Product ON Sale.UPC=Store_Product.UPC INNER  JOIN Product ON Store_Product.id_product=Product.id_product " +
            "WHERE Sale.check_number=?1", nativeQuery = true)
    List<SalesWithProductName> getAllSalesWithProductNameByCheckNumber(String check_number);
    public interface SalesWithProductName{
        String getUpc();
        String getCheck_number();
        int getProduct_number();
        double getSelling_price();
        String getProduct_name();
    }
}
