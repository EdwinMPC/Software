package com.example.killthemall_training;
import java.util.Random;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

//Clase de los movimientos de los graficos- zombies
public class Sprite {
	private static final int BMP_COLUMNS = 3;
	private static final int BMP_ROWS = 4;
    int[] DIRECTION_TO_ANIMATION_MAP = {3,1,0,2};
	private int x ; 
	private int y ;
    private int xSpeed=5;
    private int ySpeed;
    private GameView gameView;
    private Bitmap bmp;
	private int height;
	private int width;
	private int currentFrame=0;
	
   
	//Segmentar el grafico zombies en un cuadrado  y dar random
    public Sprite(GameView gameView, Bitmap bmp) {
          this.gameView=gameView;
          this.bmp=bmp;
          this.width = bmp.getWidth() / BMP_COLUMNS;
          this.height = bmp.getHeight() / BMP_ROWS;
          Random rnd = new Random(System.currentTimeMillis());
          x = rnd.nextInt(gameView.getWidth() - width);
          y = rnd.nextInt(gameView.getHeight() - height);
          xSpeed = rnd.nextInt(10)-5;
          ySpeed = rnd.nextInt(10)-5;
    }

    //Movimiento del grafico zombies segmentados 
    private void update() {
    	if (x > gameView.getWidth() - width - xSpeed || x + xSpeed < 0) {
            xSpeed = -xSpeed;
         }
          x = x + xSpeed;
         if (y > gameView.getHeight() - height - ySpeed || y + ySpeed < 0) {
            ySpeed = -ySpeed;
         }
         y = y + ySpeed; 
         currentFrame = ++currentFrame % BMP_COLUMNS;
    }
   
    
    //Dibujar la graficas en el interface
    @SuppressLint("DrawAllocation")
	public void onDraw(Canvas canvas) {
          update();
          int srcX = currentFrame * width;
          int srcY = getAnimationRow()* height;
          Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
          Rect dst = new Rect(x, y, x + width, y + height);
          canvas.drawBitmap(bmp,src, dst, null);
    }
   
   
    //Direccion donde va em´pezar la imagen zombies
    private int getAnimationRow() {
          double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) + 2);
          int direction = (int) Math.round(dirDouble) % BMP_ROWS;
          return DIRECTION_TO_ANIMATION_MAP[direction];
    }

    //Para que se colisiones los graficos zombies
	public boolean isCollition(float x2, float y2) 
	{
		return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
	}
    }
