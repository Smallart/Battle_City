package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.tank.TankObject;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;

/**
 * 游戏中的冰原地形
 * 坦克在冰原上会有速度的增加
 */
public class IceField extends GameObject {

    private int enhanceSpeed;

    public IceField(int positionX, int positionY, boolean isLiving) {
        super(positionX, positionY,  isLiving);
        this.width = ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()].getWidth();
        this.height = ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()].getHeight();
        this.rectangle = new Rectangle(positionX,positionY,width,height);
        this.enhanceSpeed =Integer.parseInt((String)PropertyUtil.get("IceFieldSpeed"));
        gm.getGameBodyList().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!isLiving) return;
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()],positionX,positionY,null);
    }

    /**
     * todo 无法被摧毁
     */
    @Override
    public void destroy() {

    }

    public void enhanceTankSpeed(TankObject tank){
        tank.setSpeed(tank.getSpeed()+this.enhanceSpeed);
    }

    public static int getPicWidth(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()].getWidth();
    }

    public static int getPicHeight(){
        return ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()].getHeight();
    }
}
