/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Tache;
import com.projet.gpl.metier.TacheMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class TacheService {
    
    @Autowired
    public TacheMetier tacheMetier;
    
    @PostMapping("/AjouterTach")
    public Tache AjouterTach(@RequestParam String titre,@RequestParam String datedebut,@RequestParam String datefin,@RequestParam String duree,@RequestParam String statut,@RequestParam String description,@RequestParam int projet) {
        return tacheMetier.AjouterTach(titre, datedebut, datefin, duree, statut, description, projet);
    }

    @PostMapping("/ModifierTach")
    public Tache ModifierTach(@RequestParam Integer id,@RequestParam String titre,@RequestParam String datedebut,@RequestParam String datefin,@RequestParam String duree,@RequestParam String statut,@RequestParam String description,@RequestParam int projet) {
        return tacheMetier.ModifierTach(id, titre, datedebut, datefin, duree, statut, description,projet);
    }

    @PostMapping("/SuppTach")
    public Boolean SuppTach(@RequestParam int id) {
        tacheMetier.SuppTach(id);
        return true;
    }
}
