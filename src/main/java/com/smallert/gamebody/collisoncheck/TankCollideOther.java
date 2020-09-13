package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.otherobject.Bullet;
import com.smallert.gamebody.tank.TankObject;

public class TankCollideOther implements BasicCollisionInter {
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if ((gameOne instanceof TankObject)&&!(gameTwo instanceof Bullet)){
            TankObject tankObject = (TankObject) gameOne;
            if (gameTwo instanceof TankObject){
                TankObject tank = (TankObject)gameTwo;
                if (tank.getRectangle().intersects(gameOne.getRectangle())){
                    tank.stop();
                }
            }
            if (tankObject.getRectangle().intersects(gameTwo.getRectangle())){
                tankObject.stop();
            }
            return false;
        }else if (!(gameOne instanceof TankObject)&&(gameTwo instanceof TankObject)){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}
