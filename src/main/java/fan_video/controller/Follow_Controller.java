package fan_video.controller;

import fan_video.Utils.JwtUtils;
import fan_video.service.Interfaces.Follow_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Follow_Controller {
    @Autowired
    private Follow_Service follow_service;
    @RequestMapping("follow/add")
    public String add_followee(int followee_id, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return follow_service.add_followee(user_id,followee_id);
    }
    @RequestMapping("follow/delete")
    public String delete_followee(int followee_id, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return follow_service.delete_followee(user_id,followee_id);
    }
    @RequestMapping("follow/check")
    public int check_follow(int followee_id, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return follow_service.check_follow(user_id,followee_id);
    }
    @RequestMapping("follow/followee")
    public String select_followee(int user_id){
        return follow_service.select_followee(user_id);
    }
    @RequestMapping("follow/fans")
    public String select_fans(int followee_id){
        return follow_service.select_fans(followee_id);
    }
}
