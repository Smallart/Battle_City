package com.smallert.gamebody.gift;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;

import java.awt.*;

public class Gift extends GameObject {

    private int liftTime;
    private GameObjectType gameObjectType;

    public Gift(int positionX, int positionY, boolean isLiving,int liftTime) {
        super(positionX, positionY, isLiving);
        this.liftTime = liftTime;
        this.gameObjectType = GameObjectType.values()[(int)Math.random()*5];
        this.width = ImgLoadUtil.GameObjectTypes[GameObjectType.Boom.ordinal()].getWidth();
        this.height = ImgLoadUtil.GameObjectTypes[GameObjectType.Boom.ordinal()].getHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        if (Math.random()>0.3){
            g.drawImage(ImgLoadUtil.GameObjectTypes[gameObjectType.ordinal()],positionX,positionY,null);

        }
        lifeCountDown();
    }

    @Override
    public void destroy() {
        isLiving = false;
        gm.getGameBodyList().remove(this);
    }

    private void lifeCountDown(){
        if (liftTime<0){
            destroy();
        }else {
            liftTime-=1;
        }
    }

    public static int getPicWidth(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Boom.ordinal()].getWidth();
    }

    public static int getPicHeight(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.Boom.ordinal()].getWidth();
    }
}
