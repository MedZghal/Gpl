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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "fichier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichier.findAll", query = "SELECT f FROM Fichier f")
    , @NamedQuery(name = "Fichier.findById", query = "SELECT f FROM Fichier f WHERE f.id = :id")
    , @NamedQuery(name = "Fichier.findByTitre", query = "SELECT f FROM Fichier f WHERE f.titre = :titre")
    , @NamedQuery(name = "Fichier.findByDate", query = "SELECT f FROM Fichier f WHERE f.date = :date")
    , @NamedQuery(name = "Fichier.findByTaille", query = "SELECT f FROM Fichier f WHERE f.taille = :taille")
    , @NamedQuery(name = "Fichier.findByType", query = "SELECT f FROM Fichier f WHERE f.type = :type")})
public class Fichier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Size(max = 300)
    @Column(name = "titre")
    private String titre;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @Size(max = 50)
    @Column(name = "taille")
    private String taille;
    @Lob
    @Column(name = "data")
    private byte[] data;
    @Size(max = 300)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "projet", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "fichierimge")
    private Collection<Gestionnaire> gestionnaireCollection;
    @OneToMany(mappedBy = "fichierimg")
    private Collection<Utilisateur> utilisateurCollection;

    public Fichier() {
    }

    public Fichier(String titre, String date, String taille, byte[] data, String type, Projet projet,Utilisateur utilisateur) {
        this.titre = titre;
        this.date = date;
        this.taille = taille;
        this.data = data;
        this.type = type;
        this.utilisateur = utilisateur;
        this.projet = projet;
    }
    
    

    public Fichier(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @JsonIgnore
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Gestionnaire> getGestionnaireCollection() {
        return gestionnaireCollection;
    }

    public void setGestionnaireCollection(Collection<Gestionnaire> gestionnaireCollection) {
        this.gestionnaireCollection = gestionnaireCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
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
        if (!(object instanceof Fichier)) {
            return false;
        }
        Fichier other = (Fichier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Fichier[ id=" + id + " ]";
    }
    
}
