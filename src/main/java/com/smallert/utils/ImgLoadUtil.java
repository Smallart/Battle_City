package com.smallert.utils;

import com.smallert.common.Direction;
import com.smallert.common.GameObjectType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgLoadUtil {
    public static BufferedImage Battle_City,MENU_ELECT_Tank;
    public static BufferedImage EnemyTankCountIco,PlayerTankCountIco,PlayerOneIco,PlayerTwoIco,Home,BrickWallSmall,BrickWall;
    public static BufferedImage Born1;
    public static BufferedImage Player1TankU,Player1TankL,Player1TankD,Player1TankR;
    public static BufferedImage BulletU,BulletL,BulletD,BulletR;
    public static BufferedImage[] EnemyTank_Common_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Gift_Common_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Speed_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Gift_Speed_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Armor_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Gift_Armor_Yellow_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Gift_Armor_Green_Pic = new BufferedImage[4];
    public static BufferedImage[] EnemyTank_Gift_Armor_Red_Pic = new BufferedImage[4];
    public static BufferedImage[] Explosions = new BufferedImage[9];
    public static BufferedImage[] GameObjectTypes = new BufferedImage[5];

    static {
        try {
            Battle_City = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/battlecity.png")),0.8);
            MENU_ELECT_Tank = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/tankL.png")),0.7);
            EnemyTankCountIco = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/enemyTankCountIco.png"));
            PlayerTankCountIco = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/playerTankCountIco.png"));
            PlayerOneIco = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/playerOneIco.png"));
            PlayerTwoIco = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/playerTwoIco.png"));
            Home = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/home.png")),0.8);
            BrickWallSmall = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/brickwall.png")),0.4);
            BrickWall = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/brickwall.png"));
            Born1 = ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/born1.png"));
            Player1TankU = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/player1_tankU.png")),0.8);
            Player1TankL = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/player1_tankL.png")),0.8);
            Player1TankD = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/player1_tankD.png")),0.8);
            Player1TankR = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/player1_tankR.png")),0.8);
            BulletU = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/bulletU.png")),0.6);
            BulletR = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/bulletR.png")),0.6);
            BulletD = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/bulletD.png")),0.6);
            BulletL = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/bulletL.png")),0.6);

             // 加载敌方常规tank图片
            loadImgWithDir(EnemyTank_Common_Pic,"ET_C_");
             // 加载敌方突击tank图片
            loadImgWithDir(EnemyTank_Speed_Pic,"ET_S_");
            //  加载敌方装甲tank图片
            loadImgWithDir(EnemyTank_Armor_Pic,"ET_A_");
            //加载敌方奖励常规坦克
            loadImgWithDir(EnemyTank_Gift_Common_Pic,"ET_G_C_");
            //加载敌方奖励突击坦克
            loadImgWithDir(EnemyTank_Gift_Speed_Pic,"ET_G_S_");
            //加载敌方奖励装甲坦克 1
            loadImgWithDir(EnemyTank_Gift_Armor_Yellow_Pic,"ET_A_G_Y_");
            //加载敌方奖励装甲坦克 2
            loadImgWithDir(EnemyTank_Gift_Armor_Green_Pic,"ET_A_G_G_");
            //加载敌方奖励装甲坦克 3
            loadImgWithDir(EnemyTank_Gift_Armor_Red_Pic,"ET_A_G_R_");
            //加载爆炸
            for (int i=0;i<Explosions.length;i++){
                Explosions[i] = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/explosion"+ (i+1) +".png")),0.8);
            }
            //加载游戏其他物体
            loadGameObject(GameObjectTypes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadImgWithDir(BufferedImage[] imgs,String picName) throws IOException {
        for (int i=0;i<imgs.length;i++){
            imgs[i] = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/"+picName+ Direction.values()[i].toString() +".png")),0.8);
        }
    }

    private static void loadGameObject(BufferedImage[] imgs) throws IOException {
        for (int i=0;i<imgs.length;i++){
            imgs[i] = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/"+ GameObjectType.values()[i]+".png")),0.8);
        }
    }
}
