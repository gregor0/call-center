package greg.impl;

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
public class CallCenter extends DispatcherCompuesto {

	/**
	 * 
	 * @return {@code true} la llamada fue atendida,
	 *		   {@code false} en caso de no haber empleados disponibles para atender la llamada
	 */
	@Override
	public boolean dispatchCall() throws InterruptedException {
		
		boolean atendida = false;
			
		for (Dispatcher equipo : hijos) {
			atendida = equipo.dispatchCall();
			if (atendida) break;
		}

		return atendida;
	}

	public CallCenter(Dispatcher operadores, Dispatcher supervisores, Dispatcher directores) {
		super();
		hijos.add(operadores);
		hijos.add(supervisores);
		hijos.add(directores);
	}

	/**
	 * Inicializa con cantidad determinada de empleados
	 * 
	 * @param operadores
	 * @param supervisores
	 * @param directores
	 */
	public CallCenter(int operadores, int supervisores, int directores) {
		this(		
		new Equipo(CallCenterUtil.NewEmpleados(operadores)),
		new Equipo(CallCenterUtil.NewEmpleados(supervisores)),
		new Equipo(CallCenterUtil.NewEmpleados(directores))
		);		
	}
	
}
