package com.IntroductionSpringBoot.IntroductionSpringBoot.dao;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Character;
import java.util.List;

public interface CharacterDao {

    public List<Character> findAll();
    public Character findById(int id);
    public Character save(Character character);
    public Character updPersonnage(int id, Character character);
    public void delete(int id);
}

