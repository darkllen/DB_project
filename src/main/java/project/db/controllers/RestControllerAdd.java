package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.services.*;

@RestController
public class RestControllerAdd {
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

    @RequestMapping(value = {"/add_category"}, method = RequestMethod.POST)
    public ResponseEntity<Category> add_category(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @RequestMapping(value = {"/add_customer"}, method = RequestMethod.POST)
    public ResponseEntity<Customer_Card> add_customer_card(@RequestBody Customer_Card customer){
        try{
            customerService.addCustomerCard(customer);
        }catch ( Exception e){
            return ResponseEntity.status(500).header("error","can not be added").body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @RequestMapping(value = {"/add_product"}, method = RequestMethod.POST)
    public ResponseEntity<Product> add_product(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @RequestMapping(value = {"/add_employee"}, method = RequestMethod.POST)
    public ResponseEntity<Employee> add_employee(@RequestBody Employee employee){
        try{
            employeeService.addEmployee(employee);
        }catch ( Exception e){
            return ResponseEntity.status(500).header("error","can not be added").body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @RequestMapping(value = {"/add_check"}, method = RequestMethod.POST)
    public ResponseEntity<Check> add_check(@RequestBody Check check){
        try{
            checkService.addCheck(check);
        }catch ( Exception e){
            return ResponseEntity.status(500).header("error","can not be added").body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(check);
    }

    @RequestMapping(value = {"/add_store_product"}, method = RequestMethod.POST)
    public ResponseEntity<Store_Product> add_store_product(@RequestBody Store_Product store_product){
        try{
            storeProductService.addStoreProduct(store_product);
        }catch ( Exception e){
            return ResponseEntity.status(500).header("error","can not be added").body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(store_product);
    }

    @RequestMapping(value = {"/add_sale"}, method = RequestMethod.POST)
    public ResponseEntity<Sale> add_sale(@RequestBody Sale sale){
        try{
            saleService.addSale(sale);
        }catch ( Exception e){
            return ResponseEntity.status(500).header("error","can not be added").body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(sale);
    }


}
