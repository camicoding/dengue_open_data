package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ConexionApp {
	
	private HttpConnection hp;
	public String answer;
	
	public ConexionApp(){
		// hp = new HttpConnection();
	}
	
	public String infoComunas() {
		try {
			return new HttpConnection().execute("http://192.168.160.33:9000/Application/multiplicarPorCien").get() ;
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		} 
		return null;
	}
	
	public boolean loginCorrecto()  {
		try {
			new HttpConnection().execute("http://192.168.160.33:9000/Application/multiplicarPorCien").get() ;
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		} 
		return false;
	}
	
	public boolean registrarUsuario(){
		try {
			new HttpConnection().execute("http://192.168.160.33:9000/Application/multiplicarPorCien").get() ;
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		} 
		return false;
	}
	
	public boolean registrarCaso(){
		try {
			new HttpConnection().execute("http://192.168.160.33:9000/Application/multiplicarPorCien").get() ;
		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		} 
		return false;
	}

	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";     String result = "";
        
        while((line = bufferedReader.readLine()) != null)
            result += line;
        
        inputStream.close();
        return result;
    }
	
	public String doGet(String url){
		InputStream inputStream = null;
		String result = null;
		try {
			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();
			
			// convert inputstream to string
			if(inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Mala Conexion";
			
			//Log.d("Resultttt", result);
			
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}
		return result;
	}
	
	private class HttpConnection extends AsyncTask<String, Void, String> {        
		@Override
        protected String doInBackground(String... urls) {
            return doGet(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	//Toast.makeText(getBaseContext(), "Recibido!", Toast.LENGTH_LONG).show();
        	//view1.setText(result);
       }        
    }
}
