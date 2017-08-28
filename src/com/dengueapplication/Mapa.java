package com.dengueapplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Mapa extends FragmentActivity {

	private GoogleMap mapa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
		
		mapa = ((SupportMapFragment)getSupportFragmentManager()
				.findFragmentById(R.id.mapa)).getMap();
		
		
		LatLng cali = new LatLng(3.4205556, -76.52222219);
		CameraPosition camPos = new CameraPosition.Builder()
		        .target(cali)   //Centramos el mapa en Cali
		        .zoom(12)       
		        .build();
		 
		CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
		 
		mapa.animateCamera(camUpd3);
		
		try {
			dibujarPoligono();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa, menu);
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
	
	public void dibujarPoligono() throws IOException
	{
		int contadorGeneral = 0;
		
		while(contadorGeneral < 22)
		{	
			PolygonOptions rectangulo1 = new PolygonOptions();
		
			int prueba = getResources().getIdentifier("comuna_"+(contadorGeneral+1), 
					"raw", getPackageName());
		
			InputStream fraw = getResources().openRawResource(prueba);
			BufferedReader lector = new BufferedReader(new InputStreamReader(fraw));
		
			String linea = lector.readLine();
			String[] coordenadas = linea.split(",0 ");
			int contador = 0;
			while(contador < coordenadas.length)
			{
				String[] coordenada = coordenadas[contador].split(",");
			
				LatLng punto = new LatLng(Double.parseDouble(coordenada[1]),
						Double.parseDouble(coordenada[0]));
			
				rectangulo1.add(punto);
			
				contador++;
			}

		
			rectangulo1.strokeWidth(5);
			rectangulo1.strokeColor(Color.BLUE);
		
			mapa.addPolygon(rectangulo1);
			
			contadorGeneral++;
		}
	}
}
