package operaciones;

import java.util.*;

public abstract class Contrato {
	//Declaraci�n de atributos
	private String tipoContrato;
	private String fechaInicio;
	private String fechaFin;
	private final int diasTrabajo; 
	private final int diasDescanso;
	private ArrayList<Turno> turnos;
	private int id;
	private int semana;
	public int num;
	
	//Definici�n de constructores
	public Contrato(String tipoContrato, int diasTrabajo, int diasDescanso, String fechaInicio, String fechaFin, int id, int semana) {
		this.tipoContrato = tipoContrato;
		this.diasTrabajo = diasTrabajo;
		this.diasDescanso = diasDescanso;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.id = id;
		this.setSemana(semana);
		this.turnos = new ArrayList<Turno>(); //Creamos el array que contendr� los turnos semanales de dicho contrato
		this.asignacionTurnos(); //Asignamos los turnos en funci�n del tipo de contrato
	}	
	
	//Definici�n de getters y setters
	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//Para los atributos d�as de trabajo y descanso s�lo creamos m�todos getters ya que estos son de tipo "static final" y por tanto no ser�n modificados una vez creemos el tipo de contrato
	public int getDiasDescanso() {
		return diasDescanso;
	}

	public int getDiasTrabajo() {
		return diasTrabajo;
	}
	
	//Definici�n de m�todos	
	private void asignacionTurnos() {
		//Declaraci�n de varibales locales
		int i;
		
		if(this.tipoContrato == "Contrato de vacaciones") {
			for(i=0; i<7; i++)
				this.turnos.add(i, Turno.LIBRE);
		}else if(this.tipoContrato == "Contrato de 24h") {
			for(i=0; i<4; i++)
				this.turnos.add(i, Turno.LIBRE);
			for(i=4; i<7; i++)
				this.turnos.add(i, Turno.LIBRE);
		}else if(this.tipoContrato == "Contrato de 32h") {
			if(this.id == 1) {
				for(i=0; i<4; i++)
					this.turnos.add(i, Turno.NOCHE);
				for(i=4; i<7; i++)
					this.turnos.add(i, Turno.LIBRE);
			}else {
				for(i=0; i<2; i++)
					this.turnos.add(i, Turno.TARDE);
				for(i=2 ; i<5; i++)
					this.turnos.add(i, Turno.LIBRE);
				for(i=5; i<7; i++)
					this.turnos.add(i, Turno.MAÑANA);
			}
		}else if(this.tipoContrato == "Contrato de 40h") {
			if(this.id == 1) {
				for(i=0; i<2; i++)
					this.turnos.add(i, Turno.MAÑANA);
				for(i=2; i<5; i++)
					this.turnos.add(i, Turno.TARDE);
				for(i=5; i<7; i++)
					this.turnos.add(i, Turno.LIBRE);
			}else {
				for(i=0; i<2; i++)
					this.turnos.add(i, Turno.LIBRE);
				for(i=2; i<5; i++)
					this.turnos.add(i, Turno.MAÑANA);
				for(i=5; i<7; i++)
					this.turnos.add(i, Turno.TARDE);
			}
		}
	}
}
