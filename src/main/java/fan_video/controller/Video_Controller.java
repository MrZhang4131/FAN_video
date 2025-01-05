package fan_video.controller;

import fan_video.model.Videos;
import fan_video.service.Interfaces.Video_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping("/video_create")
    public String video_create(Videos videos){
        videoService.video_create(videos);
        System.out.println(videos);
        return "投稿成功";
    }
}
