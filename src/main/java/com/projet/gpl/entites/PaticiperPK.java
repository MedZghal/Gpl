/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ProSYS
 */
@Embeddable
public class PaticiperPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "utilisateur")
    private int utilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projet")
    private int projet;

    public PaticiperPK() {
    }

    public PaticiperPK(int utilisateur, int projet) {
        this.utilisateur = utilisateur;
        this.projet = projet;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getProjet() {
        return projet;
    }

    public void setProjet(int projet) {
        this.projet = projet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) utilisateur;
        hash += (int) projet;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaticiperPK)) {
            return false;
        }
        PaticiperPK other = (PaticiperPK) object;
        if (this.utilisateur != other.utilisateur) {
            return false;
        }
        if (this.projet != other.projet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.PaticiperPK[ utilisateur=" + utilisateur + ", projet=" + projet + " ]";
    }
    
}
