package fan_video.mapper;

import fan_video.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface Follower_Mapper {
    @Insert("INSERT INTO followers (user_id, followee_id) VALUES (#{user_id}, #{followee_id})")
    public void add_followee(int user_id,int followee_id);

    @Delete("DELETE From followers where user_id = #{user_id} AND followee_id = #{followee_id}")
    public void delete_followee(int user_id,int followee_id);

    @Select("SELECT Count(*) From followers where user_id = #{user_id} AND followee_id = #{followee_id}")
    public int check_follow(int user_id,int followee_id);

    @Update("Update users Set follows_num = (Select count(*) from followers where user_id = #{user_id}) where userid = #{user_id}")
    public void update_follows_sum(int user_id);

    @Update("Update users Set fans_num = (Select count(*) from followers where followee_id = #{followee_id}) where userid = #{followee_id}")
    public void update_fans_num(int followee_id);

    @Select("Select * From users where userid IN (Select followee_id from followers where user_id = #{user_id})")
    public ArrayList<Users> select_followee(int user_id);

    @Select("Select * From users Where userid in (Select user_id from followers where followee_id = #{followee_Id})")
    public ArrayList<Users> select_fans(int followee_id);
}
