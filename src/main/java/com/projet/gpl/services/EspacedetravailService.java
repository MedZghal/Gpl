/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Espacedetravail;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.metier.EspacedetravailMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class EspacedetravailService {
    
    @Autowired
    public EspacedetravailMetier espacedetravailMetier ;
    
    
    @PostMapping("/AjouterEsptrv")
    public Espacedetravail AjouterEsptrv(@RequestParam String titre,@RequestParam String categorie,@RequestParam String description) {
        return espacedetravailMetier.AjouterEsptrv(titre, categorie, description);
    }

    @PostMapping("/ModifierEsptrv")
    public Espacedetravail ModifierEsptrv(@RequestParam String titre,@RequestParam String categorie,@RequestParam String description,@RequestParam Integer id) {
        return espacedetravailMetier.ModifierEsptrv( id,titre, categorie, description);
    }

    @PostMapping("/SuppEsptrv")
    public Boolean SuppEsptrv(@RequestParam int id) {
        espacedetravailMetier.SuppEsptrv(id);
        return true;
    }
    
        
    
}
