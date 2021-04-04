package project.db;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.db.repos.CategoryRepo;

@Controller
@RequiredArgsConstructor
public class WebController {

    @Autowired
    private CategoryRepo categoryRepo;

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

}