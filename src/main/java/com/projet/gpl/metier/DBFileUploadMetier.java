package com.projet.gpl.metier;




import com.projet.gpl.entites.Fichier;
import org.springframework.web.multipart.*;
import java.util.*;

public interface DBFileUploadMetier
{
    Fichier storeFile(final MultipartFile file , int projet,int utilisateur);
    
    Fichier getFile(final String fileId);
    
    void DeleteFile(final String fileId);
    
    List<Fichier> getAllFile();
    
    List<Fichier> GetFilesUploadByPROJET(int projet);
}
