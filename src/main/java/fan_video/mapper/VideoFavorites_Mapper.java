package fan_video.mapper;

import fan_video.model.Videos;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface VideoFavorites_Mapper {
    @Update("Update video_info Set favorite_count = (Select Count(*) From video_favorites Where fvid = #{fvid})")
    public void Update_videoFavorite_Num(int fvid);

    @Insert("INSERT INTO video_favorites (fvid,user_id,category) VALUES (#{fvid}, #{user_id}, #{category})")
    public void add_videoFavorite(int fvid,int user_id,String category);
    @Delete("DELETE FROM video_favorites WHERE fvid = #{fvid} AND user_id = #{user_id} AND category = #{category}")
    public void deleteFavorite(int fvid,int user_id,String category);

    @Select("SELECT category FROM video_favorites WHERE fvid = #{fvid} AND user_id = #{user_id}")
    public ArrayList<String> check_videoFavorite(int fvid, int user_id);

    @Select("SELECT Count(*) FROM video_favorites WHERE fvid = #{fvid}")
    public int videoFavorite_Num(int fvid);

    @Select("Select * from video_info where fvid in (Select fvid from video_favorite where user_id = #{user_id} AND category = #{category})")
    public ArrayList<Videos> favorite_video(int user_id,String category);

    @Select("Select collection_list from users where userid = #{user_Id}")
    public String videoFavorite_categoryList(int user_id);

    @Update("Update users Set collection_list = #{collection_list} where userid = #{user_id}")
    public void change_category(String collection_list,int user_id);
}
