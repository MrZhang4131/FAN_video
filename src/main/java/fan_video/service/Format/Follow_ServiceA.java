package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.Follower_Mapper;
import fan_video.model.Users;
import fan_video.service.Interfaces.Follow_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Follow_ServiceA implements Follow_Service {
    Gson gson = new Gson();
    @Autowired
    private Follower_Mapper follower_mapper;

    @Override
    public String add_followee(int user_id, int followee_id){
        follower_mapper.add_followee(user_id,followee_id);
        follower_mapper.update_follows_sum(user_id);
        follower_mapper.update_fans_num(followee_id);
        return "关注成功";
    }
    @Override
    public String delete_followee(int user_id, int followee_id){
        follower_mapper.delete_followee(user_id,followee_id);
        follower_mapper.update_follows_sum(user_id);
        follower_mapper.update_fans_num(followee_id);
        return "取消关注成功";
    }
    @Override
    public int check_follow(int user_id, int followee_id){
        return follower_mapper.check_follow(user_id,followee_id);
    }
    @Override
    public String select_followee(int user_id){
        ArrayList<Users> list = follower_mapper.select_followee(user_id);
        return gson.toJson(list);
    }
    @Override
    public String select_fans(int followee_id){
        ArrayList<Users> list = follower_mapper.select_fans(followee_id);
        return gson.toJson(list);
    }

}
