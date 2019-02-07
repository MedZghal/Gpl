/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "gestionnaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionnaire.findAll", query = "SELECT g FROM Gestionnaire g")
    , @NamedQuery(name = "Gestionnaire.findById", query = "SELECT g FROM Gestionnaire g WHERE g.id = :id")
    , @NamedQuery(name = "Gestionnaire.findByNom", query = "SELECT g FROM Gestionnaire g WHERE g.nom = :nom")
    , @NamedQuery(name = "Gestionnaire.findByPrenom", query = "SELECT g FROM Gestionnaire g WHERE g.prenom = :prenom")
    , @NamedQuery(name = "Gestionnaire.findByEmail", query = "SELECT g FROM Gestionnaire g WHERE g.email = :email")
    , @NamedQuery(name = "Gestionnaire.findByTel", query = "SELECT g FROM Gestionnaire g WHERE g.tel = :tel")
    , @NamedQuery(name = "Gestionnaire.findByCategorie", query = "SELECT g FROM Gestionnaire g WHERE g.categorie = :categorie")
    , @NamedQuery(name = "Gestionnaire.findByTags", query = "SELECT g FROM Gestionnaire g WHERE g.tags = :tags")
    , @NamedQuery(name = "Gestionnaire.findByPass", query = "SELECT g FROM Gestionnaire g WHERE g.pass = :pass")})
public class Gestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @Size(max = 50)
    @Column(name = "prenom")
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    @Size(max = 50)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 50)
    @Column(name = "tags")
    private String tags;
    @Size(max = 50)
    @Column(name = "pass")
    private String pass;
    @OneToMany(mappedBy = "gestionnaire")
    private Collection<Configuration> configurationCollection;
    @JoinColumn(name = "fichierimge", referencedColumnName = "id")
    @ManyToOne
    private Fichier fichierimge;
    @OneToMany(mappedBy = "gestionnaire")
    private Collection<Utilisateur> utilisateurCollection;

    public Gestionnaire() {
    }

    public Gestionnaire(Integer id, String nom, String prenom, String email, String tel, String categorie, String tags, String pass, Fichier fichierimge) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.categorie = categorie;
        this.tags = tags;
        this.pass = pass;
        this.fichierimge = fichierimge;
    }

    public Gestionnaire(String nom, String prenom, String email, String tel, String categorie, String tags, String pass, Fichier fichierimge) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.categorie = categorie;
        this.tags = tags;
        this.pass = pass;
        this.fichierimge = fichierimge;
    }

    
    public Gestionnaire(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<Configuration> getConfigurationCollection() {
        return configurationCollection;
    }

    public void setConfigurationCollection(Collection<Configuration> configurationCollection) {
        this.configurationCollection = configurationCollection;
    }

    public Fichier getFichierimge() {
        return fichierimge;
    }

    public void setFichierimge(Fichier fichierimge) {
        this.fichierimge = fichierimge;
    }

    @XmlTransient
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
        if (!(object instanceof Gestionnaire)) {
            return false;
        }
        Gestionnaire other = (Gestionnaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Gestionnaire[ id=" + id + " ]";
    }
    
}
