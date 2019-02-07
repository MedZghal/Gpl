/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Gestionnaire;

/**
 *
 * @author ProSYS
 */
public interface GestionnaireMetier {
    Gestionnaire AjouterGes(String nom, String prenom, String email, String tel, String categorie, String tags, String pass, String fichierimge);
    Gestionnaire ModifierGes(Integer id, String nom, String prenom, String email, String tel, String categorie, String tags, String pass, String fichierimge);
    Boolean SuppGes(int id);
}
