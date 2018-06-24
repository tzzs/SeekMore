package com.zt.book.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author tzz
 * @Package com.zt.book.test
 * @Name M
 */
public class M {
    public static void main(String[] args) {
        String s = "111";
        Md5Hash md5 = new Md5Hash(s);
        String s1 = md5.toString();
        System.out.println(s1);
    }
}
