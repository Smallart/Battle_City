package com.smallert.common;

public enum GameObjectType {
    Boom,Clock,Shovel,Star,Tank,
    BrickWall,VerticalBrickWall,SpotBrickWall,TransverseBrickWall,IronWall,VerticalIronWall,TransverseIronWall,
    Rive1,Rive2,Rive3,
    Home,HomeDestroy,
    Forest,IceField,
    GameOver,GameOver_Small,Pause,
    Bullet;

    public static GameObjectType getGameObject(int index){
        for (GameObjectType value : GameObjectType.values()) {
            if (value.ordinal()==index){
                return value;
            }
        }
        return Boom;
    }
}
