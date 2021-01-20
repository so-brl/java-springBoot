package com.SpringBootThymeleaf.SpringBootThymeleaf.dao;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Character;
import java.util.List;

public interface CharacterDao {
    public List<Character> findAll();
    public Character findById(int id);
    public Character save(Character character);
    public Character updCharacter(int id,Character character);
    public void delete(int id);
}
