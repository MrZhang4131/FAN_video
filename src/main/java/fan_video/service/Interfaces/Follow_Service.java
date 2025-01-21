package fan_video.service.Interfaces;

public interface Follow_Service {
    String add_followee(int user_id, int followee_id);

    String delete_followee(int user_id, int followee_id);

    int check_follow(int user_id, int followee_id);

    String select_followee(int user_id);

    String select_fans(int followee_id);
}
