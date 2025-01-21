package fan_video.model;

import lombok.Data;

import java.util.Date;

@Data
public class CommentLikes {
    int id;
    int comment_id;
    int user_id;
    Date created_at;
    Date updated_at;
}
