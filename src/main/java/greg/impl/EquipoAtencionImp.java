package greg.impl;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import greg.Empleado;
import greg.EquipoAtencion;

/**
 * Implementacion que deriva las llamadas a un empleado disponible.
 * 
 * @author greg
 */
public class EquipoAtencionImp<E extends Empleado> implements EquipoAtencion<E> {

	/**
	 * Un miembro del equipo que esta disponible atiende la llamada.
	 * 
	 * @return {@code true} la llamada fue atendida,
	 *		   {@code false} en caso de no haber empleados disponibles para atender la llamada 
	 */
	public boolean atenderLlamada() throws InterruptedException {
		E empleado = equipo.poll();
		if (empleado==null) 
			return false; 
		empleado.atenderLlamada();
		equipo.add(empleado);
		return true;
	}
	
	public EquipoAtencionImp<E> add(E empleado) {
		equipo.add(empleado);
		return this;
	}
	
	public EquipoAtencionImp(Collection<? extends E> c) {
		this();
		equipo.addAll(c);
	}

	public EquipoAtencionImp() {
		super();
	}

	private final Queue<E> equipo = new ConcurrentLinkedQueue<E>();

}
