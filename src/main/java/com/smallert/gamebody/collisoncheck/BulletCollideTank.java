package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.otherobject.Bullet;
import com.smallert.gamebody.tank.TankObject;

/**
 * 子弹与坦克的碰撞
 */
public class BulletCollideTank implements BasicCollisionInter {
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if ((gameOne instanceof Bullet)&&(gameTwo instanceof TankObject)){
            Bullet bullet = (Bullet)gameOne;
            TankObject tankObject =(TankObject)gameTwo;
            if (bullet.getGroup()!=tankObject.getGroup()){
                if (tankObject.getRectangle().intersects(bullet.getRectangle())){
                    bullet.destroy();
                    /**
                     * todo 对不同坦克不一样处理
                     */
                    tankObject.setArmorGrade(tankObject.getArmorGrade()-1);
                    tankObject.destroy();
                }
            }
            return false;
        }else if ((gameTwo instanceof Bullet)&&(gameOne instanceof TankObject)){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}
