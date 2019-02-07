/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ActiviteRepository;
import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.entites.Activite;
import com.projet.gpl.entites.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class ActiviteMetierImpl implements ActiviteMetier{

    @Autowired
    public ActiviteRepository activiteRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
     
    @Override
    public Activite AjouterAct(String date, String type, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Activite act = new Activite(date, type, description, p);
        return activiteRepository.save(act);
    }

    @Override
    public Activite ModifierAct(int id, String date, String type, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Activite act = new Activite(id, date, type, description,p);
        return activiteRepository.save(act);
    }

    @Override
    public Boolean SuppAct(int id) {
        activiteRepository.deleteById(id);
        return true;
    }
    
}
