/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "espacedetravail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espacedetravail.findAll", query = "SELECT e FROM Espacedetravail e")
    , @NamedQuery(name = "Espacedetravail.findById", query = "SELECT e FROM Espacedetravail e WHERE e.id = :id")
    , @NamedQuery(name = "Espacedetravail.findByTitre", query = "SELECT e FROM Espacedetravail e WHERE e.titre = :titre")
    , @NamedQuery(name = "Espacedetravail.findByCategorie", query = "SELECT e FROM Espacedetravail e WHERE e.categorie = :categorie")
    , @NamedQuery(name = "Espacedetravail.findByDescription", query = "SELECT e FROM Espacedetravail e WHERE e.description = :description")})
public class Espacedetravail implements Serializable {

    @Size(max = 50)
    @Column(name = "titre")
    private String titre;
    @Size(max = 50)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 200)
    @Column(name = "description")
    private String description;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "espacedetrail")
    private Collection<Projet> projetCollection;

    public Espacedetravail() {
    }

    public Espacedetravail(String titre, String categorie, String description) {
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
    }

    public Espacedetravail( Integer id,String titre, String categorie, String description) {
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.id = id;
    }
    
    
    public Espacedetravail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    @JsonIgnore
    public Collection<Projet> getProjetCollection() {
        return projetCollection;
    }

    public void setProjetCollection(Collection<Projet> projetCollection) {
        this.projetCollection = projetCollection;
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
        if (!(object instanceof Espacedetravail)) {
            return false;
        }
        Espacedetravail other = (Espacedetravail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Espacedetravail[ id=" + id + " ]";
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
