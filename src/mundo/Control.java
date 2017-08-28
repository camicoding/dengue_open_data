package mundo;

import java.util.ArrayList;
import java.util.Calendar;

import android.util.Log;

public class Control 
{
	// -----------------------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------------------

	/**
	 * Este valor lleva un contador de la cantidad de usuarios
	 */
	private int numeroUsuarios;
	
	/**
	 * Este valor lleva un contador de la cantidad de casos registrados por la app
	 */
	private int numeroCasos;

	/**
	 * Son la cantidad de usuarios que tiene asociado control
	 */
	private ArrayList<Usuario> usuarios;
	
	/**
	 * Son las comunas asociadas a la aplicacion
	 */
	private Comuna[] comunas;
	
	/**
	 * Es la relacion con la clase que permite manejar la conexion con la Aplicacion Web
	 */
	public ConexionApp conexion;
	
	// -----------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------

	public Control() throws Exception 
	{
		conexion = new ConexionApp();
		comunas = new Comuna[Comuna.CANT_COMUNAS];
		agregarComunas();
		numeroUsuarios = 0;
		numeroCasos = 0;
		usuarios = new ArrayList<Usuario>();
	}
	
	// -----------------------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------------------
	
	/**
	 * Agrega un nuevo medico
	 * @param registro
	 * @param clave
	 * @param nombre
	 * @param apellido
	 * @param anioGrado
	 * @param tipoMedico
	 * @param capacitacion
	 */
	public void agregarUsuario(String registro, String clave, String nombre, String apellido, 
			int anioGrado, String tipoMedico, boolean capacitacion)
	{
		Usuario nuevo = new Usuario(registro, clave, nombre, apellido, anioGrado, tipoMedico, 
				capacitacion, Calendar.getInstance());
		
		usuarios.add(nuevo);
	}
	
	public void agregarCaso(String id,int edad, int comuna, int genero, int ips)
	{
		int gEdad = grupoEdad(edad);
		
		double pCiudad = calcularProbCiudadTotal();
		double pCiudadGenero = calcularProbCiudadGenero(genero);
		double pCiudadGeneroEdad = calcularProbCiudadGeneroEdad(genero, gEdad);
		double pComuna = calcularProbComunaTotal(comuna);
		double pComunaGenero = calcularProbComunaGenero(comuna, genero);
		double pComunaGeneroEdad = calcularProbComunaGeneroEdad(comuna, genero, gEdad);
		
		Usuario usuario = buscarUsuario(id);
		
		usuario.agregarCaso(Calendar.getInstance(), gEdad, comuna, genero, ips, pCiudad,
				pCiudadGenero, pCiudadGeneroEdad, pComuna, pComunaGenero, pComunaGeneroEdad);
	}
	
	/**
	 * Entrega la probabilidad de tener dengue en la comuna
	 * @return respuesta Es la probabilidad de tener dengue en la ciudad
	 */
	public double calcularProbComunaTotal(int comuna)
	{
		double respuesta = 0.0;
		int cantHab = 0;
		int cantCas = 0;		
		
		cantHab = comunas[comuna].getCantidadHabitantes();
		cantCas = comunas[comuna].getCantidadCasosTotales();
	
		respuesta = cantCas/cantHab;
		
		return respuesta;
		
	}
	
	/**
	 * Entrega la probabilidad de tener dengue en la comuna y pertenecer a un genero determinado
	 * @param genero Es el genero del paciente
	 * @return respuesta Entrega la probabilidad
	 */
	public double calcularProbComunaGenero(int comuna,int genero)
	{
		double respuesta = 0.0;
		int cantHabGen = 0;
		int cantCasGen = 0;
		
		cantHabGen = comunas[comuna].cantidadHabGenero(genero);
		cantCasGen = comunas[comuna].cantidadCasGenero(genero);
		
		respuesta = cantCasGen / cantHabGen;
		
		return respuesta;
	}
	
	/**
	 * Calcula la probabilidad de tener dengue en la comuna y pertenecer a un genero y grupo de edad
	 * @param genero Es el genero del paciente
	 * @param gEdad Es el grupo de edad al que pertenece el paciente
	 * @return respuesta Entrega la probabilidad 
	 */
	public double calcularProbComunaGeneroEdad(int comuna,int genero, int gEdad)
	{
		double respuesta = 0.0;
		int cantHabGenEd = 0;
		int cantCasGenEd = 0;
		
		cantHabGenEd += comunas[comuna].cantidadHabGeneroEdad(genero, gEdad);
		cantCasGenEd += comunas[comuna].cantidadCasGeneroEdad(genero, gEdad);
		
		respuesta = cantCasGenEd / cantHabGenEd;
		
		return respuesta;
	}
	
	
	/**
	 * Entrega la probabilidad de tener dengue en la ciudad
	 * @return respuesta Es la probabilidad de tener dengue en la ciudad
	 */
	public double calcularProbCiudadTotal()
	{
		double respuesta = 0.0;
		int cantHab = 0;
		int cantCas = 0;
		
		for(int i = 0; i < comunas.length ; i++)
		{
			cantHab += comunas[i].getCantidadHabitantes();
			cantCas += comunas[i].getCantidadCasosTotales();
		}
		
		respuesta = cantCas/cantHab;
		
		return respuesta;
		
	}
	
	/**
	 * Entrega la probabilidad de tener dengue en la ciudad y pertenecer a un genero determinado
	 * @param genero Es el genero del paciente
	 * @return respuesta Entrega la probabilidad
	 */
	public double calcularProbCiudadGenero(int genero)
	{
		double respuesta = 0.0;
		int cantHabGen = 0;
		int cantCasGen = 0;
		
		for(int i = 0; i < comunas.length ; i++)
		{
			cantHabGen += comunas[i].cantidadHabGenero(genero);
			cantCasGen += comunas[i].cantidadCasGenero(genero);
		}
		
		respuesta = cantCasGen / cantHabGen;
		
		return respuesta;
	}
	
