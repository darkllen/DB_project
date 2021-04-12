package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WebController {


    /**
     *
     * @return main page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String add(){
        return "add/add";
    }
    @RequestMapping(value = {"/add_kassir"}, method = RequestMethod.GET)
    public String add_kassir(){
        return "add/add_kassir";
    }
    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String category(){
        return "view/category";
    }
    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public String employee(){
        return "view/employee";
    }
    @RequestMapping(value = {"/customer_card"}, method = RequestMethod.GET)
    public String customer_card(){
        return "view/customer_card";
    }
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String product(){
        return "view/product";
    }
    @RequestMapping(value = {"/store_product"}, method = RequestMethod.GET)
    public String store_product(){
        return "view/store_product";
    }
    @RequestMapping(value = {"/check"}, method = RequestMethod.GET)
    public String check(){
        return "view/check";
    }
    @RequestMapping(value = {"/check_kassir"}, method = RequestMethod.GET)
    public String check_kassir(){
        return "view/check_kassir";
    }
//    @RequestMapping(value = {"/sale/{check_id}"}, method = RequestMethod.GET)
//    public String employee(Model model, @PathVariable int check_id){
//        model.addAttribute("check_id", check_id);
//        return "view/sale";
//    }


//    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
//    public String edit(){
//        return "edit";
//    }
//
//    @RequestMapping(value = {"/remove"}, method = RequestMethod.GET)
//    public String remove(){
//        return "remove";
//    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/categories_count"}, method = RequestMethod.GET)
    public String categories_count(){
        return "categories_count";
    }

    @RequestMapping(value = {"/customer_spends"}, method = RequestMethod.GET)
    public String customer_spends(){
        return "customer_spends";
    }

    @RequestMapping(value = {"/all_products_that_all_clients_from_city_buy"}, method = RequestMethod.GET)
    public String all_products_that_clients_from_city_buy(){
        return "all_products_that_all_clients_from_city_buy";
    }

    @RequestMapping(value = {"/clients_who_buys_only_promo_products"}, method = RequestMethod.GET)
    public String clients_who_buys_only_promo_products(){
        return "clients_who_buys_only_promo_products";
    }

    @RequestMapping(value = {"/employees_sales_sum"}, method = RequestMethod.GET)
    public String employees_sales_sum(){
        return "employees_sales_sum";
    }

    @RequestMapping(value = {"/employees_clients_num"}, method = RequestMethod.GET)
    public String employees_clients_num(){
        return "employees_clients_num";
    }

    @RequestMapping(value = {"/all_checks_with_all_promo_products_from_category"}, method = RequestMethod.GET)
    public String all_checks_with_all_promo_products_from_category(){
        return "all_checks_with_all_promo_products_from_category";
    }

    @RequestMapping(value = {"/all_clients_who_buys_all_categories_products"}, method = RequestMethod.GET)
    public String all_clients_who_buys_all_categories_products(){
        return "all_clients_who_buys_all_categories_products";
    }


}