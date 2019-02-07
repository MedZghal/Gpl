/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.dao.ReunionRepository;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Reunion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class ReunionMetierImpl implements ReunionMetier{

    @Autowired
    public ReunionRepository reunionRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
    
    @Override
    public Reunion AjouterReun(String titre, String description, String date, String heuredebut, String heurefin, int projet) {
        Projet p =projetRepository.getOne(projet);
        Reunion r = new Reunion(titre, description, date, heuredebut, heurefin, p);
        return reunionRepository.save(r);
    }

    @Override
    public Reunion ModifierReun(Integer id, String titre, String description, String date, String heuredebut, String heurefin, int projet) {
        Projet p =projetRepository.getOne(projet);
        Reunion r = new Reunion(id, titre, description, date, heuredebut, heurefin, p);
        return reunionRepository.save(r);
    }

    @Override
    public Boolean SuppReun(int id) {
        reunionRepository.deleteById(id);
        return true;
    }
    
}
