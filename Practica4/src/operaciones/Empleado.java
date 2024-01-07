package operaciones;

import java.util.ArrayList;

public class Empleado {
	//Declaraci�n de atributos
	private String nombre;
	public String apellidos;
	private final String dni; //El atributo dni ser� el que usaremos como clave para cada empleado (atributo �nico)
	private String direccion;
	private String email;
	private int telefono;
	private String fNacimiento;
	private Boolean estado; //Con este atributo sabremos si el empleado est� en activo en la empresa o no
	private ArrayList<Contrato> contratos; //En este array almacenaremos el listado de todos los contratos de cada trabajador
	private int contador; //Este contador
	private int diasVacaciones;
	
	public int PruebaVariable = 0; //fasd0iasdf0
	
	//Definici�n de constructores
	public Empleado(String dni) {
		this.dni = dni;
		this.contratos = new ArrayList<Contrato>(); //Creamos autom�ticamente la lista de los contratos del trabajador
		this.contador = 0; //Inicializamos el contador a 0
		this.setDiasVacaciones(28); //A�adimos 28 d�as de vacaciones al trabajador
	}
	
	public Empleado(String nombre, String apellidos, String dni, String direccion, String email, int telefono, String fNacimiento, Boolean estado) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fNacimiento = fNacimiento;
		this.estado = estado;
		this.contratos = new ArrayList<Contrato>(); //Creamos autom�ticamente la lista de los contratos del trabajador
		this.contador = 0; //Inicializamos el contador a 0
		this.setDiasVacaciones(28); //A�adimos 28 d�as de vacaciones al trabajador
		
		//Mostramos por pantalla un mensaje de verificación 
		System.out.println("El empleado con dni " + this.dni + " ha sido dado de alta con éxito.");
	}
	
	//Definici�n de getters y setters
	/*public String getNombre() {
		return nombre;
	}*/
	
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getfNacimiento() {
		return fNacimiento;
	}
	
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	
	public Boolean getEstado() {
		return estado;
	}
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public ArrayList<Contrato> getContratos() {
		return contratos;
	}
	
	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public int getContador() {
		return contador;
	}
	
	public void setContador(int contador) {
		this.contador = contador;
	}
	
	public String getDni() {
		return dni;
	}

	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}
	
}
