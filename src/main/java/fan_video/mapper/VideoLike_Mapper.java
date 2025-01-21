package fan_video.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoLike_Mapper {
    @Update("Update video_info Set like_count = (Select Count(*) from video_likes where fvid = #{fvid})")
    public void update_videoLike_num(int fvid);

    @Update("Update video_info Set comment_count = (Select Count(*) from comment where video_id = #{fvid})")
    public void update_videoComment_count(int fvid);

//    @Update("Update video_info Set comment_count = (Select Count(*) from comment where video_id = #{fvid})")
//    public void update_videoFavorite_count(int fvid);
    @Select("Select Count(*) FROM video_likes WHERE fvid = #{fvid} AND user_id = #{user_id}")
    public int check_videoLike(int fvid, int user_id);

    @Delete("DELETE FROM video_likes WHERE fvid = #{fvid} AND user_id = #{user_id}")
    public void deleteLike(int fvid,int user_id);

    @Select("Select Count(*) FROM video_likes WHERE fvid = #{fvid}")
    public int videoLike_Num(int fvid);

    @Insert("INSERT INTO video_likes (fvid, user_id) VALUES (#{fvid}, #{user_id})")
    public void add_videoLike(int fvid,int user_id);
}
