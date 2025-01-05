package fan_video.mapper;

import fan_video.model.Users;
import fan_video.model.Videos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface Video_Mapper {
    @Select("SELECT * FROM video_info ORDER BY upload_time DESC LIMIT #{PageInit}, #{PageNum};")
    public ArrayList<Videos> primary_video_select(int PageInit,int PageNum);

    @Insert("Insert INTO video_info (url,videoCover,videoTitle,videoIntro,videoTags,videoSection,upload_time,user_id,type)"+
            "values(#{url},#{videoCover},#{videoTitle},#{videoIntro},#{videoTags},#{videoSection},NOW(),#{user_id},#{type})")
    public void video_create(Videos videos);

    @Select("SELECT * from users WHERE userid IN (SELECT user_id FROM video_info ORDER BY upload_time DESC LIMIT #{PageInit}, #{PageNum};)")
    public ArrayList<Users> primary_video_user_select(int PageInit, int PageNum);
}
