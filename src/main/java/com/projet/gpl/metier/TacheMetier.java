/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Tache;

/**
 *
 * @author ProSYS
 */
public interface TacheMetier {
    Tache AjouterTach(String titre, String datedebut, String datefin, String duree, String statut, String description, int projet);
    Tache ModifierTach( Integer id,String titre, String datedebut, String datefin, String duree, String statut, String description, int projet);
    Boolean SuppTach(int id);
}
