package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.repos.EmployeeRepo;
import project.db.repos.ProductRepo;
import project.db.repos.StoreProductRepo;
import project.db.services.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class RestControllerGetAllBy {
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

    @RequestMapping(value = {"/get_phone_address_by_empl_surname"}, method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeRepo.EmployeeContacts>> get_phone_address_by_empl_surname(@RequestParam String empl_surname) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.get_phone_address_by_empl_surname(empl_surname));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_all_products_by_category"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_all_products_by_category(@RequestParam int category_number) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.get_all_products_by_category(category_number));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_all_products_in_store_by_product"}, method = RequestMethod.GET)
    public ResponseEntity<List<Store_Product>> get_all_products_in_store_by_product(@RequestParam int id_product) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(storeProductService.get_all_products_in_store_by_product(id_product));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_product_by_upc"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductPriceNum>> get_product_by_upc(@RequestParam String upc) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(storeProductService.get_product_by_upc(upc));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_checks_with_sales_by_employee_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<List<Check>> get_checks_with_sales_by_employee_between_time(@RequestParam String id_employee, @RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_checks_with_sales_by_employee_between_time(id_employee, date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_checks_by_curr_employee_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<List<Check>> get_checks_with_sales_by_employee_between_time(Principal principal, @RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_checks_with_sales_by_employee_between_time(principal.getName(), date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_checks_with_sales_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<List<Check>> get_checks_with_sales_between_time(@RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_checks_with_sales_between_time(date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_sum_recipes_by_employee_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<Double> get_sum_recipes_by_employee_between_time(@RequestParam String id_employee, @RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_sum_recipes_by_employee_between_time(id_employee, date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(0.0);
        }
    }

    @RequestMapping(value = {"/get_sum_all_recipes_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<Double> get_sum_all_recipes_between_time(@RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_sum_all_recipes_between_time(date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(0.0);
        }
    }

    @RequestMapping(value = {"/get_num_product_saled_between_time"}, method = RequestMethod.GET)
    public ResponseEntity<Integer> get_num_product_saled_between_time(@RequestParam String date_start, @RequestParam String date_end) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(checkService.get_num_product_saled_between_time(date_start, date_end));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(0);
        }
    }

    @RequestMapping(value = {"/get_customers_by_percent"}, method = RequestMethod.GET)
    public ResponseEntity<List<Customer_Card>> get_customers_by_percent(@RequestParam int percent) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(customerService.get_customers_by_percent(percent));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(List.of());
        }
    }

    @RequestMapping(value = {"/get_product_info_by_upc"}, method = RequestMethod.GET)
    public ResponseEntity<ProductRepo.ProductInfo> get_product_info_by_upc(@RequestParam String upc) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.get_product_info_by_upc(upc));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(null);
        }
    }

    @RequestMapping(value = {"/get_customers_by_surname"}, method = RequestMethod.GET)
    public ResponseEntity<List<Customer_Card>> get_customers_by_surname(@RequestParam String cust_surname) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(customerService.get_customers_by_surname(cust_surname));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(null);
        }
    }

    @RequestMapping(value = {"/get_products_by_check_number"}, method = RequestMethod.GET)
    public ResponseEntity<List<Product>> get_products_by_check_number(@RequestParam int check_number) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.get_products_by_check_number(check_number));
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","error").body(null);
        }
    }


}
