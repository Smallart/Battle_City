package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.otherobject.Bullet;
import com.smallert.gamebody.otherobject.Home;

/**
 * 子弹撞击基地
 */
public class BulletCollideHome implements BasicCollisionInter{
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof Bullet&& gameTwo instanceof Home){
            if (gameOne.getRectangle().intersects(gameTwo.getRectangle())){
                Bullet bullet =(Bullet) gameOne;
                Home home = (Home) gameTwo;
                bullet.destroy();
                home.destroy();
            }
            return false;
        }else if (gameTwo instanceof Bullet&& gameOne instanceof Home){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}
