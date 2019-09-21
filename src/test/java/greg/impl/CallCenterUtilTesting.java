package greg.impl;

import java.util.HashSet;
import java.util.Set;

import greg.Dispatcher;


public final class CallCenterUtilTesting {
	
	public static Set<Dispatcher> NewBoolDispatchers(boolean atender, int cant) {
		Set<Dispatcher> c = new HashSet<Dispatcher>();
		for (int i = 0; i < cant; i++) {
			c.add(new BoolDispatcher(atender));
		}
		return c;
	}

}
