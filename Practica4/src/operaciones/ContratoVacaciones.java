package operaciones;

public class ContratoVacaciones extends Contrato {
	//Declaraci�n de atributos
	private static final String tipoContrato = "Contrato de vacaciones";
	private static final int diasTrabajo = 0; 
	private static final int diasDescanso = 7;
	private static final int id = 0;
	
	//Definici�n de constructores
	public ContratoVacaciones(String fechaInicio, String fechaFin, int semana) {
		super(tipoContrato, diasTrabajo, diasDescanso, fechaInicio, fechaFin, id, semana); //Le pasamos al constructor del padre los d�as de trabajo y de descanso
	}

	//Definici�n de getters
	public static int getDiastrabajo() {
		return diasTrabajo;
	}

	public static int getDiasdescanso() {
		return diasDescanso;
	}
	
	public String getTipoContrato() {
		return tipoContrato;
	}
}
