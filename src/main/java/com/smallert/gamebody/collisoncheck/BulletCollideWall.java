package com.smallert.gamebody.collisoncheck;

import com.smallert.common.GameObjectType;
import com.smallert.gamebody.Audio;
import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.GameObjectSimpleFactory;
import com.smallert.gamebody.otherobject.Bullet;
import com.smallert.gamebody.otherobject.Wall;
import com.smallert.utils.AudioUtil;

public class BulletCollideWall implements BasicCollisionInter{
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof Bullet && gameTwo instanceof Wall){
            if (gameOne.getRectangle().intersects(gameTwo.getRectangle())){
                Bullet bullet = (Bullet) gameOne;
                Wall wall = (Wall) gameTwo;
                if (wall.getArmorGrade()<=bullet.getPierceGrade()){
                    wall.destroy();
                }
                bullet.destroy();
                GameObjectSimpleFactory.createExplosion(bullet.getPositionX(),bullet.getPositionY(),true, GameObjectType.Bullet);
                return false;
            }
            return true;
        }else if (gameTwo instanceof Bullet && gameOne instanceof Wall){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}
