package fan_video.model;

import lombok.Data;

import java.util.Date;

@Data
public class VideoFavorites {
    int id;
    int user_id;
    int fvid;
    String category;
    Date created_at;
    Date updated_at;
}

