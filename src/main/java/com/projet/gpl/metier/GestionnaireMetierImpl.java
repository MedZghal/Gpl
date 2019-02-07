/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.FichierRepository;
import com.projet.gpl.dao.GestionnaireRepository;
import com.projet.gpl.entites.Fichier;
import com.projet.gpl.entites.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class GestionnaireMetierImpl implements GestionnaireMetier{

    @Autowired
    public GestionnaireRepository gestionnaireRepository;
    
    @Autowired
    public FichierRepository fichierRepository;
    
    @Override
    public Gestionnaire AjouterGes(String nom, String prenom, String email, String tel, String categorie, String tags, String pass, String fichierimge) {
        Fichier f = fichierRepository.getOne(fichierimge);
        Gestionnaire g = new Gestionnaire(nom, prenom, email, tel, categorie, tags, pass, f);
        return gestionnaireRepository.save(g);
    }

    @Override
    public Gestionnaire ModifierGes(Integer id, String nom, String prenom, String email, String tel, String categorie, String tags, String pass, String fichierimge) {
        Fichier f = fichierRepository.getOne(fichierimge);
        Gestionnaire g = new Gestionnaire(id, nom, prenom, email, tel, categorie, tags, pass, f);
        return gestionnaireRepository.save(g);
    }

    @Override
    public Boolean SuppGes(int id) {
        gestionnaireRepository.deleteById(id);
        return true;
    }
    
}
