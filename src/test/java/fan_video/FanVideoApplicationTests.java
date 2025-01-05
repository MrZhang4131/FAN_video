package fan_video;

import fan_video.Interceptor.LoginCheckInterceptor;
import fan_video.mapper.Video_Mapper;
import fan_video.model.Users;
import fan_video.service.Interfaces.Login_Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FanVideoApplicationTests {
    @Autowired
    Login_Service login_service;
    @Value(("${video.data.path}"))
    private String user_image_path;

    @Autowired
    Video_Mapper video_mapper;

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Test
    void contextLoads() {
        video_mapper.test();


    }
    @Test
    void GENJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("ID",1);
        claims.put("name","tom");
        String s = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"zstaishuaile")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(s);
    }

    @Test
    void  testPass(){
        Claims claims = Jwts.parser()
                .setSigningKey("zstaishuaile")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiSUQiOjEsImV4cCI6MTczNjA1NjExNX0.bRyomplZgG_1GxTSVQgRK_ZVCQjHM-3_8WG2unDw3QE")
                .getBody();
        System.out.println(claims);
    }

}
