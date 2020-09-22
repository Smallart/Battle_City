package com.smallert.gamebody.map;

import com.smallert.common.GameObjectType;
import com.smallert.gui.GameFrame;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 游戏结束界面
 */
public class GameOverMap extends GameMap {

    private GameOverMap(){}
    private static GameOverMap INSTANCE = new GameOverMap();
    public static GameOverMap getInstance(){
        return INSTANCE;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.GameOver.ordinal()], (GameFrame.GAME_WIDTH-ImgLoadUtil.GameObjectTypes[GameObjectType.GameOver.ordinal()].getWidth())/2,
                (GameFrame.GAME_HEIGHT-ImgLoadUtil.GameObjectTypes[GameObjectType.GameOver.ordinal()].getHeight())/2,null);
    }
}
