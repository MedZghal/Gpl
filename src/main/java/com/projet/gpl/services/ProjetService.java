/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Projet;
import com.projet.gpl.metier.ProjetMetier;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ProSYS
 */
@RestController
public class ProjetService {
    
    @Autowired
    public ProjetMetier projetMetier;
    
    @GetMapping("/GetListProjet")
    public List<Projet> GetListProjet() {
        return projetMetier.GetListProjet();
    }
    
    @PostMapping("/AjouterProjet")
    public Projet AjouterProjet(@RequestParam String titre,@RequestParam String type,@RequestParam String descp) {
       return projetMetier.AjouterProjet(titre, type, descp);
    }

    @PostMapping("/ModifierProjet")
    public Projet ModifierProjet(@RequestParam Integer id,@RequestParam String titre,@RequestParam String type,@RequestParam String descp) {
        return projetMetier.ModifierProjet(id, titre, type, descp);
    }

    @PostMapping("/SuppProjet")
    public Boolean SuppProjet(@RequestParam int id) {
        projetMetier.SuppProjet(id);
        return true;
    }
   
    @GetMapping("/GetProjetById")
    public Optional<Projet> GetProjetById(@RequestParam Integer id) {
        return projetMetier.GetProjetById(id);
    }
}
