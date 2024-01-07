package operaciones;

public class Contrato40 extends Contrato {
	//Declaraci�n de atributos
	private static final String tipoContrato = "Contrato de 40h";
	private static final int diasTrabajo = 5; 
	private static final int diasDescanso = 2;
	
	//Definici�n de constructores
	public Contrato40(String fechaInicio, String fechaFin, int id, int semana) {
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
