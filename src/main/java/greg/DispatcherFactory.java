package greg;

import java.util.Set;

public interface DispatcherFactory {

	public Dispatcher newMiembro();
	public Set<Dispatcher> newMiembros(int cant);
	public DispatcherCompuesto newEquipo(int cant);

}
