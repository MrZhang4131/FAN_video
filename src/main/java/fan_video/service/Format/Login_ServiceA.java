package fan_video.service.Format;



import com.google.gson.Gson;
import fan_video.Utils.JwtUtils;
import fan_video.mapper.User_Mapper;
import fan_video.model.Users;
import fan_video.service.Interfaces.Login_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class Login_ServiceA implements Login_Service {
    @Autowired
    private User_Mapper login_mapper;
    Gson gson = new Gson();

    @Override
    public String login_password(String userAccount, String Password, String permissionType) {
        ArrayList<Users> list = login_mapper.login(userAccount,Password);
        if(list.isEmpty()){
            return "账号或密码错误";
        }else {
            Map<String,Object> result = new HashMap<>();
            result.put("Userinfo",list.get(0));
            result.put("token",JwtUtils.GenJwt(list.get(0).getUserid()));
            return gson.toJson(result);
        }
    }

    @Override
    public String login_captcha(String userAccount, String Password, String permissionType) {
        if(Password.equals("123456"))//后期增加动态验证码功能
        {
            ArrayList<Users> list = login_mapper.captcha(userAccount);
            if(list.isEmpty()){
                login_mapper.registered(userAccount);
                list = login_mapper.captcha(userAccount);
                Map<String,Object> result = new HashMap<>();
                result.put("Userinfo",list.get(0));
                result.put("token",JwtUtils.GenJwt(list.get(0).getUserid()));
                return gson.toJson(result);
            }else{
                Map<String,Object> result = new HashMap<>();
                result.put("Userinfo",list.get(0));
                result.put("token",JwtUtils.GenJwt(list.get(0).getUserid()));
                return gson.toJson(result);
            }
        }else {
            return "验证码错误";
        }
    }

    @Override
    public String login(String userAccount, String Password, String loginType, String permissionType) {
        if(loginType.equals("password")){
            return login_password(userAccount,Password,userAccount);
        }else{
            return login_captcha(userAccount,Password,userAccount);
        }
    }
}
