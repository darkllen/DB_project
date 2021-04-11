package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Category;
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
}
