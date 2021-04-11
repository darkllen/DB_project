package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.db.repos.StoreProductRepo;
import project.db.services.*;

import java.util.List;

@RestController
public class RestControllerGetAllAddInfo {
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

    @RequestMapping(value = {"/get_all_product_store_with_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_all_product_store_with_name(){
        return ResponseEntity.status(HttpStatus.OK).body(storeProductService.getAllProductStoreWithName());
    }
}
