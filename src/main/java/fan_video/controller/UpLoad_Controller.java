package fan_video.controller;

import fan_video.service.Interfaces.Upload_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UpLoad_Controller {

    @Autowired
    Upload_Service upload_service;

    @RequestMapping("/user_upload")//参考https://blog.csdn.net/m0_52133525/article/details/123395196
    public String user_upload(@RequestPart("file")MultipartFile videoData){
        return upload_service.user_upload(videoData);
    }
    @RequestMapping("/load_user_image/{filename}")
    public ResponseEntity<Resource> user_image_load(@PathVariable String filename){
        return upload_service.user_load(filename);
    }

}
