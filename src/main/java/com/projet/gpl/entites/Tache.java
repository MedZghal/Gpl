/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tache")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t")
    , @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id")
    , @NamedQuery(name = "Tache.findByTitre", query = "SELECT t FROM Tache t WHERE t.titre = :titre")
    , @NamedQuery(name = "Tache.findByDatedebut", query = "SELECT t FROM Tache t WHERE t.datedebut = :datedebut")
    , @NamedQuery(name = "Tache.findByDatefin", query = "SELECT t FROM Tache t WHERE t.datefin = :datefin")
    , @NamedQuery(name = "Tache.findByDuree", query = "SELECT t FROM Tache t WHERE t.duree = :duree")
    , @NamedQuery(name = "Tache.findByStatut", query = "SELECT t FROM Tache t WHERE t.statut = :statut")})
public class Tache implements Serializable {

    @Size(max = 50)
    @Column(name = "titre")
    private String titre;
    @Size(max = 50)
    @Column(name = "datedebut")
    private String datedebut;
    @Size(max = 50)
    @Column(name = "datefin")
    private String datefin;
    @Size(max = 50)
    @Column(name = "duree")
    private String duree;
    @Size(max = 50)
    @Column(name = "statut")
    private String statut;
    @Size(max = 500)
    @Column(name = "description")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "projet", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;

    public Tache() {
    }

    public Tache( Integer id,String titre, String datedebut, String datefin, String duree, String statut, String description, Projet projet) {
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.duree = duree;
        this.statut = statut;
        this.description = description;
        this.id = id;
        this.projet = projet;
    }

    public Tache(String titre, String datedebut, String datefin, String duree, String statut, String description, Projet projet) {
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.duree = duree;
        this.statut = statut;
        this.description = description;
        this.projet = projet;
    }
    
    public Tache(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @JsonIgnore
    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Tache[ id=" + id + " ]";
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
