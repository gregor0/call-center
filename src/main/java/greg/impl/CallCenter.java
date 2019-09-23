package greg.impl;

import java.util.Set;

import greg.Dispatcher;

/**
 * Maneja las llamadas del call center.
 * 
 * Implementa el proceso de asignacion de llamadas con el siguiente orden:
 * 1° atiende un Operador si hay alguno disponible,
 * 2° atiende un Supervisor si hay alguno disponible,
 * 3° atiende un Director si hay alguno disponible
 * 
 */
public class CallCenter extends DispatcherCompuestoImp {

	/**
	 * 
	 * @return {@code true} la llamada fue atendida,
	 *		   {@code false} en caso de no haber empleados disponibles para atender la llamada
	 */
	@Override
	public boolean dispatchCall() throws InterruptedException {
		
		boolean atendida = false;
			
		for (Dispatcher hijo : hijos) {
			atendida = hijo.dispatchCall();
			if (atendida) break;
		}

		return atendida;
	}

	public CallCenter() {
		super();
	}

	public CallCenter(Set<? extends Dispatcher> c) {
		super(c);
	}

}
