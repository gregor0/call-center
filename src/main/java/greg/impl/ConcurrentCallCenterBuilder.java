package greg.impl;

import greg.Dispatcher;
import greg.DispatcherFactory;

public class ConcurrentCallCenterBuilder extends SimpleCallCenterBuilder {

	@Override
	protected Dispatcher build(Dispatcher callCenter) {
		return new ConcurrentDispatcher(callCenter, capacidad);
	}
	
	public ConcurrentCallCenterBuilder(int operadores, int supervisores, int directores, 
			DispatcherFactory factory,
			int capacidad) {
		super(operadores, supervisores, directores, factory);
		this.capacidad = capacidad;
	}

	private int capacidad;
}
