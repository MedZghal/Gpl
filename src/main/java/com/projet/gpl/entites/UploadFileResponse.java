/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.gpl.entites;

/**
 *
 * @author layes
 */
public class UploadFileResponse
{
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    
    public UploadFileResponse(final String fileName, final String fileDownloadUri, final String fileType, final long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }
    
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
    
    public void setFileDownloadUri(final String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }
    
    public void setFileType(final String fileType) {
        this.fileType = fileType;
    }
    
    public void setSize(final long size) {
        this.size = size;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public String getFileDownloadUri() {
        return this.fileDownloadUri;
    }
    
    public String getFileType() {
        return this.fileType;
    }
    
    public long getSize() {
        return this.size;
    }
}