	/**
	 * Calcula la probabilidad de tener dengue en la ciudad y pertenecer a un genero y grupo de edad
	 * @param genero Es el genero del paciente
	 * @param gEdad Es el grupo de edad al que pertenece el paciente
	 * @return respuesta Entrega la probabilidad 
	 */
	public double calcularProbCiudadGeneroEdad(int genero, int gEdad)
	{
		double respuesta = 0.0;
		int cantHabGenEd = 0;
		int cantCasGenEd = 0;
		
		for(int i = 0; i < comunas.length ; i++)
		{
			cantHabGenEd += comunas[i].cantidadHabGeneroEdad(genero, gEdad);
			cantCasGenEd += comunas[i].cantidadCasGeneroEdad(genero, gEdad);
		}
		
		respuesta = cantCasGenEd / cantHabGenEd;
		
		return respuesta;
	}

	
	
	/**
	 * Entrega el grupo de edad al que pertenece el paciente
	 * @param edad Es la edad normal del paciente
	 * @return respuesta Es el grupo de edad que va desde 0-16
	 */
	public int grupoEdad(int edad)
	{
		int respuesta = 0;
		boolean encontro = false;
		int contador = 0;
		
		for(int i = 5; i < Comuna.CANT_GRUPOS_EDAD && !encontro; i+=5)
		{
			if(edad < i)
			{
				respuesta = contador;
				encontro = true;
			}
			
			else
			{
				contador++;
			}
		}
		
		if (encontro == false)
		{
			respuesta = Comuna.CANT_GRUPOS_EDAD - 1;
		}
		
		return respuesta;
	}
	
	/**
	 * Busca la comuna a la que pertence el barrio pasado por parametro
	 * @param barrio Es el barrio a buscar
	 * @return respuesta Entrega la comuna o entrega -1 si no la encuentra
	 */
	public int buscarBarrio(String barrio)
	{
		int respuesta = 0;
		boolean encontro = false;
		
		for(int i = 0; i < comunas.length && !encontro; i++)
		{
			if(comunas[i].buscarBarrio(barrio))
			{
				respuesta = i;
				encontro = true;
			}
			
		}
		
		if(encontro == false)
		{
			respuesta = -1;
		}
		
		return respuesta;
	}
	
	/**
	 * Entrega el usuario al que le pertenece el id pasado por parametro
	 * @param id Es el id del usuario a buscar
	 * @return respuesta Es el usuario encontrado, se supone que tiene que encontrarlo porque sera
	 * un atributo manejado en el login
	 */
	public Usuario buscarUsuario(String id)
	{
		Usuario respuesta = null;
		boolean encontro = false;
		
		for(int i = 0; i < usuarios.size()&&!encontro;i++)
		{
			Usuario actual = usuarios.get(i);
			
			if(actual.getRegistroMedico().equals(id))
			{
				respuesta = actual;
				encontro = true;
			}
		}
		
		return respuesta;
	}
	
	//---------------------------------------------------------------------------------------------
	// CONEXION CON LA BASE DE DATOS
	//---------------------------------------------------------------------------------------------
	
	public void agregarComunas() throws Exception
	{
		//-----------------------------------------------------------
		String result = conexion.infoComunas();
		String[] listaComunas = result.split(" && ");
		
		for(int x = 0; x<listaComunas.length; x++){
			String[] s1 = listaComunas[x].split(" ");
			int numero = Integer.parseInt(s1[0]);	int	habitantes = Integer.parseInt(s1[1]);
			int cantidadCasosTotales = Integer.parseInt(s1[2]);
			
			String[] s2 = s1[3].split("\\|"); int[] cRHombres = new int[s2.length];
			for(int x1 = 0; x1 < s2.length; x1++)
				cRHombres[x1] = Integer.parseInt(s2[x1]);
			
			String[] s3 = s1[4].split("\\|"); int[] cRMujeres = new int[s3.length];
			for(int x1 = 0; x1 < s3.length; x1++)
				cRMujeres[x1] = Integer.parseInt(s3[x1]);
			
			String[] s4 = s1[5].split("\\|"); int[] cHHombres = new int[s4.length];
			for(int x1 = 0; x1 < s4.length; x1++)
				cHHombres[x1] = Integer.parseInt(s4[x1]);
			
			String[] s5 = s1[6].split("\\|"); int[] cHMujeres = new int[s5.length];
			for(int x1 = 0; x1 < s5.length; x1++)
				cHMujeres[x1] = Integer.parseInt(s5[x1]);
			
			ArrayList<String> b = new ArrayList<String>(); b.add("BarrioTest");
			Comuna c = new Comuna(numero, cRHombres, cRMujeres, cHHombres, cHMujeres, b);
			
			this.comunas[x] = c;
			Log.d("Comuna "+numero,comunas[x].toString());
		}
		//-----------------------------------------------------------
		
	}

	//---------------------------------------------------------------------------------------------
	// Gets and Sets
	//---------------------------------------------------------------------------------------------

	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}

	public int getNumeroCasos() {
		return numeroCasos;
	}

	public void setNumeroCasos(int numeroCasos) {
		this.numeroCasos = numeroCasos;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Comuna[] getComunas() {
		return comunas;
	}

	public void setComunas(Comuna[] comunas) {
		this.comunas = comunas;
	}
	
}
