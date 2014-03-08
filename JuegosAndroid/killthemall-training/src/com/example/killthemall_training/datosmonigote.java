package com.example.killthemall_training;

import android.graphics.Canvas;

public class datosmonigote {
	
	private Canvas canvas;
	
	private int estado = 0;
	private int transparencia = 80;
	private int radiocabeza, partescentrocabeza, centrox, centroy, partesradio;
	private int troncsupizq, troncsup, troncinfder, troncinf, anchotronc, altotronc;
	private int bisupizq, bisup, biinfder, biinf, anchobrapi, altobrapi;
	private int bdsupizq, bdsup, bdinfder, bdinf;
	private int anchopierna;
	private int pisupizq, pisup, piinfder, piinf;
	int pdsupizq, pdsup, pdinfder, pdinf;
	
	public int getPdsupizq() {
		return pdsupizq;
	}

	public int getPdsup() {
		return pdsup;
	}

	public int getPdinfder() {
		return pdinfder;
	}

	public int getPdinf() {
		return pdinf;
	}

	datosmonigote(Canvas canvas)
	{
		this.canvas = canvas;
		inicializa();
	}
	
	private void inicializa()
	{
		// datos cabeza
		partescentrocabeza=4;
		partesradio = 4;
		centrox = canvas.getWidth()/partescentrocabeza;
		centroy = centrox/2;
		radiocabeza = centrox/partesradio;
		
		//datos tronco
		anchotronc=5;
		altotronc=40;
		troncsupizq=centrox-anchotronc;
		troncsup= centroy+radiocabeza;
		troncinfder=troncsupizq+(anchotronc*2);
		troncinf=troncsup+altotronc;
		
		//datos brazos y piernas
		anchobrapi=anchotronc;
		altobrapi=altotronc;
		anchopierna=anchobrapi;
		
		
		//brazo derecho
		
		bdsupizq=troncsupizq - altobrapi;
		bdsup=troncsup;
		bdinfder=troncsupizq;
		bdinf=troncsup + anchobrapi;
		
		//brazo izquierdo
	
		bisupizq=centrox + anchotronc;
		bisup=troncsup;
		biinfder=bisupizq+altobrapi;
		biinf=troncsup+anchobrapi;
		
		// pierna izquierda
		
		
		pisupizq=this.troncinfder;
		pisup=this.troncinf;
		piinfder=this.biinfder-(this.anchobrapi/2);
		piinf=this.troncinf+this.altotronc;
		
		// pierna derecha
		
		pdsupizq= this.troncinfder-(this.anchotronc*2);
		pdsup= this.troncinf;
		pdinfder=this.bdsupizq + (this.anchobrapi/2);
		pdinf=this.troncinf+this.altotronc;
	}
	
	

	public Canvas getCanvas() {
		return canvas;
	}

	public int getEstado() {
		return estado;
	}

	public int getTransparencia() {
		return transparencia;
	}

	public int getRadiocabeza() {
		return radiocabeza;
	}

	public int getPartescentrocabeza() {
		return partescentrocabeza;
	}

	public int getCentrox() {
		return centrox;
	}

	public int getCentroy() {
		return centroy;
	}

	public int getPartesradio() {
		return partesradio;
	}

	public int getTroncsupizq() {
		return troncsupizq;
	}

	public int getTroncsup() {
		return troncsup;
	}

	public int getTroncinfder() {
		return troncinfder;
	}

	public int getTroncinf() {
		return troncinf;
	}

	public int getAnchotronc() {
		return anchotronc;
	}

	public int getAltotronc() {
		return altotronc;
	}

	public int getBisupizq() {
		return bisupizq;
	}

	public int getBisup() {
		return bisup;
	}

	public int getBiinfder() {
		return biinfder;
	}

	public int getBiinf() {
		return biinf;
	}

	public int getAnchobrapi() {
		return anchobrapi;
	}

	public int getAltobrapi() {
		return altobrapi;
	}

	public int getBdsupizq() {
		return bdsupizq;
	}

	public int getBdsup() {
		return bdsup;
	}

	public int getBdinfder() {
		return bdinfder;
	}

	public int getBdinf() {
		return bdinf;
	}

	public int getAnchopierna() {
		return anchopierna;
	}

	public int getPisupizq() {
		return pisupizq;
	}

	public int getPisup() {
		return pisup;
	}

	public int getPiinfder() {
		return piinfder;
	}

	public int getPiinf() {
		return piinf;
	}
}
