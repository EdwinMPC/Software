package com.example.killthemall_training;

import android.annotation.SuppressLint;
import android.graphics.Canvas;


//Clase para la velocidad del grafico- zombie
@SuppressLint("WrongCall")
public class GameLoopThread extends Thread {
    static final long FPS=10;
	private GameView view;
    private boolean running = false;
   
    public GameLoopThread(GameView view) {
          this.view = view;
    }

    public void setRunning(boolean run) {
          running = run;
    }

    //Veocidad del zombie
    @Override
    public void run() {
    	 long ticksPS =1/FPS;
    	 long startTime;
    	 long sleepTime;
          while (running) {
                 Canvas c = null;
                 startTime = System.currentTimeMillis();
                 try {
                        c = view.getHolder().lockCanvas();
                        synchronized (view.getHolder()) {
                               view.onDraw(c);
                        }
                 } finally {
                        if (c != null) {
                               view.getHolder().unlockCanvasAndPost(c);
                        }
                 }
                 sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
                 try {
                        if (sleepTime > 0)
                               sleep(sleepTime);
                        else
                               sleep(10);
                 } catch (Exception e) {}
          }
    }
}  