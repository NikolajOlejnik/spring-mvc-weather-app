package main.java.ua.olejnik.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping (value = "/error")
    public String handle() {
        return "redirect:/";
    }
}
