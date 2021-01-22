package com.IntroductionSpringBoot.IntroductionSpringBoot.web.controller;

import com.IntroductionSpringBoot.IntroductionSpringBoot.dao.CharacterDao;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;



@Api(tags ={"Gestion des Characters"},description = "Permet la gestion de tous les Characters")
//@Api(description = "Gestion des Characters")
//@Api(tags = {"Gestion des Characters"}, description = "Get, put, post and delete de Characters"))
//@SwaggerDefinition(tags = {
//        @Tag(name = "Gestion des Characters", description = "Get, put, post and delete de Characters")
//})
@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    //Characters
    @ApiOperation(notes = "La fonction **listeCharacters()** permet de lister tous les Characters.", value = "Récupèrer la liste des Characters", nickname = "listeCharacters",  tags = "Liste Characters" )
    @GetMapping(value = "/Characters")
    public List<Character> listeCharacters() {
        return characterDao.findAll();
    }

    //Characters/{id}
    @ApiOperation(notes = "La fonction **findById()** permet d'afficher les informations liées à un personnage grâce à son ID.", value = "Récupèrer un personnage selon son ID", nickname = " findById",  tags = "Afficher personnage" )
    @GetMapping(value = "/Characters/{id}")
    @RequestMapping(value = "/Characters/{id}", method = RequestMethod.GET)
    public Character findById(@PathVariable int id) {
        //Récupérer un personnage par son Id
        return characterDao.findById(id);
    }

    //Characters
    @ApiOperation(notes = "La fonction **save()** permet d'ajouter un personnage.", value = "Ajouter un personnage", nickname = "save",  tags = "Ajouter personnage" )
    @PostMapping(value = "/Characters")
    @RequestMapping(value = "/Characters", method = RequestMethod.POST)
    public void save(@RequestBody Character character) {
       characterDao.save(character);
    }

    //Characters/{id}
    @ApiOperation(notes = "La fonction **updPersonnage()** permet de mêttre à jour les informations d'un personnage selon son ID.", value = "Modifier un personnage", nickname = "updPersonnage",  tags = "Modifier personnage" )
    @PutMapping(value = "/UpdCharacters/{id}")
    public void updPersonnage(@PathVariable int id, @RequestBody Character character) {
      characterDao.updPersonnage(id, character);
    }

    //Characters/{id}
    @ApiOperation(notes = "La fonction **delete()** permet de supprimer un personnage selon son ID.", value = "Supprimer un personnage", nickname = "delete",  tags = "Supprimer personnage" )
    @DeleteMapping (value = "/Characters/{id}")
    public void delete(@PathVariable int id) {
    characterDao.delete(id);
    }

}
