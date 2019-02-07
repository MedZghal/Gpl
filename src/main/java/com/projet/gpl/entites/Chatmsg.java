/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "chatmsg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatmsg.findAll", query = "SELECT c FROM Chatmsg c")
    , @NamedQuery(name = "Chatmsg.findByChainediscussion", query = "SELECT c FROM Chatmsg c WHERE c.chatmsgPK.chainediscussion = :chainediscussion")
    , @NamedQuery(name = "Chatmsg.findByUtilisateur", query = "SELECT c FROM Chatmsg c WHERE c.chatmsgPK.utilisateur = :utilisateur")
    , @NamedQuery(name = "Chatmsg.findByDescription", query = "SELECT c FROM Chatmsg c WHERE c.description = :description")})
public class Chatmsg implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatmsgPK chatmsgPK;
    @Size(max = 300)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "chainediscussion", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Chainedediscussion chainedediscussion;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur1;

    public Chatmsg() {
    }

    public Chatmsg(ChatmsgPK chatmsgPK) {
        this.chatmsgPK = chatmsgPK;
    }

    public Chatmsg(int chainediscussion, int utilisateur) {
        this.chatmsgPK = new ChatmsgPK(chainediscussion, utilisateur);
    }

    public ChatmsgPK getChatmsgPK() {
        return chatmsgPK;
    }

    public void setChatmsgPK(ChatmsgPK chatmsgPK) {
        this.chatmsgPK = chatmsgPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public Chainedediscussion getChainedediscussion() {
        return chainedediscussion;
    }

    public void setChainedediscussion(Chainedediscussion chainedediscussion) {
        this.chainedediscussion = chainedediscussion;
    }

    @JsonIgnore
    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatmsgPK != null ? chatmsgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatmsg)) {
            return false;
        }
        Chatmsg other = (Chatmsg) object;
        if ((this.chatmsgPK == null && other.chatmsgPK != null) || (this.chatmsgPK != null && !this.chatmsgPK.equals(other.chatmsgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Chatmsg[ chatmsgPK=" + chatmsgPK + " ]";
    }
    
}
