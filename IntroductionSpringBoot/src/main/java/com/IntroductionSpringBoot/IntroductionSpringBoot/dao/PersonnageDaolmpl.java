package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;

import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnageDaolmpl implements PersonnageDao {


    public static List<Personnage> personnages = new ArrayList<>();

    static {
        personnages.add(new Personnage(1, "Riri", "Canard"));
        personnages.add(new Personnage(2, "Fifi", "Canard"));
        personnages.add(new Personnage(3, "Loulou", "Canard"));
    }

    @Override
    public List<Personnage> findAll() {
        return personnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnage : personnages) {
            if (personnage.getId() == id) {
                return personnage;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    @Override
    public Personnage updPersonnage(int id, Personnage updPersonnage) {
        for (Personnage personnage : personnages) {
            if (personnage.getId() == id) {
                personnage.setId(updPersonnage.getId());
                personnage.setNom(updPersonnage.getNom());
                personnage.setType(updPersonnage.getType());
                return personnage;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        personnages.removeIf(personnage -> personnage.getId() == id);
    }
}
