package com.smallert.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageUtil {
    public static BufferedImage zoomImage(BufferedImage image,double ratio){
        int width =(int) (image.getWidth() * ratio);
        int height =(int) (image.getHeight() * ratio);
        BufferedImage compatibleImage = getCompatibleImage(width, height);
        Graphics2D g2d = compatibleImage.createGraphics();
        double xScale = (double) width / image.getWidth();
        double yScale = (double) height / image.getHeight();
        AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
        g2d.drawRenderedImage(image, at);
        g2d.dispose();
        return compatibleImage;
    }


    private static BufferedImage getCompatibleImage(int w,int h){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage image = gc.createCompatibleImage(w, h);
        return image;
    }
}
