package fan_video.service.Interfaces;

public interface Login_Service {
    public String login_password(String userAccount,String Password,String permissionType);
    public String login_captcha(String userAccount,String Password,String permissionType);
    public String login(String userAccount,String Password,String loginType,String permissionType);

    String get_userinfo(int userid);
}
