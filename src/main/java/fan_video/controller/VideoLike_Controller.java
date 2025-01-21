package fan_video.controller;

import fan_video.Utils.JwtUtils;
import fan_video.service.Interfaces.VideoLike_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoLike_Controller {
    @Autowired
    private VideoLike_Service videoLike_service;
    @RequestMapping("videoLike/add")
    public String add_videoLike(int fvid, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoLike_service.add_videoLike(fvid,user_id);
    }

    @RequestMapping("videoLike/delete")
    public String deleteLike(int fvid, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoLike_service.deleteLike(fvid,user_id);
    }

    @RequestMapping("videoLike/check")
    public int check_videoLike(int fvid, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoLike_service.check_videoLike(fvid,user_id);
    }

    @RequestMapping("videoLike/num")
    public int videoLike_Num(int fvid){
        return videoLike_service.videoLike_Num(fvid);
    }
}
