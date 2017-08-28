package mundo;

import java.util.ArrayList;
import java.util.Calendar;

public class Usuario 
{
	// -----------------------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------------------

	/**
	 * Es el registro medico, se maneja como identificador
	 */
	private String registroMedico;
	
	/**
	 * Es la clave con la que ingresa el medico
	 */
	private String clave;
	
	/**
	 * Es el nombre de medico
	 */
	private String nombre;
	
	/**
	 * Es el apellido del medico
	 */
	private String apellido;
	
	/**
	 * Es el año en el que se graduo, esto se hace para tener hacer estadisticas
	 * si las personas despues de que determinado tiempo de graduados dejan de diagnosticar
	 * dengue
	 */
	private int anioGrado;
	
	/**
	 * Es el tipo de medico, que puede ser especialista o general
	 */
	private String tipoMedico;
	
	/**
	 * Indica si el medico a recibido alguna capacitacion
	 */
	private boolean capacitacion;
	
	/**
	 * Indica cual ha sido la fecha del ultimo ingreso
	 */
	private Calendar fechaUltimoIngreso;
	
	/**
	 * Muestra cuantos pacientes a ingresado a la aplicacion
	 */
	private int numeroDeIngresos;
	
	/**
	 * Son los casos asociados al medico
	 */
	private ArrayList<Caso> casos;
	
	/**
	 * Contador de los casos
	 */
	private int contador;
	
	
	// -----------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------
	
	/**
	 * 
	 * @param registro
	 * @param clave
	 * @param nombre
	 * @param apellido
	 * @param anioGrado
	 * @param tipoMedico
	 * @param capacitacion
	 * @param fechaIngreso
	 */
	
	public Usuario(String registro, String clave, String nombre, String apellido, 
			int anioGrado, String tipoMedico, boolean capacitacion, Calendar fechaIngreso) 
	{
		this.registroMedico = registro;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.anioGrado = anioGrado;
		this.tipoMedico = tipoMedico;
		this.capacitacion = capacitacion;
		this.fechaUltimoIngreso = fechaIngreso;
		this.casos = new ArrayList<Caso>();
		this.contador = 0;
	}
	
	// -----------------------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------------------

	/**
	 * Permite agregar un caso registrado por el medico
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
	public void agregarCaso(Calendar fechaRegistro, int edad, int comuna, int genero, int ips
			, double pCiudad, double pCiudadGenero, double pCiudadGeneroEdad, double pComuna, double pComunaGenero, double pComunaGeneroEdad)
	{
		String id = registroMedico +"-" + contador;
		Caso nuevo = new Caso(id,fechaRegistro, edad, comuna, genero, ips, pCiudad, pCiudadGenero, pCiudadGeneroEdad, pComuna, pComunaGenero, pComunaGeneroEdad);
		casos.add(nuevo);
		contador++;
		
		// Falta cambiar la fecha del ultimo ingreso
	}

	// -----------------------------------------------------------------------------
	// Gets and Sets
	// -----------------------------------------------------------------------------

	public String getRegistroMedico() {
		return registroMedico;
	}

	public void setRegistroMedico(String registroMedico) {
		this.registroMedico = registroMedico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getAnioGrado() {
		return anioGrado;
	}

	public void setAnioGrado(int anioGrado) {
		this.anioGrado = anioGrado;
	}

	public String getTipoMedico() {
		return tipoMedico;
	}

	public void setTipoMedico(String tipoMedico) {
		this.tipoMedico = tipoMedico;
	}

	public boolean isCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(boolean capacitacion) {
		this.capacitacion = capacitacion;
	}

	public Calendar getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}

	public void setFechaUltimoIngreso(Calendar fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}

	public int getNumeroDeIngresos() {
		return numeroDeIngresos;
	}

	public void setNumeroDeIngresos(int numeroDeIngresos) {
		this.numeroDeIngresos = numeroDeIngresos;
	}

	public ArrayList<Caso> getCasos() {
		return casos;
	}

	public void setCasos(ArrayList<Caso> casos) {
		this.casos = casos;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	
	
	
	
	

}
