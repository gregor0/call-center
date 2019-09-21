package greg.impl;

import java.util.concurrent.Semaphore;

import greg.Dispatcher;

/**
 * Dispatcher con capacidad limitada que deriva las llamadas a {@link #delegate}
 * 
 * @author greg
 */
public class ConcurrentDispatcher implements Dispatcher {

    /**
	 * Deriva las llamadas a {@link #delegate}
	 * 
     * <p>Acepta un maximo de llamadas concurrentes. 
     * En caso de alcanzar el maximo, bloquea hasta que una llamada sea resuelta. 
     * 
     */
	public final boolean dispatchCall() throws InterruptedException {

		this.semaphore.acquireUninterruptibly();
		
		try {

			return delegate.dispatchCall();
			
		} finally {
			this.semaphore.release();
		}
		
	}

	/**
	 * 
	 * @param delegate Dispatcher al que se derivan las llamadas
	 * @param capacidad limite de invocaciones concurrentes
	 */
	public ConcurrentDispatcher(Dispatcher delegate, int capacidad) {
		super();
		this.delegate = delegate;
		if (capacidad<=0) capacidad=CAPACIDAD;
		this.semaphore = new Semaphore(capacidad);
	}

	/**
	 * Inicializa con capacidad de {@value #CAPACIDAD} invocaciones concurrentes
	 * 
	 * @param delegate Dispatcher al que se derivan las llamadas
	 */
	public ConcurrentDispatcher(Dispatcher delegate) {
		this(delegate, CAPACIDAD);
	}

	/**
	 * Dispatcher al que se derivan las llamadas
	 */		
	private Dispatcher delegate;
	
	private Semaphore semaphore;

	/**
	 * Capacidad predeterminada de invocaciones concurrentes
	 */	
	private static final int CAPACIDAD = 10;
}
