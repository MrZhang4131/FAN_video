package fan_video.model;

import lombok.Data;

import java.util.Date;
@Data
public class Follower {
    int id;
    int user_id;
    int followee_id;
    Date created_at;
    Date updated_at;
}
