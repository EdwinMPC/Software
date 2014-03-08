package com.example.killthemall_training;

import android.R.color;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Monigote {

	Paint pincelgris;
	Paint pincelblanco;
	Canvas canvas;
	private int transparencia = 50;

	private datosmonigote datos;
	
	private cabeza cabezamonigote;
	private tronco troncomonigote;
	private brazoderecho bdmonigote;
	private brazoizquierdo bimonigote;
	private piernaizquierda pimonigote;
	private piernaderecha pdmonigote;
	
	private final int error_pizquierda = 6;  // para el control de los fallos.
	private final int error_pderecha = 5;
	private final int error_bizquierdo = 4;
	private final int error_bderecho = 3;
	private final int error_tronco = 2;
	private final int error_cabeza = 1;
	
	
	Monigote(Canvas canvas)
	{
		this.canvas = canvas;
		
		inicializa();
		//pinta();
	}
	
	private void inicializa()
	{

		inicializa_pincelgris();
		inicializa_pincelblanco();
	}
	
	private void inicializa_pincelgris()
	{
		pincelgris = new Paint();
		pincelgris.setColor(Color.BLUE);
		pincelgris.setAlpha(get_transparencia());
	}
	
	private void inicializa_pincelblanco()
	{
		pincelblanco = new Paint();
		pincelblanco.setColor(Color.BLUE);
	}


	public void pinta()
	{		

		datos = new datosmonigote(canvas);
		cabezamonigote = new cabeza(canvas,pincelgris, datos);
		troncomonigote = new tronco(canvas,pincelgris, datos);

		pinta_brazos(pincelgris);
		pinta_piernas(pincelgris);

	}
	
	private void pinta_brazos(Paint pincel)
	{
		//brazoderecho
		
		bdmonigote = new brazoderecho(canvas, pincel, datos);
		
		//brazoizquierdo

		bimonigote = new brazoizquierdo(canvas, pincel, datos);
	}
	

	

	
	private void pinta_piernas(Paint pincel)
	{
		

		pimonigote = new piernaizquierda(canvas, pincel, datos);
		

		pdmonigote = new piernaderecha(canvas, pincel, datos);
		
	}
	

	
	private int get_transparencia()
	{
		return transparencia;
	}
	
	public datosmonigote getdatosmonigote()
	{
		return datos;
	}
	
	public void pinta_fallos(int numero_fallos)
	{
		if (numero_fallos >= error_pizquierda)
		{
			pimonigote.setPincel(pincelblanco);
			pimonigote.pinta();
		}
		
		if (numero_fallos >= error_pderecha)
		{
			pdmonigote.setPincel(pincelblanco);
			pdmonigote.pinta();
		}
		
		if (numero_fallos >= error_bizquierdo)
		{
			bimonigote.setPincel(pincelblanco);
			bimonigote.pinta();
		}
		
		if (numero_fallos >= error_bderecho)
		{
			bdmonigote.setPincel(pincelblanco);
			bdmonigote.pinta();
		}
		
		if (numero_fallos >= error_tronco)
		{
			troncomonigote.setPincel(pincelblanco);
			troncomonigote.pinta();
		}
		
		if (numero_fallos >= error_cabeza)
		{
			cabezamonigote.setPincel(pincelblanco);
			cabezamonigote.pinta();
		}
	}
}
