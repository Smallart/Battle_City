package com.smallert.utils;
import java.io.IOException;
import java.util.Properties;

/**
 * 加载游戏配置文件
 */
public class PropertyUtil {
    private static Properties props = new Properties();
    static {
        try {
            props.load(PropertyUtil.class.getClassLoader().getResourceAsStream("BattleCity.config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (props==null) return null;
        return props.get(key);
    }
}
