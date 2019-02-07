/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.dao.TacheRepository;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class TacheMetierImpl implements TacheMetier{

    @Autowired
    public TacheRepository tacheRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
    
    @Override
    public Tache AjouterTach(String titre, String datedebut, String datefin, String duree, String statut, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Tache t = new Tache(titre, datedebut, datefin, duree, statut, description, p);
        return tacheRepository.save(t);
    }

    @Override
    public Tache ModifierTach(Integer id, String titre, String datedebut, String datefin, String duree, String statut, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Tache t = new Tache(id, titre, datedebut, datefin, duree, statut, description, p);
        return tacheRepository.save(t);
    }

    @Override
    public Boolean SuppTach(int id) {
        tacheRepository.deleteById(id);
        return true;
    }
    
}
