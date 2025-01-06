package fan_video.controller;

import fan_video.model.Comments;
import fan_video.service.Interfaces.Comment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Comment_Controller {
    @Autowired
    private Comment_Service comment_service;

    @RequestMapping("/comment")
    public String comment(int[] fvid){

        return "finished";
    }

    @RequestMapping("/comment/first")
    public String comment_first(int fvid,int PageSize,int PageNum){
        return comment_service.commentFirst(fvid,PageSize,PageNum);
    }

//    @RequestMapping("/comment/second")
//    public String comment_second(){
//
//    }


    @RequestMapping("/insertComment")
    public void insertComment(Comments comments, @RequestHeader("token") String token) throws Exception {
        comment_service.insertComment(comments,token);
    }

    @RequestMapping("/userComment")
    public String userComment(@RequestHeader("token") String token) throws Exception {
        return comment_service.userComment(token);
    }



}
