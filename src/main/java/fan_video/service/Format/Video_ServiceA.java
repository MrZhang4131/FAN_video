package fan_video.service.Format;

import com.google.gson.Gson;
import fan_video.mapper.Video_Mapper;
import fan_video.model.Videos;
import fan_video.service.Interfaces.Video_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Video_ServiceA implements Video_Service {
    @Autowired
    Video_Mapper video_mapper;

    Gson gson = new Gson();


    @Override
    public String primaryVideo(int PageSize, int PageNum) {
        int PageInit = (PageSize-1)*PageNum;
        ArrayList<Videos> list = video_mapper.primary_video_select(PageInit,PageNum);
        return gson.toJson(list);
    }
}
