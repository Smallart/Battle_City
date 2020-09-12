package com.smallert.gamebody.collisoncheck;

import com.smallert.gamebody.GameObject;

/**
 * 游戏中物体的碰撞检测
 */
public interface BasicCollisionInter {
    boolean collide(GameObject gameOne,GameObject gameTwo);
}
