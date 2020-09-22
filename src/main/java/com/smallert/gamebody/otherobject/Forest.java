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

    public Forest(int positionX, int positionY, boolean isLiving) {
        super(positionX, positionY, isLiving);
        this.width = ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()].getWidth();
        this.height = ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()].getHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()],positionX,positionY,null);
    }

    /**
     * todo 雨林 无法修改的地形
     */
    @Override
    public void destroy() {

    }

    public static int getPicWidth(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()].getWidth();
    }

    public static int getPicHeight(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Forest.ordinal()].getHeight();
    }
}
