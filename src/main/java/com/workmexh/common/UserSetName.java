package com.workmexh.common;

import java.util.Random;
// 普通类 注册专用类
/*
* 注册用户时，判断用户账号是否重复
*
*
* */
public class UserSetName {
//    例 6 2个字母为1,1个数字为1
    public String setName(int length){
        String username = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if ("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                username += (char) (choice + random.nextInt(26));

            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                username += String.valueOf(random.nextInt(10));
            }
        }

        return username;


    }

}
