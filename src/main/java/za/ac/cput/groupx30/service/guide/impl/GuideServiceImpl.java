package za.ac.cput.groupx30.service.guide.impl;

/*  GuideServiceImpl.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.repository.guide.GuideRepository;
import za.ac.cput.groupx30.service.guide.GuideService;

import java.util.HashSet;
import java.util.Set;

@Service
public class GuideServiceImpl implements GuideService
{
    private static GuideServiceImpl service = null;
    private GuideRepository repository;


    @Autowired
    public static GuideServiceImpl getService()
    {
        if (service == null)
            service = new GuideServiceImpl();
        return service;
    }

    @Override
    public Guide create(Guide guide)
    {
        return this.repository.save(guide);
    }

    @Override
    public Guide read(Guide.GuideId id)
    {
        return this.repository.getById(id);
    }

    @Override
    public boolean delete(Guide guide)
    {
        this.repository.delete(guide);
        return true;
    }

    @Override
    public Set<Guide> getAll()
    {
        return new HashSet<>(this.repository.findAll());
    }
}
