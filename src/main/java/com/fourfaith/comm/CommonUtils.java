package com.fourfaith.comm;

import java.util.UUID;

/**
 * @author chenyuepeng
 * @create 2018-03-15 14:31
 * @since: 1.0.0
 * @desc 公共方法
 **/
public class CommonUtils {

    public static String getGuid()
    {
        UUID uuid = UUID.randomUUID();
        String sUuid = uuid.toString();
        String s = sUuid.replaceAll("-", "").toUpperCase();
        return s;
    }
}
