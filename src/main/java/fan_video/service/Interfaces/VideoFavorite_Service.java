package fan_video.service.Interfaces;

public interface VideoFavorite_Service {


    String add_videoFavorite(int fvid, int user_id, String category);

    String deleteFavorite(int fvid, int user_id, String category);

    String check_videoFavorite(int fvid, int user_id);

    int videoFavorite_Num(int fvid);

    String favorite_video(int user_id, String category);

    String videoFavorite_categoryList(String token) throws Exception;

    String add_category(String category, String token) throws Exception;

    String delete_category(String category, String token) throws Exception;
}
