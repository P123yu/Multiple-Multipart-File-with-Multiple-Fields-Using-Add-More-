//package com.info.controller;
////
////
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.multipart.MultipartFile;
////
////import com.info.Service.InfoServiceImpl;
////import com.info.dto.InfoDto;
////import com.info.model.InfoModel;
////@RestController
////@CrossOrigin
////public class InfoController {
////    
////    @Autowired
////    private InfoServiceImpl infoServiceImpl;
////    
////    @PostMapping("/insert")
////    public ResponseEntity<?> insert(@RequestBody List<InfoModel>infomodel
////                                     ) {
////        try {
////            infoServiceImpl.insert(infomodel);
////            return ResponseEntity.ok().build();
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not inserted");
////}
////    }
////}
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import com.info.Service.InfoServiceImpl;
//import com.info.model.InfoModel;
//
//@RestController
//@CrossOrigin
//public class InfoController {
//
//    @Autowired
//    private InfoServiceImpl infoServiceImpl;
//
//    @PostMapping("/insert")
//    public ResponseEntity<?> insert(@RequestPart("infoModels") InfoModel[] infoModels,
//                                    @RequestPart("files") MultipartFile[] files) {
//        try {
//            if (infoModels.length != files.length) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Number of files does not match number of InfoModels");
//            }
//            
//            infoServiceImpl.insert(infoModels, files);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert");
//        }
//    }
//}


package com.info.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.info.Service.InfoService;
import com.info.model.InfoModel;

import java.util.List;

@RestController
@CrossOrigin
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertInfoModels(
            @RequestPart("infoModels") List<InfoModel> infoModels,
            @RequestPart("files") List<MultipartFile> files) {
        try {
            if (infoModels.size() != files.size()) {
                return ResponseEntity.badRequest().body("Number of files does not match number of InfoModels");
            }
            System.out.print(infoModels+" "+files);

            List<InfoModel> insertedInfoModels = infoService.insert(infoModels, files);
            if (insertedInfoModels.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert InfoModels");
            }

            return ResponseEntity.ok("InfoModels inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert InfoModels");
        }
    }
}

