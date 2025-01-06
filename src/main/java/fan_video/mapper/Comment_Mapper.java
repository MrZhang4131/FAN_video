package fan_video.mapper;

import fan_video.controller.Comment_Controller;
import fan_video.model.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface Comment_Mapper {
    @Select("Select * FROM comments WHERE user_id = #{user_id} ORDER BY time DESC LIMIT 3 ")
    public ArrayList<Comments> user_comment(int user_id);

    @Insert("Insert Into comments (user_id, video_id, time, comment_content) values(#{user_id},#{video_id},NOW(),#{comment_content})")
    public void insertVideo_comment(Comments comments);

    @Insert("Insert Into comments (user_id, video_id, comment_id, time, comment_content) values(#{user_id},#{video_id},#{comment_id},NOW(),#{comment_content})")
    public void insertComment_comment(Comments comments);

    @Select("Select * from comments where video_id = #{fvid} AND comment_id IS NULL ORDER BY time DESC LIMIT #{PageInit}, #{PageNum};")
    public ArrayList<Comments> commentFirst(int fvid,int PageInit,int PageNum);

    @Select("Select Count(*) from comments where video_id=#{fvid}")
    public int commentNum(int fvid);

    //2025.1.6以上SQL均测试完毕
}