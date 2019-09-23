package greg.impl;

import java.util.HashSet;
import java.util.Set;

import greg.Dispatcher;
import greg.DispatcherCompuesto;
import greg.DispatcherFactory;

public class DispatcherFactoryImp implements DispatcherFactory {

	@Override
	public Dispatcher newMiembro() {
		return new Empleado();
	}

	@Override
	public Set<Dispatcher> newMiembros(int cant) {
		Set<Dispatcher> c = new HashSet<Dispatcher>();
		for (int i = 0; i < cant; i++) {
			c.add(newMiembro());
		}
		return c;
	}

	@Override
	public DispatcherCompuesto newEquipo(int cant) {
		return new Equipo(newMiembros(cant));
	}
	
}
