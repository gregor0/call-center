package greg.impl;

import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.Dispatcher;

/**
 * Caso:
 * capacidad 2 empleados
 * ejecucion 10 llamadas concurrentes
 * 
 * Resultado:
 * 0 < llamadas perdidas (8 aprox)
 */
public class EquipoConcurrentTest {
	
	@BeforeClass	
	public void before() {
		equipo = new Equipo(CallCenterUtil.NewEmpleados(2));		
		sinAtender.set(0);
	}
	
	@Test(threadPoolSize = 10, invocationCount = 10)
	public void testDispatchCall() throws InterruptedException {

		if (!equipo.dispatchCall())
			sinAtender.addAndGet(1);
	}

	@AfterClass
	public void after() {
		assertNotEquals(sinAtender.get(), 0);
	}

	private Dispatcher equipo;

	private final AtomicInteger sinAtender = new AtomicInteger(0);
}
