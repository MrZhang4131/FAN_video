package fan_video.service.Interfaces;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface Upload_Service {
    public String user_upload(MultipartFile file);
    public ResponseEntity<Resource> user_load(String filename);

    String video_upload(MultipartFile file);

    ResponseEntity<Resource> video_load(String filename);

    String cover_upload(MultipartFile file);

    ResponseEntity<Resource> cover_load(String filename);
}
