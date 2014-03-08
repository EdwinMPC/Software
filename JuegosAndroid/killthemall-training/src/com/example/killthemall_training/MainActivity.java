package com.example.killthemall_training;



//import com.example.matazombies.GameView;



import android.R.id;
import android.app.Activity;
import android.os.Bundle;
// import android.content.DialogInterface;
import android.content.Intent;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    
		TextView zombie = (TextView)findViewById(R.id.zombie);
        zombie.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				iniciaMatador();
			}
		});
		
        TextView ahorcado = (TextView)findViewById(R.id.ahorcado);
        ahorcado.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				inicia();
			}
		});
        
        
        TextView salir = (TextView)findViewById(R.id.salir);
        salir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);
        MenuInflater preparamenu = getMenuInflater();
        preparamenu.inflate(R.menu.main, menu);
        return true;
    }
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item){
	    	switch (item.getItemId()) {
	        case R.id.config:
	        startActivity(new Intent(this, Configuracion.class));
	        return true;
	        }
	        return false;
	    }
	 
	 private void iniciaMatador()
	    {	
		 setContentView(new GameView(this));
	    }
	 
	 private void inicia()
	    {
			startActivity(new Intent(this, Juego.class));
			
	    }

	
		
	

}
