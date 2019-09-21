package greg.impl;

import java.util.Set;

import greg.Dispatcher;

/**
 * Dispatcher que deriva las llamadas a sus hijos segun disponibilidad.
 * 
 * @author greg
 */
public class Equipo extends DispatcherCompuesto {

	/**
	 * Deriva la llamada a un hijo que esta disponible.
	 * 
	 * @return {@code true} la llamada fue atendida,
	 *		   {@code false} en caso de no haber dispatcher disponibles para derivar la llamada 
	 * 					   o en caso que la llamada no fue atendida por el dispatcher seleccionado
	 * @throws InterruptedException 
	 */
	@Override
	public boolean dispatchCall() throws InterruptedException {
		
		Dispatcher hijo = hijos.poll();
		if (hijo==null) 
			return false; 
		
		boolean atendida = hijo.dispatchCall();
		
		hijos.add(hijo);

		return atendida;		
	}

	public Equipo() {
		super();
	}

	public Equipo(Set<? extends Dispatcher> c) {
		super(c);
	}
}
