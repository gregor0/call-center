package greg.impl;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import greg.Dispatcher;
import greg.DispatcherCompuesto;


public abstract class DispatcherCompuestoImp implements DispatcherCompuesto {

	@Override
	public DispatcherCompuestoImp add(Dispatcher hijo) {
		hijos.add(hijo);
		return this;
	}
	
	public DispatcherCompuestoImp(Set<? extends Dispatcher> c) {
		this();
		hijos.addAll(c);
	}

	public DispatcherCompuestoImp() {
		super();
	}

	protected final Queue<Dispatcher> hijos = new ConcurrentLinkedQueue<Dispatcher>();

}
