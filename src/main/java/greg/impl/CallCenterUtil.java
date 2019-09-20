package greg.impl;

import java.util.HashSet;
import java.util.Set;

import greg.Director;
import greg.Operador;
import greg.Supervisor;

public final class CallCenterUtil {
	
	public static Set<Operador> NewOperadores(int cant) {
		Set<Operador> c = new HashSet<Operador>();
		for (int i = 0; i < cant; i++) {
			c.add(new Operador());
		}
		return c;
	}

	public static Set<Supervisor> NewSupervisores(int cant) {
		Set<Supervisor> c = new HashSet<Supervisor>();
		for (int i = 0; i < cant; i++) {
			c.add(new Supervisor());
		}
		return c;
	}
	
	public static Set<Director> NewDirectores(int cant) {
		Set<Director> c = new HashSet<Director>();
		for (int i = 0; i < cant; i++) {
			c.add(new Director());
		}
		return c;
	}
	
}
