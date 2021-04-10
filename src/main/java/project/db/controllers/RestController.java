package project.db.controllers;

import com.fasterxml.jackson.databind.node.TextNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.db.dto.Customer_Card;
import project.db.dto.Product;
import project.db.repos.*;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CheckRepo checkRepo;

    @RequestMapping(value = {"/get_categories_count"}, method = RequestMethod.GET)
    public ResponseEntity<List<CategoryRepo.CategoriesProductsCounted>> get_categories_count(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.getCategoriesProductsCount());
    }

    @RequestMapping(value = {"/get_customer_spends"}, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerRepo.CustomerSpends>> get_customer_spends(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.getCustomersSpends());
    }

    @RequestMapping(value = {"/get_all_products_that_clients_from_city_buy/{city}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_all_products_that_clients_from_city_buy(@PathVariable String city){
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.getAllProductsThatClientsFromCityNBuy(city));
    }

    @RequestMapping(value = {"/get_all_products_that_all_clients_from_city_buy/{city}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_all_products_that_all_clients_from_city_buy(@PathVariable String city){
        return ResponseEntity.status(HttpStatus.OK).body(productRepo.getAllProductsThatAllClientsFromCityNBuy(city));
    }

    @RequestMapping(value = {"/get_clients_who_buys_only_promo_products"}, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerRepo.Customer_info>> get_clients_who_buys_only_promo_products(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.getClientsWhoBuysOnlyPromoProducts());
    }

    @RequestMapping(value = {"/get_employees_sales_sum"}, method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeRepo.EmployeeTotalInfo>> get_employees_sales_sum(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepo.getEmployeesSalesSum());
    }

    @RequestMapping(value = {"/get_employees_clients_num"}, method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeRepo.EmployeeCustInfo>> get_employees_clients_num(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeRepo.getEmployeesClientsNum());
    }

    @RequestMapping(value = {"/get_all_cities"}, method = RequestMethod.POST)
    public ResponseEntity<List<String>> get_all_cities(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.getAllCities());
    }

    @RequestMapping(value = {"/get_all_clients_who_buys_all_categories_products"}, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerRepo.Customer_info>> get_all_clients_who_buys_all_categories_products(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.ClientsWhoBuysAllCategoriesProducts());
    }

    @RequestMapping(value = {"/get_all_checks_with_promo_products_from_category/{category}"}, method = RequestMethod.GET)
    public ResponseEntity<List<CheckRepo.ChecksInfo>> get_all_checks_with_promo_products_from_category(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(checkRepo.AllChecksWithAllPromoProductsFromCategory(category));
    }

    @RequestMapping(value = {"/get_categories_like/{category}"}, method = RequestMethod.POST)
    public ResponseEntity<List<CategoryRepo.CategoriesInfo>> get_categories_like(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.getCategoriesLike(category));
    }

    @RequestMapping(value = {"/get_categories"}, method = RequestMethod.GET)
    public ResponseEntity<List<CategoryRepo.CategoriesInfo>> get_categories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.getCategories());
    }


    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test(){
        checkRepo.AllChecksWithAllPromoProductsFromCategory("Fruits").forEach(System.out::println);
        return "index";
    }
}
