package project.db.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.*;
import project.db.services.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class RestControllerRemoveById {
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


    @RequestMapping(value = {"/remove_category"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_category(@RequestBody Map<String,String> map){
        try{
            categoryService.removeCategoryByCategoryNumber(Integer.parseInt(map.get("category_number")));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_product"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_product(@RequestBody Map<String,String> map){
        try{
            productService.removeProductByIdProduct(Integer.parseInt(map.get("id_product")));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");

        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_store_product"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_store_product(@RequestBody Map<String,String> map){
        try {
            storeProductService.removeStoreProductByUPC(map.get("upc"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_sale"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_sale(@RequestBody Map<String,String> map){
        try {
            saleService.removeSaleByUpcCheckNumber(map.get("upc"), map.get("check_number"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_check"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_check(@RequestBody Map<String,String> map){
        try {
            checkService.removeCheckByCheckNumber(map.get("check_number"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_employee"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_employee(Principal principal, @RequestBody Map<String, String> map){
        try {
            employeeService.removeEmployeeByIdEmployee(map.get("id_employee"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }

    @RequestMapping(value = {"/remove_customer_card"}, method = RequestMethod.POST)
    public ResponseEntity<String > remove_customer_card(@RequestBody Map<String,String> map){
        try {
            customerService.removeCustomerCardByCardNumber(map.get("card_number"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.status(500).header("error","can not be removed").body("");
        }
    }
}
