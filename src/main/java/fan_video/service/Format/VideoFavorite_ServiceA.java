package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.VideoFavorites_Mapper;
import fan_video.mapper.Video_Mapper;
import fan_video.model.Users;
import fan_video.model.Videos;
import fan_video.service.Interfaces.VideoFavorite_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class VideoFavorite_ServiceA implements VideoFavorite_Service {
    Gson gson = new Gson();
    @Autowired
    private VideoFavorites_Mapper videoFavorites_mapper;

    @Autowired
    private Video_Mapper video_mapper;
    @Override
    public String add_videoFavorite(int fvid, int user_id, String category){
        videoFavorites_mapper.add_videoFavorite(fvid,user_id,category);
        videoFavorites_mapper.Update_videoFavorite_Num(fvid);
        return "收藏成功";
    }
    @Override
    public String deleteFavorite(int fvid, int user_id, String category){
        videoFavorites_mapper.deleteFavorite(fvid,user_id,category);
        videoFavorites_mapper.Update_videoFavorite_Num(fvid);
        return "取消收藏成功";
    }

    @Override
    public String check_videoFavorite(int fvid, int user_id){
        ArrayList<String> list = videoFavorites_mapper.check_videoFavorite(fvid,user_id);
        return gson.toJson(list);
    }

    @Override
    public int videoFavorite_Num(int fvid){
        return videoFavorites_mapper.videoFavorite_Num(fvid);
    }

    @Override
    public String favorite_video(int user_id, String category){
        ArrayList<Videos> videos = videoFavorites_mapper.favorite_video(user_id,category);
        ArrayList<Users> users = new ArrayList<>();
        for (Videos video : videos) {
            users.addAll(video_mapper.get_userinfo(video.getUser_id()));
        }
        HashMap<String,Object> result = new HashMap<>();
        result.put("videos",videos);
        result.put("users",users);
        return gson.toJson(result);
    }

}
