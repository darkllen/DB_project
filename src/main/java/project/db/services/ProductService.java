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
}
