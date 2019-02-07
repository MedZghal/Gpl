/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.dao.RapportRepository;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class RapportMetierImpl implements RapportMetier{

    @Autowired
    public RapportRepository rapportRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
    
    @Override
    public Rapport AjouterRapp(String date, String type, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Rapport rapp = new Rapport(date, type, description, p);
        return rapportRepository.save(rapp);
    }

    @Override
    public Rapport ModifierRapp(Integer id, String date, String type, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Rapport rapp = new Rapport(id, date, type, description, p);
        return rapportRepository.save(rapp);
    }

    @Override
    public Boolean SuppRapp(int id) {
        rapportRepository.deleteById(id);
        return true;
    }
    
}
