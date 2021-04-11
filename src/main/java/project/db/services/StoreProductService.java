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
}
