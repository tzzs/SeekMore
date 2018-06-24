package com.zt.book.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author tzz
 * @Package com.zt.book.utils
 * @Name Md5Utils
 */
public class Md5Utils {

    static String Md5Utils(String password) {
        Md5Hash md5Hash = new Md5Hash(password);
        return md5Hash.toString();
    }

}
