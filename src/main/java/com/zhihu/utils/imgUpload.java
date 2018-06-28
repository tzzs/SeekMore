package com.zhihu.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author tzz
 * @Package com.zhihu.utils
 * @Name imgUpload
 */
public class imgUpload {
    public static String getSrc(MultipartFile filedata, HttpServletRequest request) {
        //获取我们的当前路径 （项目部署在tomcat中的根路径）
        String proPath = request.getSession().getServletContext().getRealPath("/");
        String relPath = "E:\\Workspaces\\IdeaProjects\\book\\src\\main\\webapp\\";
        System.out.println("proPath:" + proPath);
        //设置文件上传后的保存路径
        String savePath = "images/filUp";
        //声明文件路径 并且创建该文件目录
        File file = new File(proPath + savePath);
        File file1 = new File(relPath + savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file1.exists()) {
            file1.mkdirs();
        }

        //创建文件输出流
        try {
            //获取上传文件的名称
            String orgName = filedata.getOriginalFilename();
            String end = orgName.substring(orgName.lastIndexOf("."));
            String start = String.valueOf(System.currentTimeMillis());

            String imgPath = savePath + "/" + start + end;
            FileOutputStream fos = new FileOutputStream(proPath + imgPath, true);
            FileOutputStream fos1 = new FileOutputStream(relPath + imgPath, true);

            fos.write(filedata.getBytes());
            fos.flush();
            fos.close();
            fos1.write(filedata.getBytes());
            fos1.flush();
            fos1.close();
            return imgPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
