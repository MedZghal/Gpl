/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Evenement;

/**
 *
 * @author ProSYS
 */
public interface EvenementMetier {
    public Evenement AjouterEvt(String titre, String description, int projet) ;
    public Evenement ModifierEvt(Integer id, String titre, String description, int projet);
    public Boolean SuppEvt(int id);
}
