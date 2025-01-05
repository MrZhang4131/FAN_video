package fan_video.mapper;

import fan_video.model.Videos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface Video_Mapper {
    @Select("SELECT * FROM video_info ORDER BY upload_time DESC LIMIT #{PageInit}, #{PageNum};")
    public ArrayList<Videos> primary_video_select(int PageInit,int PageNum);

    @Insert("Insert INTO video_info (url,videoCover,videoTitle,videoIntro,videoTags,videoSection,upload_time)"+
            "values(#{url},#{videoCover},#{videoTitle},#{videoIntro},#{videoTags},#{videoSection},NOW())")
    public void video_create(Videos videos);

    @Insert("INSERT INTO video_info (videoSection) values('zzz')")
    public void test();
}
