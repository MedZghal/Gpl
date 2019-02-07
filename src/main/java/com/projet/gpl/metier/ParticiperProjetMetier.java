/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Paticiper;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Utilisateur;
import java.util.List;

/**
 *
 * @author ProSYS
 */
public interface ParticiperProjetMetier {
    List<Projet> GetListProjetByUtilisateur(int utilisateur);
    List<Utilisateur> GetListUtilisateurByProjet(int projet);
    Paticiper AjouterPar(int utilisateur, int projet, String date);
    int DeleteAllPar(int projet,int utilisateur);
}
