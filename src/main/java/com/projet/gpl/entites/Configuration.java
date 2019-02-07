/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c")
    , @NamedQuery(name = "Configuration.findById", query = "SELECT c FROM Configuration c WHERE c.id = :id")
    , @NamedQuery(name = "Configuration.findByNomsocite", query = "SELECT c FROM Configuration c WHERE c.nomsocite = :nomsocite")
    , @NamedQuery(name = "Configuration.findByUrl", query = "SELECT c FROM Configuration c WHERE c.url = :url")
    , @NamedQuery(name = "Configuration.findByType", query = "SELECT c FROM Configuration c WHERE c.type = :type")
    , @NamedQuery(name = "Configuration.findBySite", query = "SELECT c FROM Configuration c WHERE c.site = :site")
    , @NamedQuery(name = "Configuration.findByTel", query = "SELECT c FROM Configuration c WHERE c.tel = :tel")
    , @NamedQuery(name = "Configuration.findByEmail", query = "SELECT c FROM Configuration c WHERE c.email = :email")
    , @NamedQuery(name = "Configuration.findByPartage", query = "SELECT c FROM Configuration c WHERE c.partage = :partage")
    , @NamedQuery(name = "Configuration.findByTailleequipe", query = "SELECT c FROM Configuration c WHERE c.tailleequipe = :tailleequipe")})
public class Configuration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nomsocite")
    private String nomsocite;
    @Size(max = 50)
    @Column(name = "url")
    private String url;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "site")
    private String site;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "partage")
    private String partage;
    @Size(max = 50)
    @Column(name = "tailleequipe")
    private String tailleequipe;
    @JoinColumn(name = "gestionnaire", referencedColumnName = "id")
    @ManyToOne
    private Gestionnaire gestionnaire;

    public Configuration() {
    }

    public Configuration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomsocite() {
        return nomsocite;
    }

    public void setNomsocite(String nomsocite) {
        this.nomsocite = nomsocite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartage() {
        return partage;
    }

    public void setPartage(String partage) {
        this.partage = partage;
    }

    public String getTailleequipe() {
        return tailleequipe;
    }

    public void setTailleequipe(String tailleequipe) {
        this.tailleequipe = tailleequipe;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
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
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projet.gpl.entites.Configuration[ id=" + id + " ]";
    }
    
}
