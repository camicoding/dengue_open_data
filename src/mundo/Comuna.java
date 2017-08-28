package mundo;

import java.util.ArrayList;

public class Comuna 
{
	// -----------------------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------------------
	
	public final static int CANT_GRUPOS_EDAD = 17;
	public final static int CANT_COMUNAS = 22;
	public final static int MUJER = 0;
	public final static int HOMBRE = 1;
	
	// -----------------------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------------------
	
	/**
	 * Es el numero de la comuna
	 */
	private int numero;
	
	/**
	 * Es la cantidad de habitantes de la comuna
	 */
	private int cantidadHabitantes;
	
	/**
	 * Indica la cantidad de casos de dengue ocurridos en la comuna, casos totales
	 */
	private int cantidadCasosTotales;
	
	/**
	 * Es el arreglo que guarda las probabilidades del ocurrencia para un grupo de edad.
	 * Dependiendo de la ubicacion asi sera el grupo de edad EJEMPLO la primera posicion 
	 * los que se encuentran entre 0-5 años.
	 */
	private int[] cRHombres;
	
	/**
	 * Es el arreglo que guarda las probabilidades del ocurrencia para un grupo de edad.
	 * Dependiendo de la ubicacion asi sera el grupo de edad EJEMPLO la primera posicion 
	 * los que se encuentran entre 0-5 años.
	 */
	private int[] cRMujeres;
	
	/**
	 * Es el arreglo que guarda la cantidad de habitantes para un grupo de edad.
	 */
	private int[] cHHombres;
	
	/**
	 * Es el arreglo que guarda la cantidad de habitantes para un grupo de edad.
	 */
	private int[] cHMujeres;
	
	/**
	 * Son los barrios asociados a la comuna
	 */
	private ArrayList<String> barrios;
	
	// -----------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------

	/**
	 * 
	 * @param numero
	 * @param cantHabitan
	 * @param cRHombres
	 * @param cRMujeres
	 * @param cHHombres
	 * @param cHMujeres
	 * @param barrios
	 */
	public Comuna(int numero, int[] cRHombres, int[] cRMujeres, 
			int[] cHHombres, int[] cHMujeres,ArrayList<String> barrios) 
	{
		this.numero = numero;
		//this.cantidadHabitantes = cantHabitan;
		this.cRHombres = cRHombres;
		this.cRMujeres = cRMujeres;
		this.cHHombres = cHHombres;
		this.cHMujeres = cHMujeres;
		this.barrios = barrios;
		
		this.cantidadHabitantes = cantidadHabGenero(HOMBRE) + cantidadHabGenero(MUJER);
		this.cantidadCasosTotales = cantidadCasGenero(HOMBRE)+ cantidadCasGenero(MUJER);
		// Falata agregar los casos totales
	}
	
	// -----------------------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------------------

	/**
	 * Permite buscar un barrio en la comuna dado su nombre
	 */
	public boolean buscarBarrio(String barrio)
	{
		return barrios.contains(barrio);
	}
	
	/**
	 * Te entrega la probabilidad de tener dengue en la comuna y ser de un genero
	 * determinado
	 * @param genero Es el genero del paciente, 0 Mujer 1 Hombre
	 * @return respuesta Es la probabilidad de tener dengue en la comuna y ser del genero
	 * indicado
	 */
	public double calcularProbabilidadGenero(int genero)
	{
		int contadorCas = 0;
		int contadorHab = 0;
		double respuesta = 0.0;
		
		switch(genero)
		{
			case MUJER:
			{
				// Se supone que cRMujeres y cHMujeres son iguales por la cantidad
				// de grupo de edades
				for(int i = 0; i < cRMujeres.length; i++)
				{
					contadorCas += cRMujeres[i];
					contadorHab += cHMujeres[i];
				}
				
				respuesta = contadorCas/contadorHab;
				break;
			}
			
			case HOMBRE:
			{
				// Se supone que cRHombre y cHHombre son iguales por la cantidad
				// de grupo de edades
				for(int i = 0; i < cRHombres.length; i++)
				{
					contadorCas += cRHombres[i];
					contadorHab += cHHombres[i];
				}
				
				respuesta = contadorCas/contadorHab;
				break;
			}

		}
		
		return respuesta;
	}
	
	/**
	 * Entrega la probabilidad de tener dengue dependiendo del genero del paciente
	 * y el grupo de edad al que pertenece
	 * @param genero Es el genero del paciente, 0 Mujer 1 Hombre
	 * @param gEdad Es el grupo de edad al que pertenece el paciente
	 * @return respuesta Es la probabilidad
	 */
	public double calcularProbabilidadGeneroEdad(int genero , int gEdad)
	{
		double respuesta = 0.0;
		
		switch (genero) 
		{
			case MUJER:
			{
				respuesta = cRMujeres[gEdad]/cHMujeres[gEdad];
				break;
			}
			
			case HOMBRE:
			{
				respuesta = cRHombres[gEdad]/cHHombres[gEdad];
				break;
			}

		}
		return respuesta;
	}
	
