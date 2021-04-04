package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.db.repos.CategoryRepo;
import project.db.repos.CustomerRepo;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @RequestMapping(value = {"/get_categories_count"}, method = RequestMethod.GET)
    public ResponseEntity<List<CategoryRepo.CategoriesProductsCounted>> get_categories_count(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepo.getCategoriesProductsCount());
    }

    @RequestMapping(value = {"/get_customer_spends"}, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerRepo.CustomerSpends>> get_customer_spends(){
        customerRepo.getCustomersSpends().forEach(x->System.out.println(x.getCust_name()));
        return ResponseEntity.status(HttpStatus.OK).body(customerRepo.getCustomersSpends());
    }
}
