package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;

public class cabeza extends partemonigote {
	
	
	cabeza(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		super(canvas, pincel, datos);
		pinta();
	}


	public void pinta()
	{
		this.getCanvas().drawCircle(this.getDatos().getCentrox(),
									this.getDatos().getCentroy(),
									this.getDatos().getRadiocabeza(),
									this.getPincel());
				
	}
	
}
