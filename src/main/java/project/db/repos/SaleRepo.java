package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Product;
import project.db.dto.Sale;
import project.db.dto.SaleId;

import java.util.List;

public interface SaleRepo  extends JpaRepository<Sale, SaleId> {

    @Query(value = "SELECT  * " +
            "FROM Sale ", nativeQuery = true)
    List<Sale> getAllSales();

    @Query(value = "SELECT  * " +
            "FROM Sale " +
            "WHERE UPC=?1 AND check_number=?2", nativeQuery = true)
    Sale getSaleByUpcCheckNumber(String upc, String check_number);
}
