/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.services;

import com.projet.gpl.entites.Paticiper;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Utilisateur;
import com.projet.gpl.metier.ParticiperProjetMetier;
import java.util.List;
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
public class ParticiperProjetService {
    
    @Autowired
    public ParticiperProjetMetier participerProjetMetier;
    
    @GetMapping("/GetListProjetByUtilisateur")
    public List<Projet> GetListProjetByUtilisateur(@RequestParam int utilisateur) {
        return participerProjetMetier.GetListProjetByUtilisateur(utilisateur);
    }
    
    @PostMapping("/AjouterPar")
    public Paticiper AjouterPar(@RequestParam  int utilisateur,@RequestParam  int projet,@RequestParam  String date) {
        return participerProjetMetier.AjouterPar(utilisateur, projet, date);
    }
    
    @GetMapping("/GetListUtilisateurByProjet")
    public List<Utilisateur> GetListUtilisateurByProjet(@RequestParam int projet) {
        return participerProjetMetier.GetListUtilisateurByProjet(projet);
    }
    
    
    @PostMapping("/DeleteAllPar")
    public int DeleteAllPar(@RequestParam int projet,@RequestParam int utilisateur) {
        return participerProjetMetier.DeleteAllPar(projet,utilisateur);
    }
}
