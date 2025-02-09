package fan_video.mapper;

import fan_video.model.Users;
import fan_video.model.Videos;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface Video_Mapper {
    @Select("SELECT * FROM video_info ORDER BY upload_time DESC LIMIT #{PageInit}, #{PageSize};")
    public ArrayList<Videos> primary_video_select(int PageInit,int PageSize);

    @Insert("Insert INTO video_info (url,videoCover,videoTitle,videoIntro,videoTags,videoSection,upload_time,user_id,type)"+
            "values(#{url},#{videoCover},#{videoTitle},#{videoIntro},#{videoTags},#{videoSection},NOW(),#{user_id},#{type})")
    public void video_create(Videos videos);

    //采用循环查询重构
//    @Select("SELECT * from users WHERE userid IN (SELECT user_id FROM video_info ORDER BY upload_time DESC LIMIT #{PageInit}, #{PageNum};)")
//    public ArrayList<Users> primary_video_user_select(int PageInit, int PageNum);

    @Select("SELECT * FROM video_info WHERE fvid = #{fvid}")
    public ArrayList<Videos> openVideo(int fvid);


    @Update("UPDATE video_info SET is_deleted = true WHERE fvid = #{fvid};")
    public void delete_video(int fvid);

    @Select("SELECT * FROM video_info WHERE videoSection = #{videoSection}")
    public ArrayList<Videos> videoSection_select(String videoSection);

    @Select("SELECT * FROM users WHERE userid = #{userid}")
    public ArrayList<Users> get_userinfo(int userid);

    @Select("Select * From video_info where user_id = #{user_id}")
    public ArrayList<Videos> video_user(int user_id);
}
