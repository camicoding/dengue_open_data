package com.dengueapplication;

import mundo.ConexionApp;
import mundo.Control;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.*;

public class LoginUser extends Activity {

	private Control mundo;
	private ConexionApp conex;
	TextView view1,view2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_user);
		
		try{
		mundo = new Control();
		//String s = conex.infoComunas();
		//view1.setText("Tex: "+s);
		CheckedTextView registro = (CheckedTextView) findViewById(R.id.nuevo_registro);
		registro.setOnTouchListener(new OnTouchListener() 
		{
			
			@Override
			public boolean onTouch(View v, MotionEvent event) 
			{
				Intent about = new Intent(LoginUser.this, Registro.class);
				startActivity(about);
				return true;
			}
		});
		
		Button botonIngresar = (Button) findViewById(R.id.botonIngreso);
		botonIngresar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent about = new Intent(LoginUser.this, MainHome.class);
				startActivity(about);
			}
		});

		}catch(Exception e){
			Log.e("ERROR", e.getMessage()+"\n+++++"+e.getLocalizedMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_user, menu);
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
