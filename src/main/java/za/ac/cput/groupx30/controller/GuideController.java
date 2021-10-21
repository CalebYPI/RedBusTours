package za.ac.cput.groupx30.controller;

/* Thaakir Ajouhaar - 217244394
 * Guide Controller
 *  16 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.GuideFactory;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.GuideService;

import java.util.Set;

@Controller
@RequestMapping("/guide")
public class GuideController {
    @Autowired
    private GuideService service;

    @GetMapping("/home")
    public String home(Model model)
    {
        model.addAttribute("guides", service.getAll());
        return "/guideHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Guide guide) {
        return "guideAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Guide guide, BindingResult result, Model model) {
        if (result.hasErrors())
            return "guideAdd";
        Guide newGuide = GuideFactory.createId(guide.getName());
        service.create(newGuide);
        return "redirect:/guide/home";
    }

    @GetMapping(value = "/read/{id}")
    public Guide read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Guide guide = service.read(id);
        model.addAttribute("guide", guide);
        return "guideUpdate";
    }

    @PostMapping("/update")
    public String update(Guide guide, BindingResult result, Model model) {
        if (result.hasErrors())
            return "guideUpdate";
        service.update(guide);
        return "redirect:/guide/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model)
    {
        service.delete(id);
        model.addAttribute("guides", service.getAll());
        return "redirect:/guide/home";
    }

    @GetMapping(value = "/all")
    public Set<Guide> getAll() {
        return service.getAll();
    }

}
