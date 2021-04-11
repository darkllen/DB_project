package project.db.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.db.dto.Category;
import project.db.services.*;

import java.util.List;

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
    public ResponseEntity<String> edit_category(@RequestBody Category category) {
        categoryService.editCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body("{\"edited\":\"edited\"}");
    }

}
