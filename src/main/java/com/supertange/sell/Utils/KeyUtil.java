package com.supertange.sell.Utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一的主键
     * @return
     */
    public  static synchronized String genUniqueKey(){
        Random random=new Random();
        System.currentTimeMillis();
        Integer a=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(a);
    }
}
