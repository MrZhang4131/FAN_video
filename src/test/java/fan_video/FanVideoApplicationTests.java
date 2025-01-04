package fan_video;

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
    @Value(("${user.image.upload.path}"))
    private String user_image_path;
    @Test
    void contextLoads() {
        login_service.login("zs","123456","password","");
        System.out.println(user_image_path);


    }

}
