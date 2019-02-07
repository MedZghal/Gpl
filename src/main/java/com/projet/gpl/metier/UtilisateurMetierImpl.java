/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.UtilisateurRepository;
import com.projet.gpl.entites.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class UtilisateurMetierImpl implements UtilisateurMetier{

    @Autowired
    public UtilisateurRepository repository;
    
    @Override
    public List<Utilisateur> GetListUtilisateurs() {
        return  repository.findAll();
    }

    @Override
    public Utilisateur LogIn(String email, String pass) {
        return repository.LogIn(email, pass);
    }

    @Override
    public Utilisateur AjouterUtilisateur(Utilisateur u) {
        return  repository.save(u);
    }
    
}
