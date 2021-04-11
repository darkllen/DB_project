package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Employee;
import project.db.dto.Product;
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

//    @RequestMapping(value = {"/get_products_by_category_sorted_name"}, method = RequestMethod.POST)
//    public ResponseEntity<List<Product>> get_products_by_category_sorted_name(){
//        try{
//            return ResponseEntity.ok().body(employeeService.get_cassiers_sorted_surname());
//        } catch (Exception e){
//            return ResponseEntity.status(500).header("error","error").body(List.of());
//        }
//    }
}
