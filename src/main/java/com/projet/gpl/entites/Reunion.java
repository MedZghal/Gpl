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
@Table(name = "reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")
    , @NamedQuery(name = "Reunion.findById", query = "SELECT r FROM Reunion r WHERE r.id = :id")
    , @NamedQuery(name = "Reunion.findByTitre", query = "SELECT r FROM Reunion r WHERE r.titre = :titre")
    , @NamedQuery(name = "Reunion.findByDescription", query = "SELECT r FROM Reunion r WHERE r.description = :description")
    , @NamedQuery(name = "Reunion.findByDate", query = "SELECT r FROM Reunion r WHERE r.date = :date")
    , @NamedQuery(name = "Reunion.findByHeuredebut", query = "SELECT r FROM Reunion r WHERE r.heuredebut = :heuredebut")
    , @NamedQuery(name = "Reunion.findByHeurefin", query = "SELECT r FROM Reunion r WHERE r.heurefin = :heurefin")})
public class Reunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "titre")
    private String titre;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @Size(max = 50)
    @Column(name = "heuredebut")
    private String heuredebut;
    @Size(max = 50)
    @Column(name = "heurefin")
    private String heurefin;
    @JoinColumn(name = "projet", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;

    public Reunion() {
    }

    public Reunion(Integer id, String titre, String description, String date, String heuredebut, String heurefin, Projet projet) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
        this.projet = projet;
    }

    public Reunion(String titre, String description, String date, String heuredebut, String heurefin, Projet projet) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.heuredebut = heuredebut;
        this.heurefin = heurefin;
        this.projet = projet;
    }

    
    public Reunion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(String heuredebut) {
        this.heuredebut = heuredebut;
    }

    public String getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(String heurefin) {
        this.heurefin = heurefin;
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
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Reunion[ id=" + id + " ]";
    }
    
}
