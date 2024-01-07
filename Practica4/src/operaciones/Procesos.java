package operaciones;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	//Declaraci�n de atributos
	private Empresa miEmpresa;
	private Empleado miEmpleado;
	
	//Declaraci�n de constructores
	public Procesos() {		
		//Creamos una instancia a la clase Empresa y le asignamos los valores iniciales
		miEmpresa = Empresa.getInstancia();
		miEmpresa.setNombre("Guillermo Systems");
		miEmpresa.setDireccion("Calle Bet�nica, 10 (Sevilla)");
		miEmpresa.setListaEmpleados(new ArrayList<Empleado>()); //Creaci�n de la lista de empleados de la empresa
	}
	
	//Definici�n de getters
	public Empresa getEmpresa() {
		return this.miEmpresa;
	}
	
	//Declaraci�n de m�todos
	//M�todos de comprobaci�n de datos
	public boolean comprobarCadenaDni(String dni) {
		if(dni.length() != 9) {
			JOptionPane.showMessageDialog(null, "El formato para el DNI es 00000000A", "Error de formato" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean comprobarCadenaTlf(String telefono) {
		if(telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "El n�mero de tel�fono debe tener 9 d�gitos", "Error de formato" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean comprobarCadenaFecha(String fecha) {
		if(fecha.length() != 10) {
			JOptionPane.showMessageDialog(null, "El formato de fecha es dd/mm/aaaa", "Error de formato" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	//M�todos correspondientes al tratamiento de los empleados
	public void registrarEmpleado(Empleado empleado) {
		miEmpresa.getListaEmpleados().add(empleado);
	}

	public boolean comprobarDni(String dni) {
		for(Empleado e: miEmpresa.getListaEmpleados()) {
			if(e.getDni().equals(dni)) {
				JOptionPane.showMessageDialog(null, "Ya existe un empleado registrado con ese DNI", "Aviso" , JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public Empleado buscarEmpleado(String dni) {
		try {
			if(miEmpresa.getListaEmpleados().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No existen empleados registrados en el sistema", "Aviso" , JOptionPane.ERROR_MESSAGE);
				return null;
			}else {
				for(Empleado e: miEmpresa.getListaEmpleados()) {
					if(e.getDni().equals(dni)) {
						return e;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "No existe ning�n empleado con ese DNI", "Aviso" , JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error" , JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	
	public void eliminarEmpleado(Empleado empleado) {		
		try {
			if(empleado != null) {
				miEmpresa.getListaEmpleados().remove(empleado);
				JOptionPane.showMessageDialog(null, "Empleado eliminado con �xito", "Aviso" , JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error", "Error" , JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean cogerVacaciones(Empleado empleado) {
		if(empleado.getDiasVacaciones() < 7) {
			JOptionPane.showMessageDialog(null, "El empleado no tiene vacaciones disponibles", "Error" , JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			empleado.setDiasVacaciones(empleado.getDiasVacaciones()-7);
			return true;
		}
	}
	
	//M�todos correspondientes a la clase Contrato
	public void asignacionContrato(Empleado empleado, Contrato contrato) {
		empleado.getContratos().add(contrato);
	}
	
	public boolean comprobarDisponibilidadContrato(Empleado empleado, int semana) {
		for(Contrato c: empleado.getContratos()) {
			if(c.getSemana() == semana) {
				JOptionPane.showMessageDialog(null, "El empleado ya tiene un contrato asignado para dicha semana", "Error" , JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	//M�todos generales de impresi�n de objetos (Empleado, Empresa, Contrato)
	public String imprimirEmpleado(Empleado e) {
		return "Nombre y apellidos: "+ e.getNombre() + " " + e.getApellidos() + "\nDNI: " + e.getDni() + "\nFecha de nacimiento: " + e.getfNacimiento() + "\nDirecci�n: " + e.getDireccion() + "\nTel�fono: " + e.getTelefono() + "\nCorreo electr�nico: " + e.getEmail() +  "\nVacaciones disponibles: " + e.getDiasVacaciones() + "\nN�mero de contratos: " + e.getContratos().size() + "\n";
	}
	
	public String imprimirEmpresa() { //A trav�s de este m�todo vamos a imprimir la informaci�n de la empresa
		return "Datos de la empresa:\nNombre: " + miEmpresa.getNombre() + "\nDirecci�n: " + miEmpresa.getDireccion() + "\nCIF: " + miEmpresa.getCif() + "\nEmpleados en plantilla: " + miEmpresa.getListaEmpleados().size() + "\n";
	}
	
	public String imprimirContrato(Contrato c) {
		return "Tipo de contrato: " + c.getTipoContrato() + "\nFecha de inicio: " + c.getFechaInicio() + "\nFecha de fin: " + c.getFechaFin() + "\nD�as de trabajo: " + c.getDiasTrabajo() + "\nD�as de descando: " + c.getDiasDescanso();
	}
	
	//M�todos correspondientes a la impresi�n de los cuadrantes
	public boolean comprobarTrabajadores() {
		if(miEmpresa.getListaEmpleados().size()<5) {
			JOptionPane.showMessageDialog(null, "No existen empleados suficientes para realizar el cuadrante", "Error" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public boolean comprobarContratos(int semana) {
		//Declaraci�n de variables locales
		int contador = 0;
		
		for(Empleado e: miEmpresa.getListaEmpleados()) {
			for(Contrato c: e.getContratos()) {
				if(c.getSemana() == semana) {
					contador ++;
				}
			}
		}
		if(contador >= 5) { //Si existen m�s de 5 contratos registrados para una semana, se podr� realizar el cuadrante
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "No existen contratos suficientes para cubrir la semana", "Error" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
	}
}
