package project.db;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.db.repos.CategoryRepo;
import project.db.repos.ProductRepo;

@Controller
@RequiredArgsConstructor
public class WebController {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;
    /**
     *
     * @return main page
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     *
     * @return main page
     */
    @RequestMapping(value = {"/all_categories"}, method = RequestMethod.GET)
    public String all_categories(Model model){
        model.addAttribute("categories", categoryRepo.getAllCategories());
        return "index";
    }

    /**
     *
     * @return main page
     */
    @RequestMapping(value = {"/all_products"}, method = RequestMethod.GET)
    public String all_products(Model model){
        model.addAttribute("products", productRepo.getAllProducts());
        return "index";
    }
}