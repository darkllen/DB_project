package project.db.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project.db.dto.Store_Product;

import javax.transaction.Transactional;
import java.util.List;

public interface StoreProductRepo  extends JpaRepository<Store_Product, String> {

    @Query(value = "SELECT  * " +
            "FROM Store_Product ", nativeQuery = true)
    List<Store_Product> getAllStoreProducts();

    @Query(value = "SELECT Store_Product.UPC AS UPC, Store_Product.UPC_prom AS UPC_prom, Store_Product.id_product AS id_product, Store_Product.selling_price AS selling_price, Store_Product.products_number AS products_number, Store_Product.promotional_product  AS promotional_product,   Product.product_name AS product_name " +
            "FROM Store_Product INNER JOIN Product ON Store_Product.id_product=Product.id_product ", nativeQuery = true)
    List<StoreProductWithName> getAllStoreProductsWithName();

    @Query(value = "SELECT  * " +
            "FROM Store_Product " +
            "WHERE UPC=?1", nativeQuery = true)
    Store_Product getStoreProductByUPC(String upc);

    @Transactional
    @Modifying
    @Query(value = "DELETE " +
            "FROM Store_Product " +
            "WHERE UPC=?1", nativeQuery = true)
    void removeStoreProductByUPC(String upc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Store_Product " +
            "SET UPC=?2, upc_prom=?3, id_product=?4, selling_price=?5, products_number=?6, promotional_product=?7 " +
            "WHERE UPC=?1", nativeQuery = true)
    void editStoreProduct(String prev_upc, String upc, String upc_prom, Integer id_product, double selling_price, Integer products_number, boolean promotional_product);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Store_Product VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void addStoreProduct(String upc, String upc_prom, Integer id_product, double selling_price, Integer products_number, boolean is_promo);

    interface StoreProductWithName {
        String getProduct_name();
        String getUPC();
        String getUPC_prom();
        int getId_product();
        double getSelling_price();
        int getProducts_number();
        boolean getPromotional_product();
    }
}
