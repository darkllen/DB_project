package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Sale;
import project.db.repos.CheckRepo;
import project.db.repos.SaleRepo;
import project.db.repos.StoreProductRepo;
import project.db.services.*;

import java.security.Principal;
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

    @RequestMapping(value = {"/get_all_store_product_with_name"}, method = RequestMethod.GET)
    public ResponseEntity<List<StoreProductRepo.StoreProductWithName>> get_all_store_product_with_name(){
        return ResponseEntity.status(HttpStatus.OK).body(storeProductService.getAllProductStoreWithName());
    }

    @RequestMapping(value = {"/get_all_checks_with_empl"}, method = RequestMethod.GET)
    public ResponseEntity<List<CheckRepo.ChecksWithEmpl>> get_all_checks_with_empl(){
        return ResponseEntity.status(HttpStatus.OK).body(checkService.getAllChecksWithEmpl());
    }
    @RequestMapping(value = {"/get_all_checks_with_empl_by_current_empl"}, method = RequestMethod.GET)
    public ResponseEntity<List<CheckRepo.ChecksWithEmpl>> get_all_checks_with_empl_by_current_empl(Principal principal){
        return ResponseEntity.status(HttpStatus.OK).body(checkService.getAllChecksWithEmplByEmpl(principal.getName()));
    }

    @RequestMapping(value = {"/get_all_sales_with_product_name_by_check_number"}, method = RequestMethod.GET)
    public ResponseEntity<List<SaleRepo.SalesWithProductName>> get_all_sales_with_product_name_by_check_number(@RequestParam String check_number){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getAllSalesWithProductNameByCheckNumber(check_number));
    }


}
