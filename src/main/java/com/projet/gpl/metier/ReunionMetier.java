/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Reunion;

/**
 *
 * @author ProSYS
 */
public interface ReunionMetier {
    Reunion AjouterReun(String titre, String description, String date, String heuredebut, String heurefin, int projet);
    Reunion ModifierReun(Integer id, String titre, String description, String date, String heuredebut, String heurefin, int projet);
    Boolean SuppReun(int id);
}
