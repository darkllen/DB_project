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
    public String employee(Model model, @PathVariable int cat_id){
        model.addAttribute("cat_id", cat_id);
        return "edit/edit_category";
    }
}
