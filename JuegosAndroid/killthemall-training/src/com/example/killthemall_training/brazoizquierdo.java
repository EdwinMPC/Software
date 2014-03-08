package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class brazoizquierdo extends partemonigote{

	
	brazoizquierdo(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}


	public void pinta()
	{
	
		this.getCanvas().drawRect(this.getDatos().getBisupizq(),
								  this.getDatos().getBisup(),
								  this.getDatos().getBiinfder(),
								  this.getDatos().getBiinf(),
								  this.getPincel());
				
	}
	
}