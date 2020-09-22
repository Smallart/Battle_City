package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 碰撞管理
 */
public class CollisionManger implements BasicCollisionInter{

    private List<BasicCollisionInter> collisionInters = new LinkedList<>();

    public CollisionManger(){
        add(new BulletCollideTank());
        add(new BulletCollideWall());
        add(new BulletCollideHome());
        add(new TankCollideGift());
        add(new TankCollideForest());
        add(new TankCollideIceField());
        add(new TankCollideOther());
    }

    public void add(BasicCollisionInter basicCollision){
        collisionInters.add(basicCollision);
    }

    @Override
    public boolean collide(GameObject gameOne, GameObject gameTwo) {
        for (BasicCollisionInter collisionInter : collisionInters) {
            if (!collisionInter.collide(gameOne,gameTwo)){
                return false;
            }
        }
        return true;
    }
}
