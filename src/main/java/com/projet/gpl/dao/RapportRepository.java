/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.dao;

import com.projet.gpl.entites.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ProSYS
 */
@Repository
public interface RapportRepository extends JpaRepository<Rapport,Integer>{
    
}
