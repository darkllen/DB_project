package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebRequestController {

    @RequestMapping(value = {"/cassiers_sorted_surname"}, method = RequestMethod.GET)
    public String cassiers_sorted_surname(){
        return "requests/employee/cassiers_sorted_surname";
    }

    @RequestMapping(value = {"/products_by_category_sorted_name"}, method = RequestMethod.GET)
    public String products_by_category_sorted_name(){
        return "requests/product/products_by_category_sorted_name";
    }

    @RequestMapping(value = {"/phone_address_by_empl_surname"}, method = RequestMethod.GET)
    public String phone_address_by_empl_surname(){
        return "requests/employee/phone_address_by_empl_surname";
    }

    @RequestMapping(value = {"/all_products_sorted_name"}, method = RequestMethod.GET)
    public String all_products_sorted_name(){
        return "requests/product/all_products_sorted_name";
    }

    @RequestMapping(value = {"/all_categories_sorted_name"}, method = RequestMethod.GET)
    public String all_categories_sorted_name(){
        return "requests/category/all_categories_sorted_name";
    }

    @RequestMapping(value = {"/all_products_by_category"}, method = RequestMethod.GET)
    public String all_products_by_category(){
        return "requests/product/all_products_by_category";
    }

    @RequestMapping(value = {"/all_products_in_store_by_product"}, method = RequestMethod.GET)
    public String all_products_in_store_by_product(){
        return "requests/product/store_product/all_products_in_store_by_product";
    }

    @RequestMapping(value = {"/product_by_upc"}, method = RequestMethod.GET)
    public String product_by_upc(){
        return "requests/product/store_product/product_by_upc";
    }

    @RequestMapping(value = {"/promo_store_products_sorted_name_num"}, method = RequestMethod.GET)
    public String promo_store_products_sorted_name_num(){
        return "requests/product/store_product/promo_store_products_sorted_name_num";
    }

    @RequestMapping(value = {"/promo_store_products_sorted_num_name"}, method = RequestMethod.GET)
    public String promo_store_products_sorted_num_name(){
        return "requests/product/store_product/promo_store_products_sorted_num_name";
    }

    @RequestMapping(value = {"/not_promo_store_products_sorted_name_num"}, method = RequestMethod.GET)
    public String not_promo_store_products_sorted_name_num(){
        return "requests/product/store_product/not_promo_store_products_sorted_name_num";
    }

    @RequestMapping(value = {"/not_promo_store_products_sorted_num_name"}, method = RequestMethod.GET)
    public String not_promo_store_products_sorted_num_name(){
        return "requests/product/store_product/not_promo_store_products_sorted_num_name";
    }


    @RequestMapping(value = {"/checks_with_sales_by_employee_between_time"}, method = RequestMethod.GET)
    public String checks_with_sales_by_employee_between_time(){
        return "requests/check/checks_with_sales_by_employee_between_time";
    }

//    @RequestMapping(value = {"/checks_with_sales_by_employee_between_time"}, method = RequestMethod.GET)
//    public String checks_with_sales_by_employee_between_time(){
//        return "requests/check/checks_with_sales_by_employee_between_time";
//    }

    @RequestMapping(value = {"/sum_recipes_by_employee_between_time"}, method = RequestMethod.GET)
    public String sum_recipes_by_employee_between_time(){
        return "requests/check/sum_recipes_by_employee_between_time";
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
