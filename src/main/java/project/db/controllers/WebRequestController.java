package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebRequestController {

    @RequestMapping(value = {"/cassiers_sorted_surname"}, method = RequestMethod.GET)
    public String cassiers_sorted_surname(){
        return "requests/cassiers_sorted_surname";
    }

    @RequestMapping(value = {"/products_by_category_sorted_name"}, method = RequestMethod.GET)
    public String products_by_category_sorted_name(){
        return "requests/products_by_category_sorted_name";
    }

    @RequestMapping(value = {"/phone_address_by_empl_surname"}, method = RequestMethod.GET)
    public String phone_address_by_empl_surname(){
        return "requests/phone_address_by_empl_surname";
    }

    @RequestMapping(value = {"/all_products_sorted_name"}, method = RequestMethod.GET)
    public String all_products_sorted_name(){
        return "requests/all_products_sorted_name";
    }


//    @RequestMapping(value = {"/category_requests}"}, method = RequestMethod.GET)
//    public String category(){
//        return "requests/category_requests";
//    }
//    @RequestMapping(value = {"/employee_requests}"}, method = RequestMethod.GET)
//    public String employee(){
//        return "requests/employee_requests";
//    }
//    @RequestMapping(value = {"/product_requests}"}, method = RequestMethod.GET)
//    public String product(){
//        return "requests/product_requests";
//    }
//    @RequestMapping(value = {"/customer_card_requests}"}, method = RequestMethod.GET)
//    public String customer_card(){
//        return "requests/customer_card_requests";
//    }
//    @RequestMapping(value = {"/store_product_requests}"}, method = RequestMethod.GET)
//    public String store_product(){
//        return "requests/store_product_requests";
//    }
//    @RequestMapping(value = {"/check_requests}"}, method = RequestMethod.GET)
//    public String check(){
//        return "requests/check_requests";
//    }

}
