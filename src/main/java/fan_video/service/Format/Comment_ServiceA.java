package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.Utils.JwtUtils;
import fan_video.mapper.CommentLike_Mapper;
import fan_video.mapper.Comment_Mapper;
import fan_video.mapper.VideoLike_Mapper;
import fan_video.mapper.Video_Mapper;
import fan_video.model.Comments;
import fan_video.service.Interfaces.Comment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class Comment_ServiceA implements Comment_Service {

    Gson gson = new Gson();
    @Autowired
    private Comment_Mapper comment_mapper;

    @Autowired
    private VideoLike_Mapper videoLike_mapper;

    @Override
    public void insertComment(Comments comments, String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        comments.setUser_id(user_id);
        if(comments.getComment_id()!=0){
            comment_mapper.insertComment_comment(comments);
        }else{
            comment_mapper.insertVideo_comment(comments);
            videoLike_mapper.update_videoComment_count(comments.getVideo_id());
        }
    }

    @Override
    public String userComment(String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        ArrayList<Comments> comments = comment_mapper.user_comment(user_id);
        return gson.toJson(comments);
    }

    @Override
    public String commentFirst(int fvid, int PageSize, int PageNum){
        int PageInit = (PageNum-1)*PageSize;
        ArrayList<Comments> list = comment_mapper.commentFirst(fvid,PageInit,PageSize);
        int comment_total_num = comment_mapper.commentNum(fvid);
        int Page_total_size = comment_total_num/PageSize;
        if(comment_total_num%PageSize!=0){
            Page_total_size+=1;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("comment_list",list);
        result.put("Page_total_size",Page_total_size);
        result.put("comment_total_num",comment_total_num);
        return gson.toJson(result);
    }

    @Override
    public String commentSecond(int comment_id, int PageSize, int PageNum){
        int PageInit = (PageNum-1)*PageSize;
        ArrayList<Comments> list = comment_mapper.commentSecond(comment_id,PageInit,PageSize);
        int comment_second_total_num = comment_mapper.commentSecondNum(comment_id);
        int Page_total_size = comment_second_total_num/PageSize;
        if(comment_second_total_num%PageSize!=0){
            Page_total_size+=1;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("comment_second_list",list);
        result.put("Page_total_size",Page_total_size);
        result.put("comment_second_total_num",comment_second_total_num);
        return gson.toJson(result);
    }
}
