package com.info.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.info.model.InfoModel;

@Service
public interface InfoService {
	
	List<InfoModel> insert(List<InfoModel> infoModels, List<MultipartFile> files);

}
