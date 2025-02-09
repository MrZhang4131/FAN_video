package fan_video.service.Interfaces;

import fan_video.model.Videos;

public interface Video_Service {

    String primaryVideo(int PageSize, int PageNum);

    void video_create(Videos videos);

    String openVideo(int fvid);

    void delete_video(int fvid);

    String videoSection_select(String videoSection);

    String video_user(int user_id) throws Exception;
}
