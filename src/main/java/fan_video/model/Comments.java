package fan_video.model;

import lombok.Data;

import java.util.Date;
@Data
public class Comments {
    int id;
    int user_id;
    int video_id;
    int comment_id;
    Date time;
    String comment_content;
}
