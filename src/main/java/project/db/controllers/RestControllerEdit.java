package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.services.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class RestControllerEdit {
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


    @RequestMapping(value = {"/edit_category"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_category(@Valid  @RequestBody Category category) {
        categoryService.editCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_customer_card/{prev_card_number}"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_customer_card(@Valid @RequestBody Customer_Card customer_card, @PathVariable String prev_card_number) {
        customerService.editCustomerCard(customer_card, prev_card_number);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_employee/{prev_id_employee}"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_employee(@Valid @RequestBody Employee employee, @PathVariable String prev_id_employee) {
        if (employee.getPassword()==null){
            employeeService.editEmployeeWithoutPass(employee, prev_id_employee);
        } else{
            employeeService.editEmployee(employee, prev_id_employee);
        }
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_product"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_product(@Valid @RequestBody Product product) {
        productService.editProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_store_product/{prev_upc}"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_store_product(@Valid @RequestBody Store_Product store_product, @PathVariable String prev_upc) {
        storeProductService.editStoreProduct(store_product, prev_upc);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_check/{prev_check_number}"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_check(@Valid @RequestBody Check check, @PathVariable String prev_check_number) {
        checkService.editCheck(check, prev_check_number);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

    @RequestMapping(value = {"/edit_sale"}, method = RequestMethod.POST)
    public ResponseEntity<String> edit_sale(@Valid @RequestBody Sale sale) {
        saleService.editSale(sale);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

}
