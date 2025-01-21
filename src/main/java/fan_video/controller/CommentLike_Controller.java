package fan_video.controller;

import fan_video.Utils.JwtUtils;
import fan_video.service.Interfaces.CommentLike_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentLike_Controller {
    @Autowired
    private CommentLike_Service commentLike_service;

    @RequestMapping("commentLike/add")
    public String add_commentLike(int comment_id, int user_id){
        return commentLike_service.add_commentLike(comment_id,user_id);
    }
    @RequestMapping("commentLike/check")
    public int check_commentLike(int comment_id,@RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return commentLike_service.check_commentLike(comment_id,user_id);
    }
    @RequestMapping("commentLike/delete")
    public String deleteLike(int comment_id,@RequestHeader("token") String token) throws Exception {
        int user_id = JwtUtils.parseJit(token);
        return commentLike_service.deleteLike(comment_id,user_id);
    }

    @RequestMapping("commentLike/num")
    public int commentLike_Num(int comment_id){
         return commentLike_service.commentLike_Num(comment_id);
    }
}
