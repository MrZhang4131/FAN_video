package fan_video.service.Interfaces;

import fan_video.model.Videos;

public interface Video_Service {

    String primaryVideo(int PageSize, int PageNum);

    void video_create(Videos videos);
}
