package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

public class Home extends GameObject {

    public Home(int positionX, int positionY, int width, int height, boolean isLiving) {
        super(positionX, positionY, width, height, isLiving);
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (isLiving){
            g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()],positionX,positionY,null);
        }else {
            g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.HomeDestroy.ordinal()],positionX,positionY,null);
        }
    }

    @Override
    public void destroy() {
        isLiving = false;
    }
}
