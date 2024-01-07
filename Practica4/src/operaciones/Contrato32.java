package operaciones;

public class Contrato32 extends Contrato {
	//Declaraci�n de atributos
	private static final String tipoContrato = "Contrato de 32h";
	private static final int diasTrabajo = 4; 
	private static final int diasDescanso = 3;
	
	//Definici�n de constructores
	public Contrato32(String fechaInicio, String fechaFin, int id, int semana) {
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
