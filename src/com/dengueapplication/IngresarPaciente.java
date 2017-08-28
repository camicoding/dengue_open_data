package com.dengueapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class IngresarPaciente extends Activity {

    private static final String[] BARRIOS = new String[] {
        "Belgium", "France", "Italy", "Germany", "Spain"
    };
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingresar_paciente);
		
		// Spinner Meses o Años
		Spinner spinnerMesesAno = (Spinner) findViewById(R.id.spinnerEdad);
		String[] valores = new String[2];
		valores[0] = "Meses";
		valores[1] = "Años";
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerMesesAno.setAdapter(adaptador);
		
		// Spinner Genero
		Spinner spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
		String[] valores2 = new String[2];
		valores2[0] = "Masculino";
		valores2[1] = "Femenino";
		
		ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores2);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerGenero.setAdapter(adaptador2);
		
		// Spinner IPS
		Spinner spinnerIPS = (Spinner) findViewById(R.id.spinnerIPS);
		String[] valores3 = new String[3];
		valores3[0] = "Valle del Lili";
		valores3[1] = "Comfandi";
		valores3[2] = "Sura";
		
		ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores3);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerIPS.setAdapter(adaptador3);
		
		// Autocompletar barrio
		

		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,BARRIOS);
		AutoCompleteTextView txtAutocomplete = (AutoCompleteTextView) findViewById(R.id.txtDireccion);
		txtAutocomplete.setAdapter(adapter);
		
		// Accion del Boton
		
		Button botonCalcular = (Button) findViewById(R.id.buttonIngresarPaciente);
		botonCalcular.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent about = new Intent(IngresarPaciente.this, CalcularProbabilidad.class);
				startActivity(about);
			}
		});

	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ingresar_paciente, menu);
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
