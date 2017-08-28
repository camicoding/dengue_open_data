package com.dengueapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


public class CalcularProbabilidad extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcular_probabilidad);
		
		
		final View estadCiudad = findViewById(R.id.view_estadisticas_ciudad);
		estadCiudad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	estadCiudad.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 estadCiudad.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
			    
				Intent about = new Intent(CalcularProbabilidad.this, EstadisticasCiudad.class);
				startActivity(about);
			}
		});
		
		final View estadComuna = findViewById(R.id.view_estadisticas_comunas);
		estadComuna.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	estadComuna.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 estadComuna.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
			    
				Intent about = new Intent(CalcularProbabilidad.this, EstadisticasComunas.class);
				startActivity(about);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calcular_probabilidad, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
