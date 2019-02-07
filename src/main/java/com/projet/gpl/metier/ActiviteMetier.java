/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Activite;

/**
 *
 * @author ProSYS
 */
public interface ActiviteMetier {
    Activite AjouterAct(String date, String type, String description, int projet);
    Activite ModifierAct(int id ,String date, String type, String description , int projet);
    Boolean SuppAct(int id);
}
