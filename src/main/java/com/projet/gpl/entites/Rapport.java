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
@Table(name = "rapport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rapport.findAll", query = "SELECT r FROM Rapport r")
    , @NamedQuery(name = "Rapport.findById", query = "SELECT r FROM Rapport r WHERE r.id = :id")
    , @NamedQuery(name = "Rapport.findByDate", query = "SELECT r FROM Rapport r WHERE r.date = :date")
    , @NamedQuery(name = "Rapport.findByType", query = "SELECT r FROM Rapport r WHERE r.type = :type")
    , @NamedQuery(name = "Rapport.findByDescription", query = "SELECT r FROM Rapport r WHERE r.description = :description")})
public class Rapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "projet", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;

    public Rapport() {
    }

    public Rapport(Integer id, String date, String type, String description, Projet projet) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.description = description;
        this.projet = projet;
    }

    public Rapport(String date, String type, String description, Projet projet) {
        this.date = date;
        this.type = type;
        this.description = description;
        this.projet = projet;
    }

    
    public Rapport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Rapport)) {
            return false;
        }
        Rapport other = (Rapport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Rapport[ id=" + id + " ]";
    }
    
}
