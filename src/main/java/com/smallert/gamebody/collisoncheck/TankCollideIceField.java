package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;
import com.smallert.gamebody.otherobject.IceField;
import com.smallert.gamebody.tank.TankObject;

public class TankCollideIceField implements BasicCollisionInter {
    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        if (gameOne instanceof TankObject && gameTwo instanceof IceField){
            TankObject tank = (TankObject) gameOne;
            if (gameOne.getRectangle().intersects(gameTwo.getRectangle())){
                IceField iceField =(IceField) gameTwo;
                if (tank.getPreSpeed()==tank.getSpeed()){
                    iceField.enhanceTankSpeed(tank);
                }
            }else {
                if (tank.getSpeed()!=tank.getPreSpeed()){
                    tank.setSpeed(tank.getPreSpeed());
                }
            }
            return false;
        }else if (gameTwo instanceof TankObject && gameOne instanceof IceField){
            collide(gameTwo,gameOne);
        }
        return true;
    }
}
