package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class piernaderecha extends partemonigote{


	piernaderecha(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}


	public void pinta()
	{
	
		this.getPincel().setStrokeWidth(this.getDatos().getAnchopierna());
		
		this.getCanvas().drawLine(this.getDatos().getPdsupizq(),
								  this.getDatos().getPdsup(),
								  this.getDatos().getPdinfder(),
								  this.getDatos().getPdinf(),
								  this.getPincel());
				
	}
}
