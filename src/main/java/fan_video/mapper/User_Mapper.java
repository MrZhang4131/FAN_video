package fan_video.mapper;

import fan_video.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface User_Mapper {
    @Select("SELECT * FROM users WHERE userAccount = #{userAccount} AND password = #{Password};")
    public ArrayList<Users> login(String userAccount,String Password);
    @Select("SELECT * FROM users WHERE userAccount = #{userAccount}")
    public ArrayList<Users> captcha(String userAccount);
    @Insert("INSERT INTO users (userAccount, Permissions) VALUES (#{userAccount}, 'common')")
    public void registered(String userAccount);
}
