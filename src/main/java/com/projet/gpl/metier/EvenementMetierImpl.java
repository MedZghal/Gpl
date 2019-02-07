/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.EvenementRepository;
import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.entites.Evenement;
import com.projet.gpl.entites.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class EvenementMetierImpl implements EvenementMetier{

    @Autowired
    public EvenementRepository evenementRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
    
    
    @Override
    public Evenement AjouterEvt(String titre, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Evenement ev = new Evenement(titre, description, p);
        return evenementRepository.save(ev);
    }

    @Override
    public Evenement ModifierEvt(Integer id, String titre, String description, int projet) {
        Projet p = projetRepository.getOne(projet);
        Evenement ev = new Evenement(id, titre, description, p);
        return evenementRepository.save(ev);
    }

    @Override
    public Boolean SuppEvt(int id) {
        evenementRepository.deleteById(id);
        return true;
    }
    
}
