/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.entites.Projet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class ProjetMetierImpl implements ProjetMetier{

    @Autowired
    public ProjetRepository projetRepository;
    
    @Override
    public List<Projet> GetListProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet AjouterProjet(String titre, String type, String descp) {
        Projet p = new Projet(titre, type, descp);
        return projetRepository.save(p);
    }

    @Override
    public Projet ModifierProjet(Integer id, String titre, String type, String descp) {
        Projet p = new Projet(id, titre, type, descp);
        return projetRepository.save(p);
    }

    @Override
    public Boolean SuppProjet(int id) {
        projetRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Projet> GetProjetById(Integer id) {
        return projetRepository.findById(id);
    }

   
    
}
