package com.example.killthemall_training;

import android.content.Context;
import android.media.*;

public class audiojuego {

	   private static MediaPlayer mireproductor = null;

	      
	   public static void reproduce(Context context, int resource) {
	      
		   para_musica();

	      
	      if (Configuracion.getMusic(context)) {
	    	  mireproductor = MediaPlayer.create(context, resource);
	    	  mireproductor.setLooping(true);
	    	  mireproductor.start();
	      }
	   }
	   

	
	   public static void para_musica() { 
	      if (mireproductor != null) {
	    	  mireproductor.stop();
	    	  mireproductor.release();
	    	  mireproductor = null;
	      }
	   }
	   
	   public static MediaPlayer get_mireproductor()
	   {
		   return mireproductor;
	   }
	
}
