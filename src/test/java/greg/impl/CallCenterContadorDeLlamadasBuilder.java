package greg.impl;

import greg.CallCenterBuilder;
import greg.Dispatcher;
import greg.DispatcherCompuesto;

public class CallCenterContadorDeLlamadasBuilder extends CallCenterBuilder {

	@Override
	protected Dispatcher buildOperadores() {
		equipoOperadores = new DispatcherContadorDeLlamadas(operadores);
		return equipoOperadores;
	}

	@Override
	protected Dispatcher buildSupervisores() {
		equipoSupervisores = new DispatcherContadorDeLlamadas(supervisores);
		return equipoSupervisores;
	}

	@Override
	protected Dispatcher buildDirectores() {
		equipoDirectores = new DispatcherContadorDeLlamadas(directores);
		return equipoDirectores;
	}

	@Override
	protected DispatcherCompuesto buildCallCenter() {
		return new CallCenter();
	}

	public DispatcherContadorDeLlamadas getEquipoOperadores() {
		return equipoOperadores;
	}

	public DispatcherContadorDeLlamadas getEquipoSupervisores() {
		return equipoSupervisores;
	}

	public DispatcherContadorDeLlamadas getEquipoDirectores() {
		return equipoDirectores;
	}

	public CallCenterContadorDeLlamadasBuilder(boolean operadores, boolean supervisores, boolean directores) {
		super();
		this.operadores = operadores;
		this.supervisores = supervisores;
		this.directores = directores;
	}

	private boolean operadores; 
	private boolean supervisores; 
	private boolean directores;

	private DispatcherContadorDeLlamadas equipoOperadores; 
	private DispatcherContadorDeLlamadas equipoSupervisores; 
	private DispatcherContadorDeLlamadas equipoDirectores;
	 
}
