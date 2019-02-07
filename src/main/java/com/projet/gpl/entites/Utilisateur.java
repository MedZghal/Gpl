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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByTel", query = "SELECT u FROM Utilisateur u WHERE u.tel = :tel")
    , @NamedQuery(name = "Utilisateur.findByTags", query = "SELECT u FROM Utilisateur u WHERE u.tags = :tags")
    , @NamedQuery(name = "Utilisateur.findByPass", query = "SELECT u FROM Utilisateur u WHERE u.pass = :pass")
    , @NamedQuery(name = "Utilisateur.findByType", query = "SELECT u FROM Utilisateur u WHERE u.type = :type")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
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
    @Size(max = 200)
    @Column(name = "tags")
    private String tags;
    @Size(max = 50)
    @Column(name = "pass")
    private String pass;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Fichier> fichierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur1")
    private Collection<Chatmsg> chatmsgCollection;
    @JoinColumn(name = "fichierimg", referencedColumnName = "id")
    @ManyToOne
    private Fichier fichierimg;
    @JoinColumn(name = "gestionnaire", referencedColumnName = "id")
    @ManyToOne
    private Gestionnaire gestionnaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur1")
    private Collection<Paticiper> paticiperCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(String nom, String prenom, String email, String tel, String tags, String pass, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.tags = tags;
        this.pass = pass;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public Collection<Chatmsg> getChatmsgCollection() {
        return chatmsgCollection;
    }

    public void setChatmsgCollection(Collection<Chatmsg> chatmsgCollection) {
        this.chatmsgCollection = chatmsgCollection;
    }

    public Fichier getFichierimg() {
        return fichierimg;
    }

    public void setFichierimg(Fichier fichierimg) {
        this.fichierimg = fichierimg;
    }

    @JsonIgnore
    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Paticiper> getPaticiperCollection() {
        return paticiperCollection;
    }

    public void setPaticiperCollection(Collection<Paticiper> paticiperCollection) {
        this.paticiperCollection = paticiperCollection;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Utilisateur[ id=" + id + " ]";
    }
    
}
