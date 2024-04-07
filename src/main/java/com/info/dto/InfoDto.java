package com.info.dto;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.info.model.InfoModel;

public class InfoDto {
    private List<InfoModel> infoModels;
    private List<MultipartFile> files;

    public List<InfoModel> getInfoModels() {
        return infoModels;
    }

    public void setInfoModels(List<InfoModel> infoModels) {
        this.infoModels = infoModels;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
