package com.example.killthemall_training;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.List;

//Clase principal donde se carga las imagenes- Zombies
@SuppressLint("WrongCall")
public class GameView extends SurfaceView {
	private int j=0;
	private SurfaceHolder holder;
	private GameLoopThread gameLoopThread;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	private long lastClick;
	private Bitmap bmpBlood;
	private List<TempSprite> temps = new ArrayList<TempSprite>();
	

	//Cargar las velocidades, cargar las imagenes en la interface 
	public GameView(Context context) {
		super(context);
		gameLoopThread = new GameLoopThread(this);
		 holder = getHolder();
         holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
                gameLoopThread.setRunning(false);
                while (retry) {
                       try {
                             gameLoopThread.join();
                             retry = false;
                       } catch (InterruptedException e) {
                       }
                }
			}
			
			
			//Llamar la velocidad de los imagenes
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				createSprites();
				gameLoopThread.setRunning(true);
                gameLoopThread.start();
                
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
                    int width, int height) {
				
			}
         });
         bmpBlood = BitmapFactory.decodeResource(getResources(), R.drawable.sangre);
	     }
	

	  // Cagar las imagenes
         private void createSprites() {
         sprites.add(createSprite(R.drawable.img1));
         sprites.add(createSprite(R.drawable.img2));
         sprites.add(createSprite(R.drawable.img3));
         sprites.add(createSprite(R.drawable.img4));
         sprites.add(createSprite(R.drawable.img5));
         sprites.add(createSprite(R.drawable.img6));
         sprites.add(createSprite(R.drawable.img7));
         sprites.add(createSprite(R.drawable.img8));
         sprites.add(createSprite(R.drawable.img9));
         sprites.add(createSprite(R.drawable.img10));
         sprites.add(createSprite(R.drawable.img11));
         sprites.add(createSprite(R.drawable.img12));
         sprites.add(createSprite(R.drawable.img13));
         sprites.add(createSprite(R.drawable.img14));
	}
         
	private Sprite createSprite(int resouce) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
        return new Sprite(this,bmp);
  }
	
	//Color de la inferface del juego Mata Zombies
	protected void onDraw(Canvas canvas) {

	canvas.drawColor(Color.BLUE);
     for (int i = temps.size() - 1; i >= 0; i--) {
         temps.get(i).onDraw(canvas);
      }
     for (Sprite sprite : sprites) {
         sprite.onDraw(canvas);
  }
 }
	
	
	
	//cargar la imagen sangrado cada vez que se haga click en la imagen zombies
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		if (System.currentTimeMillis() - lastClick > 300) {
            lastClick = System.currentTimeMillis();
		synchronized (getHolder()) {  
	     float y=event.getY();
	     float x=event.getX();		
	     
		for (int i = sprites.size()-1; i >= 0; i--) {
                 Sprite sprite = sprites.get(i);
                 
                 if (sprite.isCollition(event.getX(),event.getY())) {
                	 if(i==-1)
                     {
                    	 
                       try {
    						finalize();
    					} catch (Throwable e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                     }
                        sprites.remove(sprite);
						temps.add(new TempSprite(temps, this, x, y, bmpBlood));
                       break;
                 }
                 
                 
          }
		}
		}
          return true;
    }	
}
