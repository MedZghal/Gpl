/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.dao.EspacedetravailRepository;
import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.entites.Espacedetravail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ProSYS
 */
@Service
public class EspacedetravailMetierImpl implements EspacedetravailMetier{

    @Autowired
    public EspacedetravailRepository espacedetravailRepository;
    
    @Autowired
    public ProjetRepository projetRepository;
    
    @Override
    public Espacedetravail AjouterEsptrv(String titre, String categorie, String description) {
        Espacedetravail esp = new Espacedetravail(titre, categorie, description);
        return espacedetravailRepository.save(esp);
    }

    @Override
    public Espacedetravail ModifierEsptrv( Integer id,String titre, String categorie, String description) {
        Espacedetravail esp = new Espacedetravail( id,titre, categorie, description);
        return espacedetravailRepository.save(esp);
    }

    @Override
    public Boolean SuppEsptrv(int id) {
        espacedetravailRepository.deleteById(id);
        return true;
    }
    
}
