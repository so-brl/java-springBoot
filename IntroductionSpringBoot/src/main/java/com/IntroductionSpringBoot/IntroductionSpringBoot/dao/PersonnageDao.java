package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Personnage;
import java.util.List;

public interface PersonnageDao {

    public List<Personnage> findAll();
    public Personnage findById(int id);
    public Personnage save(Personnage personnage);
    public Personnage updPersonnage(int id,Personnage personnage);
    public void delete(int id);
}

