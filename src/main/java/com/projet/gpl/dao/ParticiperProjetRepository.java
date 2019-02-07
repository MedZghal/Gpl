/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.dao;

import com.projet.gpl.entites.Paticiper;
import com.projet.gpl.entites.PaticiperPK;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Utilisateur;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ProSYS
 */
@Repository
public interface ParticiperProjetRepository extends JpaRepository<Paticiper,PaticiperPK>{
    
    @Query("SELECT p.projet1 FROM Paticiper p WHERE p.paticiperPK.utilisateur = :utilisateur")
    List<Projet> GetListProjetByUtilisateur(@Param("utilisateur") int utilisateur);
    
    @Query("SELECT p.utilisateur1 FROM Paticiper p WHERE p.paticiperPK.projet = :projet")
    List<Utilisateur> GetListUtilisateurByProjet(@Param("projet") int projet);
    
    
    @Modifying
    @Query("DELETE FROM  Paticiper p WHERE p.paticiperPK.projet = :projet AND p.paticiperPK.utilisateur != :utilisateur")
    @Transactional
    int DeleteAllPar(@Param("projet") int projet,@Param("utilisateur") int utilisateur);
}
