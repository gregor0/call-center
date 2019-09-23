package greg.impl;

import greg.Dispatcher;

public class BoolDispatcherFactory extends DispatcherFactoryImp {

	@Override
	public Dispatcher newMiembro() {
		return new BoolDispatcher(atender);
	}
	
	public BoolDispatcherFactory(boolean atender) {
		super();
		this.atender = atender;
	}

	private boolean atender;
}
