package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Store_Product;

import java.util.List;

public interface StoreProductRepo  extends JpaRepository<Store_Product, String> {

    @Query(value = "SELECT  * " +
            "FROM Store_Product ", nativeQuery = true)
    List<Store_Product> getAllStoreProducts();
}
