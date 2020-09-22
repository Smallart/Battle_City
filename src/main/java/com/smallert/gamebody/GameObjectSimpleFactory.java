package com.smallert.gamebody;

import com.smallert.common.Direction;
import com.smallert.common.EnemyTankType;
import com.smallert.common.GameObjectType;
import com.smallert.common.Group;
import com.smallert.gamebody.gift.Gift;
import com.smallert.gamebody.otherobject.*;
import com.smallert.gamebody.tank.EnemyTank;
import com.smallert.gamebody.tank.PlayerTank;

/**
 * 使用简单工厂创建对象
 */
public class GameObjectSimpleFactory {
    private GameObjectSimpleFactory(){}
    /**
     * 创建一颗子弹
     * @param positionX
     * @param positionY
     * @param isLiving
     * @param dir
     * @param speed
     * @param group
     * @return
     */
    public static Bullet createBullet(int positionX, int positionY,boolean isLiving, Direction dir, int speed, Group group,int pierceGrade){
        return new Bullet(positionX,positionY,isLiving,dir,speed,group,pierceGrade);
    }

    /**
     * 创建爆炸
     * @param positionX
     * @param positionY
     * @param isLiving
     * @return
     */
    public static Explosion createExplosion(int positionX, int positionY, boolean isLiving,GameObjectType objectType){
        return new Explosion(positionX, positionY, isLiving,objectType);
    }

    /**
     * 创建地图物体
     * @param type
     * @param positionX
     * @param positionY
     */
    public static void create(GameObjectType type,int positionX,int positionY){
        switch (type){
            case IceField:
                new IceField(positionX, positionY, true);
                break;
            case Home:
                new Home(positionX, positionY, true);
                break;
            case Forest:
                new Forest(positionX, positionY, true);
                break;
            case BrickWall:
                new Wall(positionX, positionY, true,GameObjectType.BrickWall, 0);
                break;
            case IronWall:
                new Wall(positionX, positionY, true,GameObjectType.IronWall, 2);
                break;
            case Rive1:
                new Rive(positionX, positionY,true);
                break;
        }
    }

    /**
     * 创建雨林
     * @param positionX
     * @param positionY
     * @param isLiving
     * @return
     */
    public static Forest createForest(int positionX, int positionY, boolean isLiving){
        return new Forest(positionX, positionY, isLiving);
    }

    /**
     * 创建基地
     * @param positionX
     * @param positionY
     * @param isLiving
     * @return
     */
    public static Home createHome(int positionX, int positionY, boolean isLiving){
        return new Home(positionX, positionY, isLiving);
    }

    /**
     * 创建冰原
     * @param positionX
     * @param positionY
     * @param isLiving
     * @return
     */
    public static IceField createIceField(int positionX, int positionY, boolean isLiving){
        return new IceField(positionX, positionY, isLiving);
    }

    /**
     * 创建河流
     * @param positionX
     * @param positionY
     * @param isLiving
     * @return
     */
    public static Rive createRive(int positionX, int positionY, boolean isLiving){
        return new Rive(positionX, positionY,isLiving);
    }

    /**
     * 创建墙壁
     * @param positionX
     * @param positionY
     * @param isLiving
     * @param wallType
     * @param armorGrade
     * @return
     */
    public static Wall createWall(int positionX, int positionY, boolean isLiving, GameObjectType wallType, int armorGrade){
        return new Wall(positionX, positionY, isLiving, wallType, armorGrade);
    }

    /**
     * 创建敌方坦克
     * @param positionX
     * @param positionY
     * @param speed
     * @param group
     * @param isLiving
     * @param dir
     * @param tankType
     * @param isGift
     * @return
     */
    public static EnemyTank createEnemyTank(int positionX, int positionY, int speed, Group group, boolean isLiving, Direction dir, EnemyTankType tankType, boolean isGift){
        return new EnemyTank(positionX, positionY, speed, group, isLiving, dir, tankType, isGift);
    }

    /**
     * 创建玩家坦克
     * @param positionX
     * @param positionY
     * @param speed
     * @param group
     * @param isLiving
     * @param dir
     * @param isGift
     * @return
     */
    public static PlayerTank createPlayerTank(int positionX, int positionY, int speed, Group group, boolean isLiving, Direction dir,boolean isGift){
        return new PlayerTank(positionX, positionY, speed, group, isLiving, dir, isGift);
    }

    /**
     * 创建奖励
     * @param positionX
     * @param positionY
     * @param isLiving
     * @param liftTime
     * @return
     */
    public static Gift createGift(int positionX, int positionY, boolean isLiving,int liftTime){
        return new Gift(positionX, positionY, isLiving, liftTime);
    }

}
