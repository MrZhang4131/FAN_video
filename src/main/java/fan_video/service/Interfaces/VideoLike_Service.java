package fan_video.service.Interfaces;

public interface VideoLike_Service {
    int check_videoLike(int fvid, int user_id);

    String deleteLike(int fvid, int user_id);

    int videoLike_Num(int fvid);



    String add_videoLike(int fvid, int user_id);
}
