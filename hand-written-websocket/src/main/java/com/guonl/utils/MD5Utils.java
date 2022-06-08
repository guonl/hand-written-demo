package com.guonl.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static void main(String[] args) {

        String text = "MB00" + "111111";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            String s = toHexString(digest);
            System.out.println(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder(50);
        int t;
        for (int i = 0; i < bytes.length; i++) {
            t = bytes[i];
            if (t < 0) {
                t += 256;
            }
            if (t < 16) {
                builder.append("0");
            }
            builder.append(Integer.toHexString(t));
        }
        return builder.toString();
    }


}
