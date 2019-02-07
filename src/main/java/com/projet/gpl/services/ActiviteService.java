/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Activite;
import com.projet.gpl.metier.ActiviteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class ActiviteService {
    
    @Autowired
    public ActiviteMetier activiteMetier;
    
    @PostMapping("/AjouterAct")
    public Activite AjouterAct(@RequestParam String date,@RequestParam String type,@RequestParam String description,@RequestParam int projet) {
        return activiteMetier.AjouterAct(date, type, description, projet);
    }

    @PostMapping("/ModifierAct")
    public Activite ModifierAct(@RequestParam int id,@RequestParam String date,@RequestParam String type,@RequestParam String description,@RequestParam int projet) {
        return activiteMetier.ModifierAct(id, date, type, description, projet);
    }

    @PostMapping("/SuppAct")
    public Boolean SuppAct(@RequestParam int id) {
        activiteMetier.SuppAct(id);
        return true;
    }
}
