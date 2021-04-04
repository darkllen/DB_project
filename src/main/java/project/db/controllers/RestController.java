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
import project.db.repos.CategoryRepo;
import project.db.repos.CustomerRepo;
import project.db.repos.ProductRepo;

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


    @RequestMapping(value = {"/get_all_cities"}, method = RequestMethod.POST)
    public ResponseEntity<List<String>> get_all_cities(){
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.getAllCities());
    }


    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String test(){
        customerRepo.getClientsWhoBuysOnlyPromoProducts().forEach(System.out::println);
        return "index";
    }
}
