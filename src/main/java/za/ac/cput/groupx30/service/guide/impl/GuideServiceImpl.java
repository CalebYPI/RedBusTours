package za.ac.cput.groupx30.service.guide.impl;

/*  GuideServiceImpl.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */

import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.repository.guide.GuideRepository;
import za.ac.cput.groupx30.repository.guide.impl.GuideRepositoryImpl;
import za.ac.cput.groupx30.service.guide.GuideService;

import java.util.Set;

public class GuideServiceImpl implements GuideService
{
    private GuideRepository repository = null;
    private static GuideServiceImpl service = null;

    private GuideServiceImpl()
    {
        this.repository = GuideRepositoryImpl.getRepository();
    }

    public static GuideServiceImpl getService()
    {
        if (service == null)
            service = new GuideServiceImpl();
        return service;
    }

    @Override
    public Guide create(Guide guide)
    {
        return this.repository.create(guide);
    }

    @Override
    public Guide read(String id)
    {
        return repository.read(id);
    }

    @Override
    public Guide update(Guide guide)
    {
        return this.repository.update(guide);
    }

    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    @Override
    public Set<Guide> getAll()
    {
        return this.repository.getAll();
    }
}
