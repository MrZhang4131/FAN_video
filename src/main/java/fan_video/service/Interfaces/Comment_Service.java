package fan_video.service.Interfaces;

import fan_video.model.Comments;

public interface Comment_Service {

    void insertComment(Comments comments, String token) throws Exception;

    String userComment(String token) throws Exception;

    String commentFirst(int fvid, int PageSize, int PageNum);

    String commentSecond(int comment_id, int PageSize, int PageNum);
}
