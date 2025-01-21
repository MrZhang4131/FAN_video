package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.CommentLike_Mapper;
import fan_video.service.Interfaces.CommentLike_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLike_ServiceA implements CommentLike_Service {
    Gson gson = new Gson();
    @Autowired
    private CommentLike_Mapper commentLike_mapper;
    @Override
    public String add_commentLike(int comment_id, int user_id){
        commentLike_mapper.add_commentLike(comment_id,user_id);
        commentLike_mapper.update_commentLike_Num(comment_id);
        return "点赞成功";
    }
    @Override
    public int check_commentLike(int comment_id, int user_id){
        int check = commentLike_mapper.check_commentLike(comment_id,user_id);
        return check;
    }

    @Override
    public String deleteLike(int comment_id, int user_id){
        commentLike_mapper.deleteLike(comment_id,user_id);
        commentLike_mapper.update_commentLike_Num(comment_id);
        return "删除点赞成功";
    }

    @Override
    public int commentLike_Num(int comment_id){
        return commentLike_mapper.commentLike_Num(comment_id);
    }
}
