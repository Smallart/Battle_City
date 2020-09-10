package com.smallert.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImgLoadUtil {
    public static BufferedImage Battle_City,MENU_ELECT_Tank;
    static {
        try {
            Battle_City = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/battlecity.png")),0.8);
            MENU_ELECT_Tank = ImageUtil.zoomImage(ImageIO.read(ImgLoadUtil.class.getClassLoader().getResourceAsStream("imgs/tankL.png")),0.7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
