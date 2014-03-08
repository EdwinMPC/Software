package com.example.killthemall_training;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.View;


public class Escenario extends View {

	private final Juego juego;
	private Resources res;
	private Context context;
	private palabra palabra_juego;
	private boolean nuevo_juego = true;
	private boolean letra_pulsada = false;
	private Monigote monigote;


	
	public Escenario(Context context, Resources res) {
		super(context);
		this.res = res;
		this.context = context;
		this.juego = (Juego) context;
		setFocusable(true);
		
	
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
	
			
// Ponemos en marcha la música, sólo si el reproductor está parado
		
		if (audiojuego.get_mireproductor() == null)
		{
			audiojuego.reproduce(context, R.raw.todo);
		}
		
		
		if(nuevo_juego)
		{
			monigote = new Monigote(canvas);
			palabra_juego = new palabra(res, canvas, monigote);		
			palabra_juego.getPalabra();
			nuevo_juego = false;
			
			
		}

		monigote.pinta();
		palabra_juego.pinta_palabra();
		
		// pintamos los aciertos
		
		palabra_juego.pinta_letra();
	
		// pintamos los fallos
		
		monigote.pinta_fallos(palabra_juego.getLetras_falladas().length());

	}

	public palabra getPalabra_juego() {
		return palabra_juego;
	}

	public void setLetra_pulsada(boolean letraPulsada) {
		letra_pulsada = letraPulsada;
	}


}
