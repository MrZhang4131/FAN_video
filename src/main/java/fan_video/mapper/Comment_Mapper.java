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

    @Select("Select * from comments where video_id = #{fvid} AND comment_id IS NULL ORDER BY time DESC LIMIT #{PageInit}, #{PageSize};")
    public ArrayList<Comments> commentFirst(int fvid,int PageInit,int PageSize);

    @Select("Select Count(*) from comments where video_id=#{fvid}")
    public int commentNum(int fvid);//可能需要一个单独一级评论的计数

    //2025.1.6以上SQL均测试完毕

    @Select("Select Count(*) from comments where video_id=#{fvid} AND comment_id IS NULL")
    public int commentFirstNum(int fvid);//获得一级评论的计数

    @Select("Select * from comments WHERE comment_id = #{comment_list} ORDER BY time DESC LIMIT #{PageInit},#{PageSize}")
    public ArrayList<Comments> commentSecond(int comment_list,int PageInit,int PageSize);

    @Select("Select Count(*) from comments where comment_id = #{comment_id}")
    public int commentSecondNum(int comment_id);


}
