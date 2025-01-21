package fan_video.model;

import lombok.Data;

import java.util.Date;

@Data
public class VideoLike {
    int id;
    int user_id;
    int fvid;
    Date created_at;
    Date updated_at;
}
