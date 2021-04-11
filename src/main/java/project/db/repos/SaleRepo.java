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
}
