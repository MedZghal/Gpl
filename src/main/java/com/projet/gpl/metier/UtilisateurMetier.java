/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Utilisateur;
import java.util.List;

/**
 *
 * @author ProSYS
 */
public interface UtilisateurMetier {
    List<Utilisateur> GetListUtilisateurs();
    Utilisateur LogIn(String email , String pass);
    Utilisateur AjouterUtilisateur(Utilisateur u);
}
