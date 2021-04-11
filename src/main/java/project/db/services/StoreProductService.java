package project.db.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.db.dto.Sale;
import project.db.dto.Store_Product;
import project.db.repos.SaleRepo;
import project.db.repos.StoreProductRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreProductService {
    private final StoreProductRepo storeProductRepo;
    public List<Store_Product> getAllStoreProducts() {
        return storeProductRepo.getAllStoreProducts();
    }

    public List<StoreProductRepo.StoreProductWithName> getAllProductStoreWithName() {
        return storeProductRepo.getAllStoreProductsWithName();
    }

    public Store_Product getStoreProductByUPC(String upc) {
        return storeProductRepo.getStoreProductByUPC(upc);
    }

    public void removeStoreProductByUPC(String upc) {
        storeProductRepo.removeStoreProductByUPC(upc);
    }

    public void editStoreProduct(Store_Product store_product, String prev_upc) {
        storeProductRepo.editStoreProduct(
                prev_upc,
                store_product.getUPC(),
                store_product.getUPC_prom(),
                store_product.getId_product(),
                store_product.getSelling_price(),
                store_product.getProducts_number(),
                store_product.isPromotional_product()
        );
    }
}
