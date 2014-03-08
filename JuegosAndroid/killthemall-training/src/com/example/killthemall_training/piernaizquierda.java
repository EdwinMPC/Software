package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class piernaizquierda extends partemonigote {

	
	piernaizquierda(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}


	public void pinta()
	{
	
		this.getPincel().setStrokeWidth(this.getDatos().getAnchopierna());
		
		this.getCanvas().drawLine(this.getDatos().getPisupizq(),
								  this.getDatos().getPisup(),
								  this.getDatos().getPiinfder(),
								  this.getDatos().getPiinf(),
								  this.getPincel());
				
	}
	
}
