package fan_video.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static String key="shanghaiUniversity";

    private static long time=7200;
    public static String GenJwt(int id){
        Map<String, Object> claims = new HashMap<>();
        claims.put("ID",id);
        System.out.println(key);
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+time*1000))
                .compact();
        System.out.println(jwt);
        return jwt;
    }

    public static void parseJit(String jwt) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }


}
