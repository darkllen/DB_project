package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.services.*;

@RestController
public class RestControllerGetAllById {
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

    @RequestMapping(value = {"/get_category_by_category_number"}, method = RequestMethod.GET)
    public ResponseEntity<Category> get_category_by_category_number(@RequestParam int category_number){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryByCategoryNumber(category_number));
    }

    @RequestMapping(value = {"/get_product_by_id_product"}, method = RequestMethod.GET)
    public ResponseEntity<Product> get_product_by_id_product(@RequestParam int id_product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByIdProduct(id_product));
    }

    @RequestMapping(value = {"/get_store_product_by_upc"}, method = RequestMethod.GET)
    public ResponseEntity<Store_Product> get_store_product_by_upc(@RequestParam String UPC){
        return ResponseEntity.status(HttpStatus.OK).body(storeProductService.getStoreProductByUPC(UPC));
    }

    @RequestMapping(value = {"/get_sale_by_upc_check_number"}, method = RequestMethod.GET)
    public ResponseEntity<Sale> get_sale_by_upc_check_number(@RequestParam String UPC, @RequestParam String check_number){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.getSaleByUpcCheckNumber(UPC, check_number));
    }

    @RequestMapping(value = {"/get_check_by_check_number"}, method = RequestMethod.GET)
    public ResponseEntity<Check> get_check_by_check_number(@RequestParam String check_number){
        return ResponseEntity.status(HttpStatus.OK).body(checkService.getCheckByCheckNumber(check_number));
    }

    @RequestMapping(value = {"/get_employee_by_id_employee"}, method = RequestMethod.GET)
    public ResponseEntity<Employee> get_employee_by_id_employee(@RequestParam String id_employee){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByIdEmployee(id_employee));
    }

    @RequestMapping(value = {"/get_customer_card_by_card_number"}, method = RequestMethod.GET)
    public ResponseEntity<Customer_Card> get_customer_card_by_card_number(@RequestParam String card_number){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerCardByCardNumber(card_number));
    }
}
