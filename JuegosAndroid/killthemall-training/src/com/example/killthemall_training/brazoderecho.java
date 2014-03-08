package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class brazoderecho extends partemonigote{

	
	brazoderecho(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}


	public void pinta()
	{
	
		this.getCanvas().drawRect(this.getDatos().getBdsupizq(),
								  this.getDatos().getBdsup(),
								  this.getDatos().getBdinfder(),
								  this.getDatos().getBdinf(),
								  this.getPincel());
				
	}
	
}
