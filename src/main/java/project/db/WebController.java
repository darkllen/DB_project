package project.db;

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

}