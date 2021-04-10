package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
    public String edit(){
        return "edit";
    }

    @RequestMapping(value = {"/remove"}, method = RequestMethod.GET)
    public String remove(){
        return "remove";
    }

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