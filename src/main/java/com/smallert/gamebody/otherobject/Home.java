package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.common.MapEnum;
import com.smallert.gamebody.GameModule;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

public class Home extends GameObject {
    public Home(int positionX, int positionY, boolean isLiving) {
        super(positionX, positionY, isLiving);
        this.width = ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()].getWidth();
        this.height = ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()].getHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
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
        GameModule.currentMap = MapEnum.GAME_OVER;
    }

    public static int getPicWidth(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()].getWidth();
    }

    public static int getPicHeight(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Home.ordinal()].getHeight();
    }
}
