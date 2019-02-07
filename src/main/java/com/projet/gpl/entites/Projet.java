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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "projet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p")
    , @NamedQuery(name = "Projet.findById", query = "SELECT p FROM Projet p WHERE p.id = :id")
    , @NamedQuery(name = "Projet.findByTitre", query = "SELECT p FROM Projet p WHERE p.titre = :titre")
    , @NamedQuery(name = "Projet.findByType", query = "SELECT p FROM Projet p WHERE p.type = :type")
    , @NamedQuery(name = "Projet.findByDescp", query = "SELECT p FROM Projet p WHERE p.descp = :descp")})
public class Projet implements Serializable {

    @Size(max = 50)
    @Column(name = "titre")
    private String titre;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 200)
    @Column(name = "descp")
    private String descp;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "projet")
    private Collection<Fichier> fichierCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Tache> tacheCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Rapport> rapportCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Activite> activiteCollection;
    @JoinColumn(name = "espacedetrail", referencedColumnName = "id")
    @ManyToOne
    private Espacedetravail espacedetrail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet1")
    private Collection<Paticiper> paticiperCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Reunion> reunionCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Chainedediscussion> chainedediscussionCollection;
    @OneToMany(mappedBy = "projet")
    private Collection<Evenement> evenementCollection;

    public Projet() {
    }

    public Projet(String titre, String type, String descp) {
        this.titre = titre;
        this.type = type;
        this.descp = descp;
    }

    public Projet(Integer id,String titre, String type, String descp) {
        this.titre = titre;
        this.type = type;
        this.descp = descp;
        this.id = id;
    }

    
    
    public Projet(Integer id) {
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
    public Collection<Fichier> getFichierCollection() {
        return fichierCollection;
    }

    public void setFichierCollection(Collection<Fichier> fichierCollection) {
        this.fichierCollection = fichierCollection;
    }

    @XmlTransient
    public Collection<Tache> getTacheCollection() {
        return tacheCollection;
    }

    public void setTacheCollection(Collection<Tache> tacheCollection) {
        this.tacheCollection = tacheCollection;
    }

    @XmlTransient
    public Collection<Rapport> getRapportCollection() {
        return rapportCollection;
    }

    public void setRapportCollection(Collection<Rapport> rapportCollection) {
        this.rapportCollection = rapportCollection;
    }

    @XmlTransient
    public Collection<Activite> getActiviteCollection() {
        return activiteCollection;
    }

    public void setActiviteCollection(Collection<Activite> activiteCollection) {
        this.activiteCollection = activiteCollection;
    }

    
    public Espacedetravail getEspacedetrail() {
        return espacedetrail;
    }

    public void setEspacedetrail(Espacedetravail espacedetrail) {
        this.espacedetrail = espacedetrail;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Paticiper> getPaticiperCollection() {
        return paticiperCollection;
    }

    public void setPaticiperCollection(Collection<Paticiper> paticiperCollection) {
        this.paticiperCollection = paticiperCollection;
    }

    @XmlTransient
    public Collection<Reunion> getReunionCollection() {
        return reunionCollection;
    }

    public void setReunionCollection(Collection<Reunion> reunionCollection) {
        this.reunionCollection = reunionCollection;
    }

    @XmlTransient
    public Collection<Chainedediscussion> getChainedediscussionCollection() {
        return chainedediscussionCollection;
    }

    public void setChainedediscussionCollection(Collection<Chainedediscussion> chainedediscussionCollection) {
        this.chainedediscussionCollection = chainedediscussionCollection;
    }

    @XmlTransient
    public Collection<Evenement> getEvenementCollection() {
        return evenementCollection;
    }

    public void setEvenementCollection(Collection<Evenement> evenementCollection) {
        this.evenementCollection = evenementCollection;
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Projet[ id=" + id + " ]";
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
    
}
