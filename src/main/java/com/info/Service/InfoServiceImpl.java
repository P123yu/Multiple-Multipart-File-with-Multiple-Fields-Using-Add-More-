////package com.info.Service;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.info.Repository.InfoRepository;
////import com.info.model.InfoModel;
////
////
////@Service
////public class InfoServiceImpl implements InfoService {
////	
////	@Autowired
////	private InfoRepository infoRepository;
////
////	
////	@Override
////	public List<InfoModel> insert(List<InfoModel> infoModel, List<MultipartFile> file) {
////		List<InfoModel> info=infoRepository.saveAll(infoModel,file);
////		return info;
////	}
////
////}
//
////
////package com.info.Service;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.info.Repository.InfoRepository;
////import com.info.model.InfoModel;
////
////@Service
////public class InfoServiceImpl implements InfoService {
////    
////    @Autowired
////    private InfoRepository infoRepository;
////
////    @Override
////    public List<InfoModel> insert(List<InfoModel> infoModelList, List<MultipartFile> fileList) {
////        
////        for (int i = 0; i < infoModelList.size(); i++) {
////            InfoModel infoModel = infoModelList.get(i);
////            MultipartFile file = fileList.get(i);
////            
////            infoRepository.save(infoModel);
////        }
////        return infoModelList;
////    }
////}
////
//
//
//package com.info.Service;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//import java.nio.file.StandardCopyOption;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import com.info.Repository.InfoRepository;
//
//import com.info.model.InfoModel;
//
//@Service
//public class InfoServiceImpl implements InfoService {
//    
//    @Autowired
//    private InfoRepository infoRepository;
//    
//    private final String uploadDir = "C:\\Users\\piyush_kumar\\Desktop\\new";
//
////    public List<InfoModel> insert(List<InfoModel> infoList) {
////        List<InfoModel> savedList = new ArrayList<>();
////        
////        if (infoList.size() != fileList.size()) {
////            throw new IllegalArgumentException("Size of infoList and fileList must be equal");
////        }
////        
////        for (int i = 0; i < infoList.size(); i++) {
////            InfoModel info = infoList.get(i);
////            MultipartFile file = fileList.get(i);
////            
////            try {
////                // Save the InfoModel entity
////                InfoModel savedInfo = infoRepository.save(info);
////                
////                // Save file data
////                String fileData = file.getOriginalFilename();
////                Path filePath = Paths.get(uploadDir, fileData);
////                Files.createDirectories(filePath.getParent());
////                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
////                
////                // Set file-related fields of InfoModel
////                savedInfo.setFileName(fileData);
////                
////                // Add the saved entity to the list
////                savedList.add(savedInfo);
////            } catch (Exception e) {
////                // Handle IOException (e.g., log error, throw custom exception)
////                e.printStackTrace();
////                // You may want to handle this case differently based on your application's requirements
////            }
////        }
////        
////        return savedList;
////    }
//
////    @Override
////    public List<InfoModel> insert(List<InfoModel> infoModel) {
////        List<InfoModel> listInfo = new ArrayList<InfoModel>();
////        
////        for (InfoModel info : infoModel) {
////            InfoModel inf = new InfoModel();
////            inf.setAmount(info.getAmount());
////            inf.setCreated(info.getCreated());
////            inf.setCurrency(info.getCurrency());
////            inf.setExpenseType(info.getExpenseType());
////            inf.setFileName(info.getFileName());
////            inf.setFilePath(uploadDir);
////            inf.setMode(info.getMode());
////            inf.setPurpose(info.getPurpose());
////            inf.setToDate(info.getToDate());
////            // You're setting expense type twice, it's better to remove this line
////            // inf.setExpenseType(info.getExpenseType());
////            
////            // Add the copied InfoModel object to the list
////            
////            
////             
////            Path FilePath = Path.of(uploadDir, info.getFileName());
////            MultipartFile multipartFile = new MockMultipartFile("file", "filename.txt", "text/plain", "This is the content of the file.".getBytes());
////            
//////            MultipartFile multipartFile = new MockMultipartFile(info.getFileName(), new FileInputStream(new File("/home/admin/test.xlsx")));
////
////            Files.createDirectories(FilePath.getParent());
////
////            Files.copy(file.getInputStream(), FilePath, StandardCopyOption.REPLACE_EXISTING);
////
////            listInfo.add(inf);
////        }
////        
////        return listInfo;
////    }
////    
////    
////    
//    
//  
//        public List<InfoModel> insert(List<InfoModel> infoModels, List<MultipartFile> files) {
//            List<InfoModel> listInfo = new ArrayList<>();
//            
//            for (int i = 0; i < infoModels.size(); i++) {
//                InfoModel info = infoModels.get(i);
//                MultipartFile file = files.get(i);
//                InfoModel inf = new InfoModel();
//                inf.setAmount(info.getAmount());
//                inf.setCreated(info.getCreated());
//                inf.setCurrency(info.getCurrency());
//                inf.setExpenseType(info.getExpenseType());
//                inf.setFileName(info.getFileName());
//                inf.setFilePath(uploadDir); // Set the file path
//
//                if (file != null && !file.isEmpty()) {
//                    try {
//                        Path filePath = Path.of(uploadDir, info.getFileName());
//                        Files.createDirectories(filePath.getParent());
//                        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//                        inf.setFilePath(filePath.toString());
//                    } catch (Exception e) {
//                        e.printStackTrace(); // Handle the exception properly
//                    }
//                }
//
//                listInfo.add(inf);
//            }
//            
//            return infoRepository.saveAll(listInfo);
//        }
//    }
//
//
//		
//	
//

package com.info.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.info.Repository.InfoRepository;
import com.info.model.InfoModel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

	 private final String uploadDir = "C:\\Users\\piyush_kumar\\Desktop";
	 

    @Autowired
    private InfoRepository infoRepository; // Assuming InfoRepository is your JpaRepository for InfoModel

    public List<InfoModel> insert(List<InfoModel> infoModels, List<MultipartFile> files) {
        List<InfoModel> listInfo = new ArrayList<>();
        
        for (int i = 0; i < infoModels.size(); i++) {
            InfoModel info = infoModels.get(i);
            MultipartFile file = files.get(i);
            InfoModel inf = new InfoModel();
            inf.setAmount(info.getAmount());
            inf.setCreated(info.getCreated());
            inf.setCurrency(info.getCurrency());
            inf.setExpenseType(info.getExpenseType());
            inf.setFileName(info.getFileName());
            inf.setFilePath(uploadDir); // Set the file path

            if (file != null && !file.isEmpty()) {
                try {
                    Path filePath = Path.of(uploadDir, info.getFileName());
                    Files.createDirectories(filePath.getParent());
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    inf.setFilePath(filePath.toString());
                } catch (Exception e) {
                    e.printStackTrace(); // Handle the exception properly
                }
            }

            listInfo.add(inf);
        }
        
        // Save the list of InfoModels to the database
        return infoRepository.saveAll(listInfo);
    }
}

