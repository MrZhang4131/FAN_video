package fan_video.model;

import lombok.Data;

import java.util.Date;
@Data
public class Videos {
    int fvid;
    int user_id;
    String url;
    int view_count;
    Date upload_time;
    int like_count;
    int favorite_count;
    int comment_count;
    int share_count;
    boolean is_deleted;
    String partitions;
    String type;
}
