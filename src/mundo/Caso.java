package mundo;

import java.util.Calendar;

public class Caso 
{
// ---------------------------------------------------------------------------------------------
// Constantes
// ---------------------------------------------------------------------------------------------

	public final static int MASCULINO = 0;
	public final static int FEMENINO = 1;
	
// --------------------------------------------------------------------------------------------
// Atributos
// --------------------------------------------------------------------------------------------
	
	/**
	 * id, es el registro medico que posee este +  el numero del caso
	 */
	private String id;
	
	/**
	 * FechaRegistro, es la fecha en la que se realiza el reporte medico
	 */
	private Calendar fechaRegistro;
	
	/**
	 * edad, es la edad del paciente
	 */
	private int edad;
	
	/**
	 * direccion, es la direccion del paciente
	 */
	// AUN NO SE HA ESPECIFICADO EL FORMATO
	private int comuna;
	
	/**
	 * genero, es una variable que indica masculino o femenino
	 */
	private int genero;
	
	/**
	 * IPS, es la ips prestadora de servicio
	 */
	// NO TENGO AUN DEFINIDO COMO SE DEFINEN LAS IPS
	private int IPS;
	
	/**
	 * probabilidad por ciudad dengue 
	 */
	private double probabilidadPorCiudad;
	
	/**
	 * probabilidad de dengue por ciudad y por genero
	 */
	private double probabilidadPorCiudadGenero;
	
	/**
	 * probabilidad por ciudad dengue grave
	 */
	private double probabilidadPorCiudadGeneroEdad;
	
	/**
	 * probabilidad por barrio dengue sencillo
	 */
	private double probabilidadPorComuna;
	
	private double probabilidadPorComunaGenero;
	
	private double probabilidadPorComunaGeneroEdad;
	
// --------------------------------------------------------------------------------------------
// Constructor
// --------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param id
	 * @param fechaRegistro
	 * @param edad
	 * @param comuna
	 * @param genero
	 * @param ips
	 * @param pCiudad
	 * @param pCiudadGenero
	 * @param pCiudadGeneroEdad
	 * @param pComuna
	 * @param pComunaGenero
	 * @param pComunaGeneroEdad
	 */

	public Caso(String id, Calendar fechaRegistro, int edad, int comuna, int genero, int ips
			, double pCiudad, double pCiudadGenero, double pCiudadGeneroEdad, double pComuna, double pComunaGenero, double pComunaGeneroEdad) 
	{
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		this.edad = edad;
		this.comuna = comuna;
		this.genero = genero;
		this.IPS = ips;
		this.probabilidadPorCiudad = pCiudad;
		this.probabilidadPorCiudadGenero = pCiudadGenero;
		this.probabilidadPorCiudadGeneroEdad = pCiudadGeneroEdad;
		this.probabilidadPorComuna = pComuna;
		this.probabilidadPorComunaGenero = pComunaGenero;
		this.probabilidadPorComunaGeneroEdad = pComunaGeneroEdad;
	}

// --------------------------------------------------------------------------------------------
// Gets and Sets
// --------------------------------------------------------------------------------------------

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Calendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getIPS() {
		return IPS;
	}

	public void setIPS(int iPS) {
		IPS = iPS;
	}

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public double getProbabilidadPorCiudad() {
		return probabilidadPorCiudad;
	}

	public void setProbabilidadPorCiudad(double probabilidadPorCiudad) {
		this.probabilidadPorCiudad = probabilidadPorCiudad;
	}

	public double getProbabilidadPorCiudadGenero() {
		return probabilidadPorCiudadGenero;
	}

	public void setProbabilidadPorCiudadGenero(double probabilidadPorCiudadGenero) {
		this.probabilidadPorCiudadGenero = probabilidadPorCiudadGenero;
	}

	public double getProbabilidadPorCiudadGeneroEdad() {
		return probabilidadPorCiudadGeneroEdad;
	}

	public void setProbabilidadPorCiudadGeneroEdad(
			double probabilidadPorCiudadGeneroEdad) {
		this.probabilidadPorCiudadGeneroEdad = probabilidadPorCiudadGeneroEdad;
	}

	public double getProbabilidadPorComuna() {
		return probabilidadPorComuna;
	}

	public void setProbabilidadPorComuna(double probabilidadPorComuna) {
		this.probabilidadPorComuna = probabilidadPorComuna;
	}

	public double getProbabilidadPorComunaGenero() {
		return probabilidadPorComunaGenero;
	}

	public void setProbabilidadPorComunaGenero(double probabilidadPorComunaGenero) {
		this.probabilidadPorComunaGenero = probabilidadPorComunaGenero;
	}

	public double getProbabilidadPorComunaGeneroEdad() {
		return probabilidadPorComunaGeneroEdad;
	}

	public void setProbabilidadPorComunaGeneroEdad(
			double probabilidadPorComunaGeneroEdad) {
		this.probabilidadPorComunaGeneroEdad = probabilidadPorComunaGeneroEdad;
	}

	

	
}

