/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Fichier;
import com.projet.gpl.entites.Gestionnaire;
import com.projet.gpl.metier.GestionnaireMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class GestionnaireService {
    
    @Autowired
    public GestionnaireMetier gestionnaireMetier;
    
    @PostMapping("/AjouterGes")
    public Gestionnaire AjouterGes(@RequestParam String nom,@RequestParam String prenom,@RequestParam String email,@RequestParam String tel,@RequestParam String categorie,@RequestParam String tags,@RequestParam String pass,@RequestParam String fichierimge) {
        return gestionnaireMetier.AjouterGes(nom, prenom, email, tel, categorie, tags, pass, fichierimge);
    }

    @PostMapping("/ModifierGes")
    public Gestionnaire ModifierGes(@RequestParam Integer id,@RequestParam String nom,@RequestParam String prenom,@RequestParam String email,@RequestParam String tel,@RequestParam String categorie,@RequestParam String tags,@RequestParam String pass,@RequestParam String fichierimge) {
        return gestionnaireMetier.ModifierGes(id, nom, prenom, email, tel, categorie, tags, pass, fichierimge);
    }

    @PostMapping("/SuppGes")
    public Boolean SuppGes(@RequestParam int id) {
        gestionnaireMetier.SuppGes(id);
        return true;
    }
}
