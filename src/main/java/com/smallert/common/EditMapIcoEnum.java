package com.smallert.common;

public enum EditMapIcoEnum {
    Delete(0),
    IronWall(GameObjectType.IronWall.ordinal()),
    BrickWall(GameObjectType.BrickWall.ordinal()),
    IceField(GameObjectType.IceField.ordinal()),
    Forest(GameObjectType.Forest.ordinal()),
    Home(GameObjectType.Home.ordinal()),
    Error(-1);

    private int index;
    EditMapIcoEnum(int index){
        this.index = index;
    }

    public static EditMapIcoEnum getIndexByItem(int index){
        for (EditMapIcoEnum value : values()) {
            if (index==value.index){
                return value;
            }
        }
        return Error;
    }

    public int getIndex() {
        return index;
    }
}
