package com.dengueapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;

public class Registro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		setTitle("Registro de Usuario");
		
		Button botonRegistro = (Button) findViewById(R.id.botonRegistrar);
		botonRegistro.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
		
		
		NumberPicker anoGraduacion = (NumberPicker) findViewById(R.id.ano);
		anoGraduacion.setMaxValue(2014);
		anoGraduacion.setMinValue(1950);
		
		botonRegistro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent about = new Intent(Registro.this, MainHome.class);
				startActivity(about);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resgistro, menu);
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
