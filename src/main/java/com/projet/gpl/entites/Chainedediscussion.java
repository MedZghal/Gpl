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
@Table(name = "chainedediscussion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chainedediscussion.findAll", query = "SELECT c FROM Chainedediscussion c")
    , @NamedQuery(name = "Chainedediscussion.findById", query = "SELECT c FROM Chainedediscussion c WHERE c.id = :id")
    , @NamedQuery(name = "Chainedediscussion.findByDate", query = "SELECT c FROM Chainedediscussion c WHERE c.date = :date")})
public class Chainedediscussion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chainedediscussion")
    private Collection<Chatmsg> chatmsgCollection;
    @JoinColumn(name = "projet", referencedColumnName = "id")
    @ManyToOne
    private Projet projet;

    public Chainedediscussion() {
    }

    public Chainedediscussion(Integer id) {
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

    @XmlTransient
    public Collection<Chatmsg> getChatmsgCollection() {
        return chatmsgCollection;
    }

    public void setChatmsgCollection(Collection<Chatmsg> chatmsgCollection) {
        this.chatmsgCollection = chatmsgCollection;
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
        if (!(object instanceof Chainedediscussion)) {
            return false;
        }
        Chainedediscussion other = (Chainedediscussion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Chainedediscussion[ id=" + id + " ]";
    }
    
}
