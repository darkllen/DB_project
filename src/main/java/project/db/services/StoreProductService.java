package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Store_Product;
import project.db.repos.StoreProductRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreProductService {
    private final StoreProductRepo storeProductRepo;

    @Transactional
    public List<Store_Product> getAllStoreProducts() {
        return storeProductRepo.getAllStoreProducts();
    }

    @Transactional
    public List<StoreProductRepo.StoreProductWithName> getAllProductStoreWithName() {
        return storeProductRepo.getAllStoreProductsWithName();
    }

    @Transactional
    public Store_Product getStoreProductByUPC(String upc) {
        return storeProductRepo.getStoreProductByUPC(upc);
    }

    @Transactional
    public void removeStoreProductByUPC(String upc) {
        storeProductRepo.removeStoreProductByUPC(upc);
    }

    @Transactional
    public void editStoreProduct(Store_Product store_product, String prev_upc) {
        storeProductRepo.editStoreProduct(
                prev_upc,
                store_product.getUpc(),
                store_product.getUpc_prom(),
                store_product.getId_product(),
                store_product.getSelling_price(),
                store_product.getProducts_number(),
                store_product.isPromotional_product()
        );
    }

    @Transactional
    public void addStoreProduct(Store_Product store_product) {
        storeProductRepo.addStoreProduct(
                store_product.getUpc(),
                store_product.getUpc_prom(),
                store_product.getId_product(),
                store_product.getSelling_price(),
                store_product.getProducts_number(),
                store_product.isPromotional_product()
        );
    }
}
