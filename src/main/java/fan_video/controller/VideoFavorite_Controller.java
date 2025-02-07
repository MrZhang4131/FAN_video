package fan_video.controller;

import fan_video.Utils.JwtUtils;
import fan_video.service.Interfaces.VideoFavorite_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoFavorite_Controller {
    @Autowired
    VideoFavorite_Service videoFavorite_service;
    @RequestMapping("videoFavorite/add")
    public String add_videoFavorite(int fvid, String category, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoFavorite_service.add_videoFavorite(fvid,user_id,category);
    }
    @RequestMapping("videoFavorite/delete")
    public String deleteFavorite(int fvid, String category, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoFavorite_service.deleteFavorite(fvid,user_id,category);
    }
    @RequestMapping("videoFavorite/check")
    public String check_videoFavorite(int fvid, @RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoFavorite_service.check_videoFavorite(fvid,user_id);
    }
    @RequestMapping("videoFavorite/num")
    public int videoFavorite_Num(int fvid){
        return videoFavorite_service.videoFavorite_Num(fvid);
    }

    @RequestMapping("videoFavorite/category/{category}")
    public String videoFavorite_category(@PathVariable String category,@RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return videoFavorite_service.favorite_video(user_id,category);
    }

    @RequestMapping("videoFavorite/categoryList")
    public String videoFavorite_categoryList(@RequestHeader("token") String token) throws Exception {
        return videoFavorite_service.videoFavorite_categoryList(token);
    }

    @RequestMapping("videoFavorite/add_category")
    public String add_category(String category,@RequestHeader("token") String token) throws Exception {
        return videoFavorite_service.add_category(category,token);
    }

    @RequestMapping("videoFavorite/delete_category")
    public String delete_category(String category,@RequestHeader("token") String token) throws Exception {
        return videoFavorite_service.delete_category(category,token);
    }

}
