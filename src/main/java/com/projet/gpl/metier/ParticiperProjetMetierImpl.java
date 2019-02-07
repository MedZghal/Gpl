/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ParticiperProjetRepository;
import com.projet.gpl.entites.Paticiper;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class ParticiperProjetMetierImpl implements ParticiperProjetMetier{

    @Autowired
    public ParticiperProjetRepository participerProjetRepository;
    
    @Override
    public List<Projet> GetListProjetByUtilisateur(int utilisateur) {
        return participerProjetRepository.GetListProjetByUtilisateur(utilisateur);
    }

    @Override
    public Paticiper AjouterPar(int utilisateur, int projet, String date) {
        Paticiper p = new Paticiper(utilisateur, projet, date);
        return participerProjetRepository.save(p);
    }

    @Override
    public List<Utilisateur> GetListUtilisateurByProjet(int projet) {
        return participerProjetRepository.GetListUtilisateurByProjet(projet);
    }

    @Override
    public int DeleteAllPar(int projet,int utilisateur) {
        return participerProjetRepository.DeleteAllPar(projet,utilisateur);
    }
    
}
