/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Evenement;
import com.projet.gpl.metier.EvenementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class EvenementService {
    
    @Autowired 
    public EvenementMetier evenementMetier;
    
    @PostMapping("/AjouterEvt")
    public Evenement AjouterEvt(@RequestParam String titre,@RequestParam String description,@RequestParam int projet) {
        return evenementMetier.AjouterEvt(titre, description, projet);
    }

    @PostMapping("/ModifierEvt")
    public Evenement ModifierEvt(@RequestParam Integer id,@RequestParam String titre,@RequestParam String description,@RequestParam int projet) {
        return evenementMetier.ModifierEvt(id, titre, description, projet);
    }

    @PostMapping("/SuppEvt")
    public Boolean SuppEvt(@RequestParam int id) {
        evenementMetier.SuppEvt(id);
        return true;
    }
}
