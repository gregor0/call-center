package greg;

/**
 * Dispatcher que agrupa un conjunto de dispatchers hijos.
 * 
 * @author greg
 */
public interface DispatcherCompuesto extends Dispatcher {

	/**
	 * Agrega un dispatcher hijo.
	 * 
	 * @param hijo
	 * @return this
	 */
	public DispatcherCompuesto add(Dispatcher hijo);
	
}
