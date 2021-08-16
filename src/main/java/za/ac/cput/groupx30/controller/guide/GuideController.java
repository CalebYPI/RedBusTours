package za.ac.cput.groupx30.controller.guide;

/* Thaakir Ajouhaar - 217244394
 * Guide Controller
 *  16 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.factory.GuideFactory;
import za.ac.cput.groupx30.service.guide.GuideService;

import java.util.Set;

@RestController()
@RequestMapping("/guide")
public class GuideController
{
    @Autowired
    private GuideService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Guide create(@RequestBody Guide guide)
    {
        Guide newGuide = GuideFactory.createId(guide.getName(), guide.getId());
        return service.create(newGuide);

    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Guide read(@RequestBody Guide guide)
    {
        return service.read(guide.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Guide update(@RequestBody Guide guide)
    {
        return service.update(guide);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Guide guide)
    {
        return service.delete(guide.getId());

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Guide> getAll()
    {
        return service.getAll();
    }

}
