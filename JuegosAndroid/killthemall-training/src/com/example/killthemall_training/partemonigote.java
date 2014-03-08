package com.example.killthemall_training;

import android.graphics.Canvas;
import android.graphics.Paint;


public class partemonigote {

	private Canvas canvas;
	private Paint pincel;
	private datosmonigote datos;
	
	partemonigote(Canvas canvas, Paint pincel, datosmonigote datos)
	{
		this.canvas = canvas;
		this.pincel = pincel;
		this.datos = datos;
	}

	protected Canvas getCanvas() {
		return canvas;
	}

	protected Paint getPincel() {
		return pincel;
	}

	protected datosmonigote getDatos() {
		return datos;
	}

	public void setPincel(Paint pincel) {
		this.pincel = pincel;
	}
	
}
