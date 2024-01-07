package operaciones;

import java.util.ArrayList;

public final class Empresa {
	//Declaración de atributos
	private static Empresa instancia = null; //Variable instancia
	private String nombre;
	private static final String cif = "POO15411473R"; //Definimos el CIF de la empresa de tipo "static final" ya que este ser� un valor el cual no cambiar� durante la vida de la empresa
	private String direccion;
	private ArrayList<Empleado> listaEmpleados; //Almacenar� un listado de todos los empleados que pertenecen a la empresa. Adem�s, se declara de tipo "protected" para que podamos interactuar con �l directamente desde la clase Principal
	int variablePrueba = 0;
	
	//Definición de constructores
	private Empresa() {} //Constructor privado y vac�o
	
	//Definición de getters y setters
  public String getNombre() {
    return nombre;
  }
	
	

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  

	public static String getCif() {
		return cif;
	}
	
	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> empleados) {
		this.listaEmpleados = empleados;
	}
	
  //Definición de métodos
  public static Empresa getInstancia() { //Se comprueba si la clase ha sido ya instanciada o no
    if(instancia == null) //No ha sido instanciada
      instancia = new Empresa(); //Se crea
		
    return instancia; //Ya ha sido instanciada, por tanto, se devuelve
  }
}
