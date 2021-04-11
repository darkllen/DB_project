package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Category;
import project.db.dto.Product;
import project.db.dto.Store_Product;
import project.db.repos.EmployeeRepo;
import project.db.services.*;

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
}
