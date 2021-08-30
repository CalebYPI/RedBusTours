//package za.ac.cput.groupx30.repository.guide.impl;
//
///*  GuideRepositoryImpl.java
// *  Author: Thaakir Ajouhaar (217244394)
// *  Date: 26 July 2021
// */
//
//import za.ac.cput.groupx30.entity.Guide;
//import za.ac.cput.groupx30.repository.GuideRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class GuideRepositoryImpl implements GuideRepository
//{
//    private static GuideRepositoryImpl repository = null;
//    private Set<Guide> guideDatabase;
//
//    private GuideRepositoryImpl()
//    {
//        this.guideDatabase = new HashSet<>();
//    }
//
//    public static GuideRepositoryImpl getRepository()
//    {
//        if (repository == null)
//        {
//            repository = new GuideRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Guide create(Guide guide)
//    {
//        this.guideDatabase.add(guide);
//        return guide;
//    }
//
//    @Override
//    public Guide read(String id)
//    {
//        for (Guide guide: guideDatabase)
//        {
//            if (guide.getId().equalsIgnoreCase(id))
//                return guide;
//        }
//        return null;
//    }
//
//    @Override
//    public Guide update(Guide guide)
//    {
//        Guide read = read(guide.getId());
//        if (read != null) {
//            this.guideDatabase.remove(read);
//            this.guideDatabase.add(guide);
//            return guide;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id)
//    {
//        Guide guide = read(id);
//        if (guide != null)
//        {
//            this.guideDatabase.remove(id);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Guide> getAll()
//    {
//        return guideDatabase;
//    }
//}
//
