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

}