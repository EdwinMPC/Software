package com.example.killthemall_training;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class palabra {
	
	private String[] palabras;
	private Canvas lienzo;
	private Monigote munyeco;
	private String palabra_en_curso;
	private String letras_acertadas = "";
	private String letras_falladas = "";
	


	private int posicion_inicio;

	private int espacio_abajo = 35;
	private int espacio_entre = 7;
	private int tamanyo_linea = 20;
	
	private Paint pincel_linea;
	
	palabra(Resources res, Canvas lienzo, Monigote munyeco)
	{
		palabras = res.getStringArray(R.array.palabras);
		this.lienzo = lienzo;
		this.munyeco = munyeco;
		inicializa_pincel_linea();
	}
	
	private void inicializa_pincel_linea()
	{
		pincel_linea = new Paint();
		pincel_linea.setColor(Color.RED);
		pincel_linea.setTextSize(32);
	}
	
	public void getPalabra()
	{		
		palabra_en_curso = palabras[palabra_aleatoria()];
	}
	
	private int palabra_aleatoria()
	{
		return (int) Math.ceil(Math.random()*palabras.length);
	}
	
	private int tamanyo_palabra_en_curso()
	{
		return palabra_en_curso.length();
	}
	
	public void pinta_palabra()
	{
		
				
		int i = 1;
		
		posicion_inicio =  munyeco.getdatosmonigote().getPdinfder();
		
		for(i=1;i<=tamanyo_palabra_en_curso();i++)
		{
			
			lienzo.drawLine(posicion_inicio,
							munyeco.getdatosmonigote().getPdinf() + espacio_abajo,
							posicion_inicio + tamanyo_linea, 
							munyeco.getdatosmonigote().getPdinf() + espacio_abajo, 
							pincel_linea);
			
			posicion_inicio = posicion_inicio + tamanyo_linea + espacio_entre;
		}
	}

	
	public String getPalabra_en_curso() {
		return palabra_en_curso;
	}
	
	
	public void pinta_letra()
	{
		
		// método que "pinta" todas las ocurrencias de una letra
		
		int inicio=0;
		int i = 0;
		boolean letra_pintada = false;
		String letra_actual;
			
		
		posicion_inicio =  munyeco.getdatosmonigote().getPdinfder();
					
		for (i=0;i<getLetras_acertadas().length();i++)
		{
			
			letra_actual = letra_de_acertadas(i);
			letra_pintada = false;
			inicio = 0;
			
			while(!letra_pintada)
			{
				inicio = getPalabra_en_curso().indexOf(letra_actual, inicio);
				if(inicio == -1)
				{
					letra_pintada = true;
				}
				else
				{			
					lienzo.drawText(letra_actual, 
						posicion_inicio + ((tamanyo_linea + espacio_entre) * inicio),
						munyeco.getdatosmonigote().getPdinf() + espacio_abajo, 
						pincel_linea);
					
					inicio++;
				}
			}
		}
		
			
	}

	public void setLetras_acertadas(String letrasAcertadas) {
		letras_acertadas = letrasAcertadas;
	}

	public String getLetras_acertadas() {
		return letras_acertadas;
	}
	
	public String getLetras_falladas() {
		return letras_falladas;
	}

	public void setLetras_falladas(String letrasFalladas) {
		letras_falladas = letrasFalladas;
	}
	
	private String letra_de_acertadas(int pos)
	{
		return getLetras_acertadas().substring(pos,pos+1);
	}
	


}
