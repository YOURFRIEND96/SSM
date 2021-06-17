package com.abc.mybatis.util;

import java.util.UUID;

public class IDUtil {

    public static String generateID()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
