package com.example.killthemall_training;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;

public class Juego extends Activity{

	private Escenario escenario;
	private Resources res;
	private String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	
	// control de fin de juego
	
	private boolean fin_juego = false;

	
	
	
	protected void onCreate(Bundle savedInstanceState)
	{
	
		
		super.onCreate(savedInstanceState);
		res = getResources();
		this.escenario = new Escenario(this, res);
		setContentView(this.escenario);
		
	
		// visualizar teclado soft siempre 
		InputMethodManager imm =
			(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
			InputMethodManager.HIDE_IMPLICIT_ONLY); 
			

	}
	// control de las pulsaciones de las teclas
	//
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		
		if (keyCode != event.KEYCODE_BACK)
		{
			
		
			String caracter = Character.toString(event.getDisplayLabel());
		
		
			if (esletra(caracter))
			{
				// Aquí seguiremos con la lógica del juego.
			
				if(letraenpalabra(caracter) && !letraenacertadas(caracter) && !letraenfalladas(caracter))
				{
					// añadimos la letra acertada al String de control.
				
					
					escenario.getPalabra_juego().setLetras_acertadas(escenario.getPalabra_juego().getLetras_acertadas() + caracter);
				
					escenario.setLetra_pulsada(true);
					
				
				}
				else
				{
				// si no está, controlamos al monigote
				
				// añadimos la letra fallada al String de control.
				
					escenario.getPalabra_juego().setLetras_falladas(escenario.getPalabra_juego().getLetras_falladas() + caracter);
				}
				
				escenario.invalidate(); //forzamos el repintado del juego
			}
		
		}
		else
		{
			moveTaskToBack(true); // Si pulsa la tecla Back, Nos vamos al menú principal.
		}
		return true;
		
	}
	
	@Override
	protected void onStop()
	{
		//paramos la música siempre que la activity queda en background
		
		audiojuego.para_musica();
		super.onStop();
	}
	
	
	private boolean esletra(String caracter)
	{
		return  letras.contains(caracter);
	}
	
	private boolean letraenpalabra(String caracter)
	{
		return escenario.getPalabra_juego().getPalabra_en_curso().contains(caracter);
	}
	
	private boolean letraenacertadas(String caracter)
	{
		return escenario.getPalabra_juego().getLetras_acertadas().contains(caracter);
	}
	
	private boolean letraenfalladas(String caracter)
	{
		return escenario.getPalabra_juego().getLetras_falladas().contains(caracter);
	}
}
