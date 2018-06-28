package com.zhihu.service;

import com.zhihu.pojo.Message;
import com.zhihu.pojo.Publish;
import com.zhihu.pojo.UserInfo;
import net.sf.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    UserInfo login(UserInfo userInfo);

    Message addUserInfo(UserInfo userInfo);

    Message addPhoneUser(String userPhone, String authCode, HttpServletRequest request);

    Message checkPswd(String oldPassword, UserInfo user);

    Message updatePasw(String oldPassword, String newPassword, String newPassword1, UserInfo user);

    Message updateUser(UserInfo user, MultipartFile filedata, HttpServletRequest request);

    JSONArray findMessge(String id);

    List<UserInfo> findPublish(List<Publish> users);
}
