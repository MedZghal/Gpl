/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ProSYS
 */
@Embeddable
public class ChatmsgPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "chainediscussion")
    private int chainediscussion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utilisateur")
    private int utilisateur;

    public ChatmsgPK() {
    }

    public ChatmsgPK(int chainediscussion, int utilisateur) {
        this.chainediscussion = chainediscussion;
        this.utilisateur = utilisateur;
    }

    public int getChainediscussion() {
        return chainediscussion;
    }

    public void setChainediscussion(int chainediscussion) {
        this.chainediscussion = chainediscussion;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) chainediscussion;
        hash += (int) utilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatmsgPK)) {
            return false;
        }
        ChatmsgPK other = (ChatmsgPK) object;
        if (this.chainediscussion != other.chainediscussion) {
            return false;
        }
        if (this.utilisateur != other.utilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.ChatmsgPK[ chainediscussion=" + chainediscussion + ", utilisateur=" + utilisateur + " ]";
    }
    
}
