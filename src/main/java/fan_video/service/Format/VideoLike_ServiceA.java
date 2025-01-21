package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.VideoLike_Mapper;
import fan_video.service.Interfaces.VideoLike_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoLike_ServiceA implements VideoLike_Service {
    Gson gson = new Gson();
    @Autowired
    private VideoLike_Mapper videoLike_mapper;
    @Override
    public int check_videoLike(int fvid, int user_id){
        return videoLike_mapper.check_videoLike(fvid,user_id);
    }

    @Override
    public String deleteLike(int fvid, int user_id){
        videoLike_mapper.deleteLike(fvid,user_id);
        videoLike_mapper.update_videoLike_num(fvid);
        return "取消点赞成功";
    }

    @Override
    public int videoLike_Num(int fvid){
        return videoLike_mapper.videoLike_Num(fvid);
    }

    @Override
    public String add_videoLike(int fvid, int user_id){
        videoLike_mapper.add_videoLike(fvid,user_id);
        videoLike_mapper.update_videoLike_num(fvid);
        return "点赞成功";
    }
}
