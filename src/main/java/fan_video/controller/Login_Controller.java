package fan_video.controller;


import fan_video.service.Interfaces.Login_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login_Controller
{
    @Autowired
    private Login_Service login_service;

    @PostMapping("/login")
    public String login(String userAccount,String Password,String loginType,String permissionType){
        return login_service.login(userAccount,Password,loginType,permissionType);
    }

    @RequestMapping("/get_userinfo")
    public String get_userinfo(int userid){
        return login_service.get_userinfo(userid);
    }

}
