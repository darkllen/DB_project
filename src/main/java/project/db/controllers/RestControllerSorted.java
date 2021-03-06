package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Category;
import project.db.dto.Employee;
import project.db.dto.Product;
import project.db.dto.Store_Product;
import project.db.repos.StoreProductRepo;
import project.db.services.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestControllerSorted {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private StoreProductService storeProductService;

    @RequestMapping(value = {"/get_cassiers_sorted_surname"}, method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> get_cassiers_sorted_surname(){
        try{
            return ResponseEntity.ok().body(employeeService.get_cassiers_sorted_surname());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_products_by_category_sorted_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_products_by_category_sorted_name(@RequestParam int category_number){
        try{
            return ResponseEntity.ok().body(productService.get_products_by_category_sorted_name(category_number));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_all_products_sorted_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_all_products_sorted_name(){
        try{
            return ResponseEntity.ok().body(productService.get_all_products_sorted_name());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_all_categories_sorted_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<Category>> get_all_categories_sorted_name(){
        try{
            return ResponseEntity.ok().body(categoryService.get_all_categories_sorted_name());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_promo_store_products_sorted_name_num"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_promo_store_products_sorted_name_num(){
        try{
            return ResponseEntity.ok().body(storeProductService.get_promo_store_products_sorted_name_num());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_promo_store_products_sorted_num_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_promo_store_products_sorted_num_name(){
        try{
            return ResponseEntity.ok().body(storeProductService.get_promo_store_products_sorted_num_name());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }


    @RequestMapping(value = {"/get_not_promo_store_products_sorted_name_num"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_not_promo_store_products_sorted_name_num(){
        try{
            return ResponseEntity.ok().body(storeProductService.get_not_promo_store_products_sorted_name_num());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_not_promo_store_products_sorted_num_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_not_promo_store_products_sorted_num_name(){
        try{
            return ResponseEntity.ok().body(storeProductService.get_not_promo_store_products_sorted_num_name());
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }
}
