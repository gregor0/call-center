package greg;

/**
 * Maneja las llamadas del call center.
 * 
 */
public interface Dispatcher {

    /**
     * Asigna las llamdas a los empleados disponibles.
     * 
     */
	public void dispatchCall() throws InterruptedException;

}
