package greg.impl;

import greg.CallCenterBuilder;
import greg.Dispatcher;
import greg.DispatcherCompuesto;
import greg.DispatcherFactory;

public class SimpleCallCenterBuilder extends CallCenterBuilder {

	@Override
	protected Dispatcher buildOperadores() {
		return factory.newEquipo(operadores);
	}

	@Override
	protected Dispatcher buildSupervisores() {
		return factory.newEquipo(supervisores);
	}

	@Override
	protected Dispatcher buildDirectores() {
		return factory.newEquipo(directores);
	}

	@Override
	protected DispatcherCompuesto buildCallCenter() {
		return new CallCenter();
	}

	/**
	 * Inicializa con cantidad determinada de empleados
	 * 
	 * @param operadores
	 * @param supervisores
	 * @param directores
	 */		
	public SimpleCallCenterBuilder(int operadores, int supervisores, int directores, 
			DispatcherFactory factory) {
		super();
		this.operadores = operadores;
		this.supervisores = supervisores;
		this.directores = directores;
		this.factory = factory;
	}

	private int operadores; 
	private int supervisores; 
	private int directores;

	private DispatcherFactory factory;
}
