package project.db.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.db.repos.CategoryRepo;
import project.db.repos.CustomerRepo;

import java.util.List;

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