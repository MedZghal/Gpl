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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "activite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a")
    , @NamedQuery(name = "Activite.findById", query = "SELECT a FROM Activite a WHERE a.id = :id")
    , @NamedQuery(name = "Activite.findByDate", query = "SELECT a FROM Activite a WHERE a.date = :date")
    , @NamedQuery(name = "Activite.findByType", query = "SELECT a FROM Activite a WHERE a.type = :type")
    , @NamedQuery(name = "Activite.findByDescription", query = "SELECT a FROM Activite a WHERE a.description = :description")})
public class Activite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
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

    public Activite() {
    }

    public Activite(String date, String type, String description, Projet projet) {
        this.date = date;
        this.type = type;
        this.description = description;
        this.projet = projet;
    }

    public Activite(Integer id, String date, String type, String description, Projet projet) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.description = description;
        this.projet = projet;
    }
    
    
    
    public Activite(Integer id) {
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
        if (!(object instanceof Activite)) {
            return false;
        }
        Activite other = (Activite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Activite[ id=" + id + " ]";
    }
    
}
