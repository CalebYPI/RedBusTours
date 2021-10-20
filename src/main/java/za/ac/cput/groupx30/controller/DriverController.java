package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.factory.DriverFactory;
import za.ac.cput.groupx30.service.DriverService;

import java.util.Set;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("drivers", service.getAll());
        return "driverHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Driver driver){
        return "driverAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Driver driver, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverAdd";
        Driver newDriver = DriverFactory.createId(driver.getName());
        service.create(newDriver);
        return "redirect:/driver/home";
    }

    @GetMapping(value = "/read/{id}")
    public Driver read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Driver driver = service.read(id);
        model.addAttribute("driver", driver);
        return "driverUpdate";
    }

    @PostMapping("/update")
    public String update(Driver driver, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverUpdate";
        service.update(driver);
        return "redirect:/driver/home";
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model){
        service.delete(id);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/driver/home";
    }

    @GetMapping("/all")
    public Set<Driver> getAll() {
        return service.getAll();
    }
}
