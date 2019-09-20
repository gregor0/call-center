package greg;

/**
 * Agrupa empleados con el mismo rol que atienden las llamadas. 
 * 
 * @author greg
 * @param <E> el tipo de empleado que agrupa el equipo
 */
public interface EquipoAtencion<E extends Empleado> { 

	/**
	 * Un miembro del equipo atiende la llamada.  
	 * 
	 * @return {@code true} la llamada fue atendida, {@code false} la llamada no fue atendida 
	 * 		   
	 * @throws InterruptedException 
	 */
	public boolean atenderLlamada() throws InterruptedException;
 
}
