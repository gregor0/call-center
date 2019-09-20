package greg.impl;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

import greg.Director;
import greg.Dispatcher;
import greg.Empleado;
import greg.EquipoAtencion;
import greg.Operador;
import greg.Supervisor;

/**
 * El proceso de atencion de llamadas usa el siguiente orden:
 * 1° atiende un Operador si hay alguno disponible,
 * 2° atiende un Supervisor si hay alguno disponible,
 * 3° atiende un Director si hay alguno disponible
 * 
 */
public class DispatcherImp implements Dispatcher {

    /**
     * Acepta un maximo de 10 llamdas concurrentes. En caso de alcanzar el maximo, bloquea hasta que una llamada sea resuelta. 
     * 
     * @throws NoSuchElementException si no hay empleados disponibles  
     */
	public void dispatchCall() throws InterruptedException {

		this.semaphore.acquireUninterruptibly();
		
		try {

			boolean atendida = false;
			
			for (EquipoAtencion<? extends Empleado> equipo : equipos) {
				atendida = equipo.atenderLlamada();
				if (atendida) break;
			}
			
			if (!atendida)
				throw new NoSuchElementException("Sin empleados disponibles");
			
		} finally {
			this.semaphore.release();
		}
		
	}

	public DispatcherImp(EquipoAtencion<Operador> operadores, EquipoAtencion<Supervisor> supervisores, EquipoAtencion<Director> directores) {
		super();
		equipos.add(operadores);
		equipos.add(supervisores);
		equipos.add(directores);
	}

	public DispatcherImp(int operadores, int supervisores, int directores) {
		this(
		new EquipoAtencionImp<Operador>(CallCenterUtil.NewOperadores(operadores)),
		new EquipoAtencionImp<Supervisor>(CallCenterUtil.NewSupervisores(supervisores)),
		new EquipoAtencionImp<Director>(CallCenterUtil.NewDirectores(directores))
		);		
	}
	
	private final Queue<EquipoAtencion<? extends Empleado>> equipos = new ConcurrentLinkedQueue<EquipoAtencion<? extends Empleado>>(); 
	
	private final Semaphore semaphore = new Semaphore(CAPACIDAD);

	/**
	 * Limita a 10 invocaciones concurrentes
	 */
	private static final int CAPACIDAD = 10;
}
