package greg.impl;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Implementacion que cuenta las llamadas recibidas.
 * 
 * @author greg
 */
public class DispatcherContadorDeLlamadas extends BoolDispatcher {

	@Override
	public boolean dispatchCall() throws InterruptedException {
		llamadas.addAndGet(1);
		return super.dispatchCall();
	}	

	public int getLlamadas() {
		return llamadas.get();
	}
	
	public DispatcherContadorDeLlamadas() {
		super();
	}

	public DispatcherContadorDeLlamadas(boolean atender) {
		super(atender);
	}
	
	private final AtomicInteger llamadas = new AtomicInteger(0);

}
