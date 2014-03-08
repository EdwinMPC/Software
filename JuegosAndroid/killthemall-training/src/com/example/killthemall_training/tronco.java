package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class tronco extends partemonigote{
	
	
	tronco(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}

	
	public void pinta()
	{
		this.getCanvas().drawRect(this.getDatos().getTroncsupizq(),
								  this.getDatos().getTroncsup(),
								  this.getDatos().getTroncinfder(),
								  this.getDatos().getTroncinf(),
								  this.getPincel());
	}
}

