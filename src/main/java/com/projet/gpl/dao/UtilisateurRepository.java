/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.dao;

import com.projet.gpl.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ProSYS
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.pass = :pass")
        Utilisateur LogIn(@Param("email")String email , @Param("pass") String pass);
}
