package com.smallert.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgLoadUtil {
    public static BufferedImage Battle_City,MENU_ELECT_Tank;
    public static BufferedImage EnemyTankCountIco,PlayerTankCountIco,PlayerOneIco,PlayerTwoIco,Home,BrickWallSmall,BrickWall;
    public static BufferedImage Born1;
    public static BufferedImage Player1TankU,Player1TankL,Player1TankD,Player1TankR;
    public static BufferedImage BulletU,BulletL,BulletD,BulletR;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
