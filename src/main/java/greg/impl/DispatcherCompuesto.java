package greg.impl;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import greg.Dispatcher;

/**
 * Dispatcher que agrupa un conjunto de dispatchers hijos.
 * 
 * @author greg
 */
public abstract class DispatcherCompuesto implements Dispatcher {

	public DispatcherCompuesto add(Dispatcher hijo) {
		hijos.add(hijo);
		return this;
	}
	
	public DispatcherCompuesto(Set<? extends Dispatcher> c) {
		this();
		hijos.addAll(c);
	}

	public DispatcherCompuesto() {
		super();
	}

	protected final Queue<Dispatcher> hijos = new ConcurrentLinkedQueue<Dispatcher>();

}
