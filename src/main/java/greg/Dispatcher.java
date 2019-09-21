package greg;

/**
 * Elemento del call center capaz de atender o derivar llamadas.
 * 
 * @author greg
 */
public interface Dispatcher {

    /**
     * Atiende o deriva una llamada.
     * 
	 * @return {@code true} la llamada fue atendida, {@code false} la llamada no fue atendida 
     */
	public boolean dispatchCall() throws InterruptedException;

}
