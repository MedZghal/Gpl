package com.projet.gpl.metier;

import com.projet.gpl.dao.DBFileUploadRepository;
import com.projet.gpl.dao.ProjetRepository;
import com.projet.gpl.dao.UtilisateurRepository;
import com.projet.gpl.entites.Fichier;
import com.projet.gpl.entites.Projet;
import com.projet.gpl.entites.Utilisateur;
import com.projet.gpl.exception.FileStorageException;
import com.projet.gpl.exception.MyFileNotFoundException;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DBFileUploadMetierImpl implements DBFileUploadMetier
{
    @Autowired
    private DBFileUploadRepository bFileUploadRepository;
    
    @Autowired
    private ProjetRepository projetRepository;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Override
    public Fichier storeFile(final MultipartFile file , int projet ,int utilisateur) {
        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Projet p = projetRepository.getOne(projet);
            Utilisateur util = utilisateurRepository.getOne(utilisateur);
            final Fichier dbFile = new Fichier(fileName, (new SimpleDateFormat("dd/MM/YYYY").format(new Date()))+"",(file.getSize()+""), file.getBytes(),file.getContentType(),p,util);
            return (Fichier)this.bFileUploadRepository.save((Fichier)dbFile);
        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", (Throwable)ex);
        }
    }
    
    
    
    @Override
    public List<Fichier> getAllFile() {
        return (List<Fichier>)this.bFileUploadRepository.findAll();
    }
    
 

    @Override
    public Fichier getFile(String fileId) {
        return this.bFileUploadRepository.findById(fileId).orElseThrow(() -> {
             return (new MyFileNotFoundException("File not found with id " + fileId));
        });
    }

    @Override
    public void DeleteFile(String fileId) {
        this.bFileUploadRepository.deleteById(fileId);
    }

    @Override
    public List<Fichier> GetFilesUploadByPROJET(int numIntervention) {
        return bFileUploadRepository.GetFilesUploadByPROJET(numIntervention);
    }

}
