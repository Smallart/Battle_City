package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 游戏中的雨林
 * 坦克可以藏匿于雨林中
 */
public class Forest extends GameObject {

    public Forest(int positionX, int positionY, int width, int height, boolean isLiving) {
        super(positionX, positionY, width, height, isLiving);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()],positionX,positionY,null);
    }

    /**
     * todo 雨林 无法修改的地形
     */
    @Override
    public void destroy() {

    }
}
