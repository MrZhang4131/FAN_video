package fan_video.mapper;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CommentLike_Mapper {
    @Insert("INSERT INTO comment_likes (comment_id, user_id) VALUES (#{comment_id}, #{user_id})")
    public void add_commentLike(int comment_id,int user_id);

    @Update("Update comments Set likeNum = (Select Count(*) From comment_likes Where comment_id = #{comment_id})")
    public void update_commentLike_Num(int comment_id);

    @Select("Select Count(*) FROM comment_likes WHERE comment_id = #{comment_id} AND user_id = #{user_id}")
    public int check_commentLike(int comment_id, int user_id);

    @Delete("DELETE FROM comment_likes WHERE comment_id = #{comment_id} AND user_id = #{user_id}")
    public void deleteLike(int comment_id,int user_id);

    @Select("Select Count(*) FROM comment_likes WHERE comment_id = #{comment_id}")
    public int commentLike_Num(int comment_id);

}
