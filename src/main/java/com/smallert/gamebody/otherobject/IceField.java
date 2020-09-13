package com.smallert.gamebody.otherobject;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.GameObject;
import com.smallert.utils.ImgLoadUtil;
import com.smallert.utils.PropertyUtil;

import java.awt.*;

/**
 * 游戏中的冰原地形
 * 坦克在冰原上会有速度的增加
 */
public class IceField extends GameObject {

    private int enhanceSpeed;

    public IceField(int positionX, int positionY, int width, int height, boolean isLiving) {
        super(positionX, positionY, width, height, isLiving);
        this.enhanceSpeed =Integer.parseInt((String)PropertyUtil.get("IceFieldSpeed"));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ImgLoadUtil.GameObjectTypes[GameObjectType.IceField.ordinal()],positionX,positionY,null);
    }

    /**
     * todo 无法被摧毁
     */
    @Override
    public void destroy() {

    }
}
