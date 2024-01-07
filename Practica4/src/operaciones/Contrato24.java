package operaciones;

public class Contrato24 extends Contrato {
	//Declaraci�n de atributos
		private static final String tipoContrato = "Contrato de 24h";
		private static final int diasTrabajo = 3; 
		private static final int diasDescanso = 4;
		private static final int id = 0;
		
		//Definici�n de constructores
		public Contrato24(String fechaInicio, String fechaFinal, int semana) {
			super(tipoContrato, diasTrabajo, diasDescanso, fechaInicio, fechaFinal, id, semana); //Le pasamos al constructor del padre los d�as de trabajo y de descanso
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
