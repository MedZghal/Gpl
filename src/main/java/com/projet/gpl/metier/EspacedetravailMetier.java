/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.metier;

import com.projet.gpl.entites.Espacedetravail;

/**
 *
 * @author ProSYS
 */
public interface EspacedetravailMetier {
    Espacedetravail AjouterEsptrv(String titre, String categorie, String description);
    Espacedetravail ModifierEsptrv( Integer id,String titre, String categorie, String description);
    Boolean SuppEsptrv(int id);
}
