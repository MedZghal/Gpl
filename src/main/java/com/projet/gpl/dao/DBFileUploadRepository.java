package com.projet.gpl.dao;





import com.projet.gpl.entites.Fichier;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface DBFileUploadRepository extends JpaRepository<Fichier, String>
{
    
    @Query("SELECT f.id AS id,f.titre AS fileName,f.type AS fileType FROM Fichier f WHERE f.projet.id = :projet")
    public List<Fichier> GetFilesUploadByPROJET(@Param("projet") int projet);

}
