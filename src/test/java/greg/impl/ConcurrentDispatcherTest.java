package greg.impl;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.Dispatcher;

/**
 * Caso:
 * capacidad 2 llamadas concurrentes
 * ejecucion 5 llamadas concurrentes
 * 
 * Resultado:
 * 5 llamadas atendidas/contabilizadas
 * 0 llamadas perdidas
 */
public class ConcurrentDispatcherTest {

	@BeforeClass
	public void before() {
		dispatcher = new ConcurrentDispatcher(new Empleado(), 2);				
	}
	
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testDispatchCall() throws InterruptedException {

		assertTrue(dispatcher.dispatchCall());
	}

	private Dispatcher dispatcher;
	
}
