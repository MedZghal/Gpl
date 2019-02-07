/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Rapport;
import com.projet.gpl.metier.RapportMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class RapportService {
    
    @Autowired
    public RapportMetier rapportMetier;
    
    @PostMapping("/AjouterRapp")
    public Rapport AjouterRapp(@RequestParam String date,@RequestParam String type,@RequestParam String description,@RequestParam int projet) {
        return rapportMetier.AjouterRapp(date, type, description, projet);
    }

    @PostMapping("/ModifierRapp")
    public Rapport ModifierRapp(@RequestParam Integer id,@RequestParam String date,@RequestParam String type,@RequestParam String description,@RequestParam int projet) {
        return rapportMetier.ModifierRapp(id, date, type, description,projet);
    }

    @PostMapping("/SuppRapp")
    public Boolean SuppRapp(@RequestParam int id) {
        rapportMetier.SuppRapp(id);
        return true;
    }
}
