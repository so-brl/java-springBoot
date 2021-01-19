package com.IntroductionSpringBoot.IntroductionSpringBoot.web.controller;

import com.IntroductionSpringBoot.IntroductionSpringBoot.dao.PersonnageDao;
import com.IntroductionSpringBoot.IntroductionSpringBoot.model.Personnage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
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
    private PersonnageDao personageDao;

    //Personnages
    @ApiOperation(notes = "La fonction **listePersonnages()** permet de lister tous les personnages.", value = "Récupèrer la liste des personnages", nickname = "listePersonnages",  tags = "Liste personnages" )
    @GetMapping(value = "/Personnages")
    public List<Personnage> listePersonnages() {
        return personageDao.findAll();
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **findById()** permet d'afficher les informations liées à un personnage grâce à son ID.", value = "Récupèrer un personnage selon son ID", nickname = " findById",  tags = "Afficher personnage" )
    @GetMapping(value = "/Personnages/{id}")
    @RequestMapping(value = "/Personnages/{id}", method = RequestMethod.GET)
    public Personnage  findById(@PathVariable int id) {
        //Récupérer un personnage par son Id
        return personageDao.findById(id);
    }

    //Personnages
    @ApiOperation(notes = "La fonction **save()** permet d'ajouter un personnage.", value = "Ajouter un personnage", nickname = "save",  tags = "Ajouter personnage" )
    @PostMapping(value = "/Personnages")
    @RequestMapping(value = "/Personnages", method = RequestMethod.POST)
    public Personnage save(@RequestBody Personnage personnage) {
        return personageDao.save(personnage);
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **updPersonnage()** permet de mêttre à jour les informations d'un personnage selon son ID.", value = "Modifier un personnage", nickname = "updPersonnage",  tags = "Modifier personnage" )
    @PutMapping(value = "/Personnages/{id}")
    public Personnage updPersonnage(@PathVariable int id, @RequestBody Personnage personnage) {
      personageDao.updPersonnage(id,personnage);
      return personnage;
    }

    //Personnages/{id}
    @ApiOperation(notes = "La fonction **delete()** permet de supprimer un personnage selon son ID.", value = "Supprimer un personnage", nickname = "delete",  tags = "Supprimer personnage" )
    @DeleteMapping (value = "/Personnages/{id}")
    public void delete(@PathVariable int id) {
    personageDao.delete(id);
    }

}
