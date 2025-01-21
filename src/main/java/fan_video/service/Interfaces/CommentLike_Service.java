package fan_video.service.Interfaces;

public interface CommentLike_Service {
    String add_commentLike(int comment_id, int user_id);

    int check_commentLike(int comment_id, int user_id);

    String deleteLike(int comment_id, int user_id);

    int commentLike_Num(int comment_id);
}
