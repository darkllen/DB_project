package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.repos.CategoryRepo;
import project.db.services.*;

import java.util.List;

@RestController
public class RestControllerGetAll {

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


    @RequestMapping(value = {"/get_all_cities"}, method = RequestMethod.GET)
    public ResponseEntity<List<String>> get_all_cities(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCities());
    }

    @RequestMapping(value = {"/get_categories"}, method = RequestMethod.GET)
    public ResponseEntity<List<CategoryRepo.CategoriesInfo>> get_categories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories());
    }


    @RequestMapping(value = {"/get_all_categories"}, method = RequestMethod.GET)
    public ResponseEntity<List<Category>> get_all_categories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @RequestMapping(value = {"/get_all_products"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_all_products(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @RequestMapping(value = {"/get_all_store_products"}, method = RequestMethod.GET)
    public ResponseEntity<List<Store_Product>> get_all_store_products(){
        return ResponseEntity.status(HttpStatus.OK).body(storeProductService.getAllStoreProducts());
    }

    @RequestMapping(value = {"/get_all_sales"}, method = RequestMethod.GET)
    public ResponseEntity<List<Sale>> get_all_sales(){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllSales());
    }

    @RequestMapping(value = {"/get_all_checks"}, method = RequestMethod.GET)
    public ResponseEntity<List<Check>> get_all_checks(){
        return ResponseEntity.status(HttpStatus.OK).body(checkService.getAllChecks());
    }

    @RequestMapping(value = {"/get_all_employees"}, method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> get_all_employees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @RequestMapping(value = {"/get_all_customer_cards"}, method = RequestMethod.GET)
    public ResponseEntity<List<Customer_Card>> get_all_customer_cards(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomerCards());
    }

//    @RequestMapping(value = {"/get_all_customers_contacts"}, method = RequestMethod.GET)
//    public ResponseEntity<List<Customer_Card>> get_all_customers_contacts(){
//        return ResponseEntity.status(HttpStatus.OK).body(customerService.get_all_customers_contacts());
//    }

}
