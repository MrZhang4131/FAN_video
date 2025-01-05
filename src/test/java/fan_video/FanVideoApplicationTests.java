package fan_video;

import fan_video.mapper.Video_Mapper;
import fan_video.model.Users;
import fan_video.service.Interfaces.Login_Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FanVideoApplicationTests {
    @Autowired
    Login_Service login_service;
    @Value(("${video.data.path}"))
    private String user_image_path;

    @Autowired
    Video_Mapper video_mapper;
    @Test
    void contextLoads() {
        video_mapper.test();


    }

}
