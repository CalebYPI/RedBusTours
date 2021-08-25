package za.ac.cput.groupx30.controller.guide;

/* Thaakir Ajouhaar - 217244394
 * Guide Controller
 *  16 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.GuideFactory;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.guide.GuideService;

import java.util.Set;

@RestController()
@RequestMapping("/guide")
public class GuideController
{
    @Autowired
    private GuideService service;

    @PostMapping(value = "/create")
    public Guide create(@RequestBody Guide guide)
    {
        Guide newGuide = GuideFactory.createId(guide.getName(), guide.getId());
        return service.create(newGuide);
    }

    @GetMapping(value = "/read/{id}/{name}")
    public Guide read(@PathVariable String id, @PathVariable("name") String name)
    {
        Guide.GuideId Id = new Guide.GuideId(id, name);
        return service.read(Id);
    }

    @DeleteMapping(value = "/delete/{id}/{name}")
    public boolean delete(@PathVariable String id, @PathVariable("name") String name)
    {
        Guide guide = GuideFactory.createId(id, name);
        return service.delete(guide);
    }

    @GetMapping(value = "/all")
    public Set<Guide> getAll()
    {
        return service.getAll();
    }

}
