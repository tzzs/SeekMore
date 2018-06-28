package com.zhihu.service.impl;

import com.zhihu.dao.RoleDao;
import com.zhihu.dao.UserDao;
import com.zhihu.pojo.*;
import com.zhihu.service.UserService;
import com.zhihu.utils.UpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zhihu.service.impl
 * @Name UserServiceImpl
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Override
    public UserInfo login(UserInfo userInfo) {
        System.out.println(userInfo.getUserName()+" pwd:"+userInfo.getUserPassword());
        Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
        userInfo.setUserPassword(md5Hash.toString());
        System.out.println(userInfo.getUserName()+" pwd2:"+userInfo.getUserPassword());
        System.out.println(userInfo.toString());

        return userDao.login(userInfo.getUserName(),userInfo.getUserPassword());
        // Md5Hash md5Hash = new Md5Hash(userName);
        //
        // return userDao.login(userName,md5Hash.toString());
    }

    @Override
    public Message addUserInfo(UserInfo userInfo) {
        Message msg = new Message();
        UserInfo userInfo1 = userDao.findByName(userInfo.getUserName());
        if (userInfo1 != null) {
            msg.setMsg("用户名已存在，请重新输入");
        } else {
            String id = UUID.randomUUID().toString().substring(0, 4);
            userInfo.setId(id);
            Md5Hash md5Hash = new Md5Hash(userInfo.getUserPassword());
            userInfo.setUserPassword(md5Hash.toString());

            Role role = roleDao.findByName("用户");
            userInfo.setUserRole(role);

            userInfo.setUserIcon("images/img_1.jpg");

            userDao.addUserInfo(userInfo);
            User user = new User(id, null, null, null, null, null, null);
            userDao.addUser(user);
            msg.setMsg("true");
        }
        System.out.println("service:" + msg.getMsg());
        return msg;
    }

    @Override
    public Message addPhoneUser(String userPhone, String authCode, HttpServletRequest request) {
        Message msg = new Message();
        String code = String.valueOf(request.getSession().getAttribute("authCode"));
        System.out.println(code);
        System.out.println(authCode);
        System.out.println(code.equals(authCode));
        if (authCode.equals(code)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserPhone(userPhone);
            userInfo.setUserName(userPhone);

            Md5Hash md5Hash = new Md5Hash(authCode);
            userInfo.setUserPassword(md5Hash.toString());

            String id = UUID.randomUUID().toString().substring(0, 4);
            userInfo.setId(id);

            Role role = roleDao.findByName("用户");
            userInfo.setUserRole(role);

            userInfo.setUserIcon("images/img_1.jpg");


            userDao.addUserInfo(userInfo);

            User user = new User(id, null, null, null, null, null, null);
            userDao.addUser(user);
            msg.setMsg("true");
        } else {
            msg.setMsg("验证码错误");
        }
        return msg;
    }

    @Override
    public Message checkPswd(String oldPassword, UserInfo user) {
        Message msg=new Message();
        Md5Hash md5=new Md5Hash(oldPassword);
        String oldPassword1=md5.toString();

        // Md5Hash md51=new Md5Hash(user.getUserPassword());
        // user.setUserPassword(md51.toString());
        if (oldPassword1.equals(user.getUserPassword())){
            msg.setMsg("密码正确");
            return msg;
        }else {
            msg.setMsg("原密码错误");
            return msg;
        }
    }

    @Override
    public Message updatePasw(String oldPassword, String newPassword, String newPassword1, UserInfo user) {
        Message msg=new Message();
        if (oldPassword==null||oldPassword.equals("")){
            msg.setMsg("原密码不能为空");
            return msg;
        }else {
            if (newPassword.equals("")||newPassword==null){
                msg.setMsg("新密码不能为空");
                return msg;
            }else {
                if (!newPassword.equals(newPassword1)){
                    msg.setMsg("两次新密码不一致，请重新输入");
                    return msg;
                }
                else {
                    Md5Hash md5=new Md5Hash(newPassword);

                    user.setUserPassword(md5.toString());
                    userDao.updatePasw(user);
                    msg.setMsg("修改密码成功");
                    return msg;
                }
            }
        }
    }

    @Override
    public Message updateUser(UserInfo user, MultipartFile filedata, HttpServletRequest request) {
        Message msg=new Message();
        UserInfo u=userDao.findById(user.getId());
        if (u!=null){
            if (user.getUserName().equals("")||user.getUserName()==null){
                msg.setMsg("用户名不能为空");
                return msg;
            }else {
                if (user.getUserSex()==null){
                    msg.setMsg("性别不能为空");
                    return msg;
                }else {
                    if (user.getUserSex().equals("0")) {
                        user.setUserSex("女");
                    }else {
                        user.setUserSex("男");
                    }

                    //判断上传文件
                    if (filedata.getSize() != 0) {
                        String src = UpUtils.getSrc(filedata, request);
                        user.setUserIcon(src);
                    } else {
                        user.setUserIcon(user.getUserIcon());
                    }

                    userDao.updakteUser(user);
                    msg.setMsg("修改资料成功");
                    request.getSession().setAttribute("u", user);
                    return msg;
                }

            }

        }else {
            msg.setMsg("用户不存在");
            return msg;
        }
    }

    @Override
    public JSONArray findMessge(String id) {
        List<Publish> publishes=userDao.findMessge(id);
        JSONArray jsonArray=new JSONArray();
        for (Publish p:publishes){
            JSONObject j=new JSONObject();
            j.put("userName",p.getPublisher().getUserInfo().getUserName());
            j.put("mContent",p.getmContent());
            j.put("mType",p.getmType());

            jsonArray.add(j);
        }
        return jsonArray;
    }

    @Override
    public List<UserInfo> findPublish(List<Publish> users) {
        List<UserInfo> userInfos=new ArrayList<>();

        if (users.size()>0){

            return userInfos;
        }else {
            return null;
        }
    }

}
