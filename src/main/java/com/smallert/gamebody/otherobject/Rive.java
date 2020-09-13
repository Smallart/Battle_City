package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

/**
 * 游戏中的河流
 */
public class Rive extends GameObject {

    public Rive(int positionX, int positionY, int width, int height, boolean isLiving) {
        super(positionX, positionY, width, height, isLiving);
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        if (Math.random()<0.4){
            g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Rive1.ordinal()],positionX,positionY,null);
        }else if (Math.random()<0.7){
            g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Rive2.ordinal()],positionX,positionY,null);
        }else if (Math.random()<1){
            g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Rive3.ordinal()],positionX,positionY,null);
        }
    }

    /**
     * todo 目前河流是永久地形，没有销毁方法。之后可是看看实不实现该方法
     */
    @Override
    public void destroy() {

    }
}
