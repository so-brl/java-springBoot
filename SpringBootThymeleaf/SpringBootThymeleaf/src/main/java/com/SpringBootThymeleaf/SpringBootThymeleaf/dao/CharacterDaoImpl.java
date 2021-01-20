package com.SpringBootThymeleaf.SpringBootThymeleaf.dao;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Character;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao {

    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1,"Dilcec Silentsurge", Type.WIZZARD));
        characters.add(new Character(2,"Lukhoth Rainshard",Type.WIZZARD));
        characters.add(new Character(3,"Gicauc Hazestride",Type.WIZZARD));
        characters.add(new Character(4,"Nenis Amberhand",Type.WIZZARD));
        characters.add(new Character(5,"Vunic Fellsorrow",Type.WIZZARD));
        characters.add(new Character(6, "Sthiaktae Silentfall", Type.WARRIOR));
        characters.add(new Character(7, "Thrare The Abandoned", Type.WARRIOR));
        characters.add(new Character(8, "Fheda The Magnificent", Type.WARRIOR));
        characters.add(new Character(9, "Vrakza Cinderstrength", Type.WARRIOR));
        characters.add(new Character(10, "Kragi The Beast", Type.WARRIOR));
    }



    @Override
    public List<Character> findAll() {
        return  characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public Character save(Character character) {
        characters.add(character);
        return character;
    }


    @Override
    public Character updCharacter(int id, Character updCharacter) {
        for (Character character : characters) {
            if (character.getId() == id) {
                character.setId(updCharacter.getId());
                character.setName(updCharacter.getName());
                character.setType(updCharacter.getType());
                return character;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        characters.removeIf(character -> character.getId() == id);
    }
}
