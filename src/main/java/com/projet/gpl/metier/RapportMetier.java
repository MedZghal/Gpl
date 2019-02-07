/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Rapport;

/**
 *
 * @author ProSYS
 */
public interface RapportMetier {
    Rapport AjouterRapp(String date, String type, String description,int projet);
    Rapport ModifierRapp(Integer id, String date, String type, String description,int projet);
    Boolean SuppRapp(int id);
}