	/**
	 * Entrega la cantidad total de casos de un genero, registrados en la comuna
	 * @param genero Es el genero que se desea averiguar
	 * @return respuesta Es la cantidad total de casos registrados en la comuna por ese
	 * genero
	 */
	public int cantidadCasGenero(int genero)
	{
		int respuesta = 0;
		
		switch (genero)
		{
			case MUJER:
			{
				for(int i = 0; i < cRMujeres.length; i++)
				{
					respuesta += cRMujeres[i];
				}
				break;
			}
	
			case HOMBRE:
			{
				for(int i = 0; i < cRHombres.length; i++)
				{
					respuesta += cRHombres[i];
				}
				break;
			}
		}
		
		return respuesta;
	}
	
	/**
	 * Entrega la cantidad de habitantes en la comuna que poseen el genero pasado por
	 * parametro
	 * @param genero Es el genero que hace el filtro de los datos
	 * @return respuesta Es la cantidad de habitantes de un genero determinado en la 
	 * comuna
	 */
	public int cantidadHabGenero(int genero)
	{
		int respuesta = 0;
		
		switch (genero)
		{
			case MUJER:
			{
				for(int i = 0; i < cHMujeres.length; i++)
				{
					respuesta += cHMujeres[i];
				}
				break;
			}
	
			case HOMBRE:
			{
				for(int i = 0; i < cHHombres.length; i++)
				{
					respuesta += cHHombres[i];
				}
				break;
			}
		}
		
		return respuesta;
	}
	
	/**
	 * Entrega la cantidad de casos registrados con un genero determinado y un grupo de
	 * edad tambien determinado.
	 * @param genero Es el genero a filtrar
	 * @param gEdad Es el grupo de edad
	 * @return
	 */
	public int cantidadCasGeneroEdad(int genero, int gEdad)
	{
		int respuesta = 0;
		
		switch (genero) 
		{
			case MUJER:
			{
				respuesta = cRMujeres[gEdad];
				break;
			}
			
			case HOMBRE:
			{
				respuesta = cRHombres[gEdad];
				break;
			}

		}
		return respuesta;
	}
	
	/**
	 * Entrega la cantidad de habitantes filtrando por genero y grupo de edad
	 * @param genero
	 * @param gEdad
	 * @return
	 */
	public int cantidadHabGeneroEdad(int genero, int gEdad)
	{
		int respuesta = 0;
		
		switch (genero) 
		{
			case MUJER:
			{
				respuesta = cHMujeres[gEdad];
				break;
			}
			
			case HOMBRE:
			{
				respuesta = cHHombres[gEdad];
				break;
			}

		}
		return respuesta;
	}

	// -----------------------------------------------------------------------------
	// Gets and Sets
	// -----------------------------------------------------------------------------
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(int cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public int getCantidadCasosTotales() {
		return cantidadCasosTotales;
	}

	public void setCantidadCasosTotales(int cantidadCasosTotales) {
		this.cantidadCasosTotales = cantidadCasosTotales;
	}

	public int[] getcRHombres() {
		return cRHombres;
	}

	public void setcRHombres(int[] cRHombres) {
		this.cRHombres = cRHombres;
	}

	public int[] getcRMujeres() {
		return cRMujeres;
	}

	public void setcRMujeres(int[] cRMujeres) {
		this.cRMujeres = cRMujeres;
	}

	public int[] getcHHombres() {
		return cHHombres;
	}

	public void setcHHombres(int[] cHHombres) {
		this.cHHombres = cHHombres;
	}

	public int[] getcHMujeres() {
		return cHMujeres;
	}

	public void setcHMujeres(int[] cHMujeres) {
		this.cHMujeres = cHMujeres;
	}

	public ArrayList<String> getBarrios() {
		return barrios;
	}

	public void setBarrios(ArrayList<String> barrios) {
		this.barrios = barrios;
	}
	
	public String toString(){
		String s1 = "Comuna: "+numero+" Casos: "+cantidadCasosTotales+" Gente: "+cantidadHabitantes;
		s1+=" cHHombres: ";
		for (int i = 0; i < cHHombres.length; i++)
			s1+=cHHombres[i]+"|";
		s1+=" cHMujeres: ";
		for (int i = 0; i < cHMujeres.length; i++)
			s1+=cHMujeres[i]+"|";
		s1+=" cRHombres: ";
		for (int i = 0; i < cRHombres.length; i++)
			s1+=cRHombres[i]+"|";
		s1+=" cRMujeres: ";
		for (int i = 0; i < cRMujeres.length; i++)
			s1+=cRMujeres[i]+"|";
		
		return s1;
	}
	
}
