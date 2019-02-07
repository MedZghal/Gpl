/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "paticiper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paticiper.findAll", query = "SELECT p FROM Paticiper p")
    , @NamedQuery(name = "Paticiper.findByUtilisateur", query = "SELECT p.utilisateur1 FROM Paticiper p WHERE p.paticiperPK.projet = :projet")
    , @NamedQuery(name = "Paticiper.findByProjet", query = "SELECT p FROM Paticiper p WHERE p.paticiperPK.projet = :projet")
    , @NamedQuery(name = "Paticiper.findByDate", query = "SELECT p FROM Paticiper p WHERE p.date = :date")})
public class Paticiper implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaticiperPK paticiperPK;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "projet", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projet projet1;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur1;

    public Paticiper() {
    }

    public Paticiper(PaticiperPK paticiperPK) {
        this.paticiperPK = paticiperPK;
    }

    public Paticiper(int utilisateur, int projet, String date) {
        this.paticiperPK = new PaticiperPK(utilisateur, projet);
        this.date = date;
    }

    
    public Paticiper(int utilisateur, int projet) {
        this.paticiperPK = new PaticiperPK(utilisateur, projet);
    }

    public PaticiperPK getPaticiperPK() {
        return paticiperPK;
    }

    public void setPaticiperPK(PaticiperPK paticiperPK) {
        this.paticiperPK = paticiperPK;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Projet getProjet1() {
        return projet1;
    }

    public void setProjet1(Projet projet1) {
        this.projet1 = projet1;
    }

    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paticiperPK != null ? paticiperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paticiper)) {
            return false;
        }
        Paticiper other = (Paticiper) object;
        if ((this.paticiperPK == null && other.paticiperPK != null) || (this.paticiperPK != null && !this.paticiperPK.equals(other.paticiperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Paticiper[ paticiperPK=" + paticiperPK + " ]";
    }
    
}
