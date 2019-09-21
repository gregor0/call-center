package greg.impl;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import greg.Dispatcher;

public class EquipoTest {
	
	@Test
	public void testDispatchCall() throws InterruptedException {
	
		Dispatcher equipo = new Equipo(CallCenterUtilTesting.NewBoolDispatchers(true,1));

		assertTrue(equipo.dispatchCall());
		
	}

	@Test
	public void testDispatchCall_SinDispatchersDisponibles() throws InterruptedException {
	
		Dispatcher equipo = new Equipo();
		
		assertFalse(equipo.dispatchCall());
		
	}

}
