package fan_video.model;

import lombok.Data;

import java.util.Collections;
import java.util.Date;

@Data
public class Users {
    int userid;
    String userAccount;
    String Password;
    String Permissions;
    String nickName;
    String avatarUrl;
    String gender;
    Date birthday;
    int follows_num;
    int userDynamics_num;
    int fans_num;
    String collection_list;
}
