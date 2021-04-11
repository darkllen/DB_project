package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebEditController {

    @RequestMapping(value = {"/edit_category/{cat_id}"}, method = RequestMethod.GET)
    public String category(Model model, @PathVariable int cat_id){
        model.addAttribute("cat_id", cat_id);
        return "edit/edit_category";
    }
    @RequestMapping(value = {"/edit_employee/{em_id}"}, method = RequestMethod.GET)
    public String employee(Model model, @PathVariable String em_id){
        model.addAttribute("em_id", em_id);
        return "edit/edit_employee";
    }
    @RequestMapping(value = {"/edit_product/{pr_id}"}, method = RequestMethod.GET)
    public String product(Model model, @PathVariable String pr_id){
        model.addAttribute("pr_id", pr_id);
        return "edit/edit_product";
    }
    @RequestMapping(value = {"/edit_customer_card/{cust_id}"}, method = RequestMethod.GET)
    public String customer_card(Model model, @PathVariable String cust_id){
        model.addAttribute("cust_id", cust_id);
        return "edit/edit_customer_card";
    }
    @RequestMapping(value = {"/edit_store_product/{st_pr_id}"}, method = RequestMethod.GET)
    public String store_product(Model model, @PathVariable String st_pr_id){
        model.addAttribute("st_pr_id", st_pr_id);
        return "edit/edit_store_product";
    }
    @RequestMapping(value = {"/edit_check/{ch_id}"}, method = RequestMethod.GET)
    public String check(Model model, @PathVariable String ch_id){
        model.addAttribute("ch_id", ch_id);
        return "edit/edit_check";
    }
    @RequestMapping(value = {"/edit_sale/{check_id}/{upc}"}, method = RequestMethod.GET)
    public String sale(Model model, @PathVariable int check_id,@PathVariable int upc){
        model.addAttribute("upc", upc);
        model.addAttribute("check_id", check_id);
        return "edit/edit_sale";
    }
}
