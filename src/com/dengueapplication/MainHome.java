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

public class MainHome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_home);
		setTitle("Menu");
		
		final View ingresarPaciente = findViewById(R.id.layoutIngresarPaciente);
		ingresarPaciente.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	ingresarPaciente.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 ingresarPaciente.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
			    
				Intent about = new Intent(MainHome.this, IngresarPaciente.class);
				startActivity(about);
			}
		});
		
		final View mostrarMapa = findViewById(R.id.layoutMostrarMapa);
		mostrarMapa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	mostrarMapa.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 mostrarMapa.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
				Intent about = new Intent(MainHome.this, Mapa.class);
				startActivity(about);
			}
		});
		
		final View reportes = findViewById(R.id.layoutReportes);
		reportes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	reportes.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 reportes.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
			}
		});
		
		final View detallesUsuario = findViewById(R.id.layoutDetallesUsuario);
		detallesUsuario.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
	        	detallesUsuario.setBackgroundColor(Color.CYAN);
			    Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
					 	 detallesUsuario.setBackgroundColor(Color.TRANSPARENT);
			         } 
			    }, 100); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_home, menu);
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
