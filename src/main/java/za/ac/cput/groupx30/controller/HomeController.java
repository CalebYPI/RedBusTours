package za.ac.cput.groupx30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home", "/index"})
    public String home(Model model) {
        System.out.println("Home Controller");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        System.out.println("About Controller");
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Model model) {
        System.out.println("Contact Controller");
        return "contact";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        System.out.println("Login Controller");
        return "login";
    }
}
