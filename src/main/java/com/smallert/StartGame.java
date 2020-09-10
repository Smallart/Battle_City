package com.smallert;

import com.smallert.gui.GameFrame;

/**
 * Hello world!
 *
 */
public class StartGame
{
    public static void main( String[] args )
    {
        GameFrame.getInstance().setVisible(true);
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GameFrame.getInstance().repaint();

        }
    }
}
