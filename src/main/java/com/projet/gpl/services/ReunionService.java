/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Reunion;
import com.projet.gpl.metier.ReunionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class ReunionService {
    
    @Autowired
    public ReunionMetier reunionMetier;
    
    @PostMapping("/AjouterReun")
    public Reunion AjouterReun(@RequestParam String titre,@RequestParam String description,@RequestParam String date,@RequestParam String heuredebut,@RequestParam String heurefin,@RequestParam int projet) {
        return reunionMetier.AjouterReun(titre, description, date, heuredebut, heurefin, projet);
    }

    @PostMapping("/ModifierReun")
    public Reunion ModifierReun(@RequestParam Integer id,@RequestParam String titre,@RequestParam String description,@RequestParam String date,@RequestParam String heuredebut,@RequestParam String heurefin,@RequestParam int projet) {
        return reunionMetier.ModifierReun(id, titre, description, date, heuredebut, heurefin, projet);
    }

    @PostMapping("/SuppReun")
    public Boolean SuppReun(@RequestParam int id) {
        reunionMetier.SuppReun(id);
        return true;
    }
    
}
