package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.Video_Mapper;
import fan_video.model.Users;
import fan_video.model.Videos;
import fan_video.service.Interfaces.Video_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class Video_ServiceA implements Video_Service {
    @Autowired
    Video_Mapper video_mapper;

    Gson gson = new Gson();


    @Override
    public String primaryVideo(int PageSize, int PageNum) {
        int PageInit = (PageNum-1)*PageSize;
        ArrayList<Videos> video_list = video_mapper.primary_video_select(PageInit,PageNum);
        ArrayList<Users> user = new ArrayList<Users>();
        for (Videos videos : video_list) {
            user.addAll(video_mapper.get_userinfo(videos.getUser_id()));
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("videos",video_list);
        result.put("users",user);
        return gson.toJson(result);
    }
    @Override
    public void video_create(Videos videos){
        video_mapper.video_create(videos);
    }

    @Override
    public String openVideo(int fvid){
        ArrayList<Videos> video =  video_mapper.openVideo(fvid);
        ArrayList<Users> user = video_mapper.get_userinfo(video.get(0).getUser_id());
        Map<String, Object> result = new HashMap<>();
        result.put("videos", video);
        result.put("users", user);
        return gson.toJson(result);
    }

    @Override
    public void delete_video(int fvid){
        video_mapper.delete_video(fvid);
    }

    @Override
    public String videoSection_select(String videoSection){
        ArrayList<Videos> video = video_mapper.videoSection_select(videoSection);
        ArrayList<Users> user = new ArrayList<Users>();
        for (Videos videos : video) {
            user.addAll(video_mapper.get_userinfo(videos.getUser_id()));
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("videos",video);
        result.put("users",user);
        return gson.toJson(result);
    }



}
