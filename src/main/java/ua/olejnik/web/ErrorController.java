package main.java.ua.olejnik.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    private final String REDIRECT_TO_MAIN_PAGE = "redirect:/";

    @RequestMapping(value="/error")
    public String handle() {
        return REDIRECT_TO_MAIN_PAGE;
    }

}