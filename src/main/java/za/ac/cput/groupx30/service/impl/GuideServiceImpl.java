package za.ac.cput.groupx30.service.impl;

/*  GuideServiceImpl.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.factory.GuideFactory;
import za.ac.cput.groupx30.repository.GuideRepository;
import za.ac.cput.groupx30.service.GuideService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GuideServiceImpl implements GuideService {
    private static GuideServiceImpl service = null;

    @Autowired
    private GuideRepository repository;

    @Override
    public Guide create(Guide guide) {
        return this.repository.save(guide);
    }

    @Override
    public Guide read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Guide update(Guide guide) {
        if (this.repository.existsById(guide.getId()))
            return this.repository.save(guide);
        return null;
    }

    @Override
    public boolean delete(String guideId) {
        this.repository.deleteById(guideId);
        if (this.repository.existsById(guideId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Guide> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
