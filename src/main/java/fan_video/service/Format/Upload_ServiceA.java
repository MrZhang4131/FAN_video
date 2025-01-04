package fan_video.service.Format;

import fan_video.service.Interfaces.Upload_Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class Upload_ServiceA implements Upload_Service {

    @Value(("${user.image.upload.path}"))
    private String user_image_path;
    private Path imageDirectory = Paths.get("user_image/");
    @Override
    public String user_upload(MultipartFile file) {

        if (file.isEmpty()) {
            return "Please select a file to upload";
        }

        try {
            String rootPath = System.getProperty("user.dir");//获取当前系统路径

            String imageID = UUID.randomUUID().toString()+".jpg";//生成UUID确保文件名独立性
            //保存文件
            String savePath = rootPath + "/" + user_image_path;
            String destinationPath = savePath + imageID;

            file.transferTo(new File(destinationPath));

            return imageID;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file " + file.getOriginalFilename();
        }
    }

    @Override
    public ResponseEntity<Resource> user_load(String filename) {
//        filename = filename+".jpg";
//        System.out.println(filename);
        try {
            Path imagePath = imageDirectory.resolve(filename).normalize();
//            System.out.println(imagePath);
            Resource resource = new UrlResource(imagePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .contentType(MediaType.IMAGE_JPEG) // 根据文件类型设置MediaType
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
