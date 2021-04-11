package project.db.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Product;
import project.db.repos.ProductRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public List<Product> getAllProductsThatAllClientsFromCityNBuy(String city){
        return productRepo.getAllProductsThatAllClientsFromCityNBuy(city);
    };

    public List<Product> getAllProductsThatClientsFromCityNBuy(String city){
        return productRepo.getAllProductsThatClientsFromCityNBuy(city);
    };

    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    };

    public List<String> getUpcsForProduct( int id){
        return productRepo.getUpcsForProduct(id);
    };

    public Product getProductByIdProduct(int id_product) {
        return productRepo.getProductByIdProduct(id_product);
    }

    public void removeProductByIdProduct(int id_product) {
        productRepo.removeProductByIdProduct(id_product);
    }

    public void editProduct(Product product) {
        productRepo.editProduct(
                product.getId_product(),
                product.getProduct_name(),
                product.getCategory_number(),
                product.getCharacteristics()
        );
    }
}
