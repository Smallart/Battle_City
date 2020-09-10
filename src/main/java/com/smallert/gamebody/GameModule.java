package com.smallert.gamebody;

import com.smallert.commond.MapEnum;
import com.smallert.gamebody.map.MenuMap;

import java.awt.*;

/**
 * 中介,单例模式避免被多次实例化导致绘画异常
 * 所有地图中对象交给它处理
 */
public class GameModule {
    private static final GameModule INSTANCE = new GameModule();

    private GameModule(){}

    public static GameModule getInstance(){
        return INSTANCE;
    }

    public static MapEnum currentMap = MapEnum.MENU;

    public void paint(Graphics g) {
        switch (currentMap){
            case MENU:
                MenuMap.getInstance().paint(g);
                break;
        }

    }
}
