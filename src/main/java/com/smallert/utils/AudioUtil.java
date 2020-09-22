package com.smallert.utils;

import com.smallert.gamebody.Audio;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 音效控制
 */
public class AudioUtil{

    private static Executor executor = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(20));

    /**
     * 游戏开始音频
     */
    public static void stageStartAudio(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/stage_start.wav").play();
            }
        });

    }

    /**
     * 开火
     */
    public static void hireAudio(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/bullet_shot.wav").play();
            }
        });

    }

    /**
     * 子弹撞击
     */
    public static void bulletHitAudio(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/bullet_hit_1.wav").play();
            }
        });
    }

    /**
     * 坦克爆炸
     */
    public static void ExplosionAudio(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/explosion_1.wav").play();
            }
        });
    }

    public static void powerUpPick(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/powerup_pick.wav").play();
            }
        });
    }
}
