package fan_video.controller;

import fan_video.Utils.JwtUtils;
import fan_video.model.Videos;
import fan_video.service.Interfaces.Video_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Video_Controller {
    @Autowired
    Video_Service videoService;
    @RequestMapping("/primary_video")
    public String primaryVideo_List(int PageSize,int PageNum){
        return videoService.primaryVideo(PageSize,PageNum);
    }

    @RequestMapping("/video/create")
    public String video_create(Videos videos,@RequestHeader("token") String token) throws Exception {
        int id = JwtUtils.parseJit(token);
        videos.setUser_id(id);
        videoService.video_create(videos);
        System.out.println(videos);
        return "投稿成功";
    }

    @RequestMapping("openVideo")
    public String open_video(int fvid){
        return videoService.openVideo(fvid);
    }
    @RequestMapping("/video/delete")
    public String delete_video(int fvid){
        videoService.delete_video(fvid);
        return "删除成功";
    }
    //分区查询视频
    @RequestMapping("videoSection_select")
    public String videoSection(String section){
        return videoService.videoSection_select(section);
    }
}
