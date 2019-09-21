package greg.impl;

import java.util.HashSet;
import java.util.Set;


public final class CallCenterUtil {
	
	public static Set<Empleado> NewEmpleados(int cant) {
		Set<Empleado> c = new HashSet<Empleado>();
		for (int i = 0; i < cant; i++) {
			c.add(new Empleado());
		}
		return c;
	}
	
}
