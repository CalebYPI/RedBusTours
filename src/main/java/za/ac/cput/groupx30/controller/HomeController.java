package za.ac.cput.groupx30.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping({"/", "home", "index"})
    String Home() {
        return "Red Bus City Site Seeing Tours";
    }
}
