/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Projet;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ProSYS
 */
public interface ProjetMetier {
    List<Projet> GetListProjet();
    Optional<Projet> GetProjetById(Integer id);
    Projet AjouterProjet(String titre, String type, String descp);
    Projet ModifierProjet(Integer id,String titre, String type, String descp);
    Boolean SuppProjet(int id);
}
