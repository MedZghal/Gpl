package com.projet.gpl.services;


import com.projet.gpl.entites.Fichier;
import com.projet.gpl.entites.UploadFileResponse;
import com.projet.gpl.metier.DBFileUploadMetierImpl;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class FileRestService
{
    private static final Logger logger;
    @Autowired
    private DBFileUploadMetierImpl DBFileStorageService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") final MultipartFile file, @RequestParam("projet")  int projet, @RequestParam("utilisateur") int utilisateur) {
        Fichier dbFile = this.DBFileStorageService.storeFile(file,projet,utilisateur);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(dbFile.getId()).toUriString();
        return new UploadFileResponse(dbFile.getTitre(), fileDownloadUri, file.getContentType(), file.getSize());
    }
    
    @PostMapping({ "/uploadMultipleFiles" })
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") final MultipartFile[] files, @RequestParam("projet") int projet, @RequestParam("utilisateur") int utilisateur) {
        return Arrays.asList(files).stream().map(file -> this.uploadFile(file, projet,utilisateur)).collect(Collectors.toList());
    }
    
     @GetMapping({ "/downloadFile/{fileId}" })
    public ResponseEntity<byte[]> downloadFile(@PathVariable final String fileId) {
        Fichier dbFile = this.DBFileStorageService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + dbFile.getTitre() + "\"")
                .body(dbFile.getData());
    }
    
        @GetMapping({ "/ViewFile/{fileId}" })
    public ResponseEntity<byte[]> ViewFile(@PathVariable final String fileId) {
        final Fichier dbFile = this.DBFileStorageService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=\"" + dbFile.getTitre() + "\"")
                .body(dbFile.getData());
    }
    
    @GetMapping({ "/ViewAllFile" })
    public List<Fichier> getAllFile() {
        return this.DBFileStorageService.getAllFile();
    }
    
  
    
    @PostMapping({ "/DeleteFile" })
    public String DeleteFile(@RequestParam("fileId") String fileId) {
        this.DBFileStorageService.DeleteFile(fileId);
        return "true";
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)FileRestService.class);
    }
    
    @GetMapping("/GetFilesUploadByPROJET")
    public List<Fichier> GetFilesUploadByPROJET(@RequestParam("projet")int projet) {
        return DBFileStorageService.GetFilesUploadByPROJET(projet);
    }
}
