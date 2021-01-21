package com.IntroductionSpringBoot.IntroductionSpringBoot.web.controller;

import com.IntroductionSpringBoot.IntroductionSpringBoot.dao.CharacterDao;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api(tags ={"Gestion des personnages"},description = "Permet la gestion de tous les personnages")
//@Api(description = "Gestion des personnages")
//@Api(tags = {"Gestion des personnages"}, description = "Get, put, post and delete de personnages"))
//@SwaggerDefinition(tags = {
//        @Tag(name = "Gestion des personnages", description = "Get, put, post and delete de personnages")
//})
@RestController
public class PersonnagesController {

    @Autowired
    private CharacterDao characterDao;

    //Personnages
    @ApiOperation(notes = "La fonction **listePersonnages()** permet de lister tous les personnages.", value = "Récupèrer la liste des personnages", nickname = "listePersonnages",  tags = "Liste personnages" )
    @GetMapping(value = "/Personnages")
    public List<Character> listePersonnages() {
        return characterDao.findAll();
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **findById()** permet d'afficher les informations liées à un personnage grâce à son ID.", value = "Récupèrer un personnage selon son ID", nickname = " findById",  tags = "Afficher personnage" )
    @GetMapping(value = "/Personnages/{id}")
    @RequestMapping(value = "/Personnages/{id}", method = RequestMethod.GET)
    public Character findById(@PathVariable int id) {
        //Récupérer un personnage par son Id
        return characterDao.findById(id);
    }

    //Personnages
    @ApiOperation(notes = "La fonction **save()** permet d'ajouter un personnage.", value = "Ajouter un personnage", nickname = "save",  tags = "Ajouter personnage" )
    @PostMapping(value = "/Personnages")
    @RequestMapping(value = "/Personnages", method = RequestMethod.POST)
    public Character save(@RequestBody Character character) {
        return characterDao.save(character);
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **updPersonnage()** permet de mêttre à jour les informations d'un personnage selon son ID.", value = "Modifier un personnage", nickname = "updPersonnage",  tags = "Modifier personnage" )
    @PutMapping(value = "/Personnages/{id}")
    public Character updPersonnage(@PathVariable int id, @RequestBody Character character) {
      characterDao.updPersonnage(id, character);
      return character;
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **delete()** permet de supprimer un personnage selon son ID.", value = "Supprimer un personnage", nickname = "delete",  tags = "Supprimer personnage" )
    @DeleteMapping (value = "/Personnages/{id}")
    public void delete(@PathVariable int id) {
    characterDao.delete(id);
    }

}
