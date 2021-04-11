package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Store_Product;

import java.util.List;

public interface StoreProductRepo  extends JpaRepository<Store_Product, String> {

    @Query(value = "SELECT  * " +
            "FROM Store_Product ", nativeQuery = true)
    List<Store_Product> getAllStoreProducts();

    @Query(value = "SELECT Store_Product.UPC AS UPC, Product.product_name AS product_name " +
            "FROM Store_Product INNER JOIN Product ON Store_Product.id_product=Product.id_product ", nativeQuery = true)
    List<StoreProductWithName> getAllStoreProductsWithName();

    @Query(value = "SELECT  * " +
            "FROM Store_Product " +
            "WHERE UPC=?1", nativeQuery = true)
    Store_Product getStoreProductByUPC(String upc);

    interface StoreProductWithName {
        String getProduct_name();
        String getUPC();
    }
}
