package project.db.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import project.db.dto.Category;
import project.db.dto.Product;
import project.db.repos.ProductRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    @Transactional
    public List<Product> getAllProductsThatAllClientsFromCityNBuy(String city){
        return productRepo.getAllProductsThatAllClientsFromCityNBuy(city);
    };

    @Transactional
    public List<Product> getAllProductsThatClientsFromCityNBuy(String city){
        return productRepo.getAllProductsThatClientsFromCityNBuy(city);
    };

    @Transactional
    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    };

    @Transactional
    public List<String> getUpcsForProduct( int id){
        return productRepo.getUpcsForProduct(id);
    };

    @Transactional
    public Product getProductByIdProduct(int id_product) {
        return productRepo.getProductByIdProduct(id_product);
    }

    @Transactional
    public void removeProductByIdProduct(int id_product) {
        productRepo.removeProductByIdProduct(id_product);
    }

    @Transactional
    public void editProduct(Product product) {
        product.changeEmpty();
        productRepo.editProduct(
                product.getId_product(),
                product.getProduct_name(),
                product.getCategory_number(),
                product.getCharacteristics()
        );
    }

    @Transactional
    public void addProduct(Product product) {
        product.changeEmpty();
        productRepo.addProduct(
                product.getProduct_name(),
                product.getCategory_number(),
                product.getCharacteristics()
        );
    }

    @Transactional
    public List<Product> get_products_by_category_sorted_name(int category_number) {
        return productRepo.get_products_by_category_sorted_name(category_number);
    }

    @Transactional
    public List<Product> get_all_products_sorted_name() {
        return productRepo.get_all_products_sorted_name();
    }

    @Transactional
    public List<Product> get_all_products_by_category(int category_number) {
        return productRepo.get_all_products_by_category(category_number);
    }

    @Transactional
    public ProductRepo.ProductInfo get_product_info_by_upc(String upc) {
        return productRepo.get_product_info_by_upc(upc);
    }

    @Transactional
    public List<String> get_all_products_name() {
        return productRepo.get_all_products_name();
    }

    @Transactional
    public List<Product> get_products_by_check_number(int check_number) {
        return productRepo.get_products_by_check_number(check_number);
    }

    @Transactional
    public ProductRepo.ProductInfoShort get_product_info_short_by_upc(String upc) {
        return productRepo.get_product_info_short_by_upc(upc);
    }
}
