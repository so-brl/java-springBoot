package com.SpringBootThymeleaf.SpringBootThymeleaf.web.controller;


import com.SpringBootThymeleaf.SpringBootThymeleaf.form.CharacterForm;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Character;
import com.SpringBootThymeleaf.SpringBootThymeleaf.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@Controller
public class CharacterController {

    @Autowired
    private RestTemplate restTemplate;


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
    public List<Character> characterList(Model model) {
        String url = "http://127.0.0.1:8081/Characters";
        List<Character> characterList = restTemplate.getForObject(url, List.class);
        model.addAttribute("characters", characterList);
        model.addAttribute("message", listMessage);
        return characterList;
    }

    @GetMapping(value = "/addCharacter")
    public String showAddCharacterPage(Model model) {
        CharacterForm characterForm = new CharacterForm();
        model.addAttribute("characterForm", characterForm);
        return "addCharacter";
    }

    @PostMapping(value = "/addCharacter")
    public String saveCharacter(Model model, @ModelAttribute CharacterForm characterForm){
        String name = characterForm.getName();
        Type type = characterForm.getType();
        String url = "http://127.0.0.1:8081/Characters";

        if (name != null && name.length() > 0 && type != null ) {
            restTemplate.postForObject(url,characterForm,Character.class);
            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCharacter";
    }


    @GetMapping (value = "/delCharacter/{id}")
    public String deleteCharacter(Model model, @PathVariable(value = "id") int id){
        String url = "http://127.0.0.1:8081/Characters/{id}";
        if (id>=0) {
            restTemplate.delete(url,id);
            return "redirect:/characterList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "delCharacter/{id}";
    }

}
