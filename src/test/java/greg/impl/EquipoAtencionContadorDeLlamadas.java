package greg.impl;

import java.util.concurrent.atomic.AtomicInteger;

import greg.Empleado;
import greg.EquipoAtencion;

/**
 * Implementacion que cuenta las llamadas recibidas.
 * 
 * @author greg
 */
public class EquipoAtencionContadorDeLlamadas<E extends Empleado> implements EquipoAtencion<E> {

	public boolean atenderLlamada() throws InterruptedException {
		llamadas.addAndGet(1);
		return atender;
	}

	public int getLlamadas() {
		return llamadas.get();
	}
	
	public EquipoAtencionContadorDeLlamadas() {
		this(true);
	}

	/**
	 * 
	 * @param atender valor que devuelve atenderLlamada()
	 */
	public EquipoAtencionContadorDeLlamadas(boolean atender) {
		super();
		this.atender = atender;
	}

	private boolean atender;
	
	private final AtomicInteger llamadas = new AtomicInteger(0);	
}
