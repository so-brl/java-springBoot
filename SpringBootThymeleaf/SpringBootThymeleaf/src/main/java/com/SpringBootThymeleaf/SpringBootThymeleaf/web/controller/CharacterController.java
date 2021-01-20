package com.SpringBootThymeleaf.SpringBootThymeleaf.web.controller;

import com.SpringBootThymeleaf.SpringBootThymeleaf.dao.CharacterDao;
import com.SpringBootThymeleaf.SpringBootThymeleaf.form.CharacterForm;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Character;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Type;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;


    private static List<Character> characters = new ArrayList<Character>();

    static {
        characters.add(new Character(1, "Dilcec Silentsurge", Type.WIZZARD));
        characters.add(new Character(2, "Lukhoth Rainshard", Type.WIZZARD));
        characters.add(new Character(3, "Gicauc Hazestride", Type.WIZZARD));
        characters.add(new Character(4, "Nenis Amberhand", Type.WIZZARD));
        characters.add(new Character(5, "Vunic Fellsorrow", Type.WIZZARD));
        characters.add(new Character(6, "Sthiaktae Silentfall", Type.WARRIOR));
        characters.add(new Character(7, "Thrare The Abandoned", Type.WARRIOR));
        characters.add(new Character(8, "Fheda The Magnificent", Type.WARRIOR));
        characters.add(new Character(9, "Vrakza Cinderstrength", Type.WARRIOR));
        characters.add(new Character(10, "Kragi The Beast", Type.WARRIOR));
    }


    // Injectez (inject) via application.properties.
    @Value("Hello Player")
    private String message;


    @Value("${error.message}")
    private String errorMessage;

    @Value("${list.message}")
    private String listMessage;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = {"/characterList"})
    public String characterList(Model model) {
        model.addAttribute("characters", characters);
        model.addAttribute("message", listMessage);
        return "characterList";
    }

    @GetMapping(value = {"/addCharacter"})
    public String showAddCharacterPage(Model model) {
        CharacterForm characterForm = new CharacterForm();
        model.addAttribute("characterForm", characterForm);
        return "addCharacter";
    }

    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.POST)
    public String saveCharacter(Model model, @ModelAttribute("characterForm") CharacterForm characterForm) {
        String name = characterForm.getName();
        Type type = characterForm.getType();

        if (name != null && name.length() > 0 && type != null ) {
            Character newCharacter = new Character(name, type);
            characters.add(newCharacter);

            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCharacter";
    }




}
