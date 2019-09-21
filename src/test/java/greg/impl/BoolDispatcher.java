package greg.impl;

import greg.Dispatcher;


public class BoolDispatcher implements Dispatcher {

	@Override
	public boolean dispatchCall() throws InterruptedException {
		return atender;
	}

	public BoolDispatcher() {
		this(true);
	}

	/**
	 * 
	 * @param atender valor que devuelve dispatchCall()
	 */
	public BoolDispatcher(boolean atender) {
		super();
		this.atender = atender;
	}

	private boolean atender;
	
}
