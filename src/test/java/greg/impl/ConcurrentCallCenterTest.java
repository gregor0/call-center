package greg.impl;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.CallCenterBuilder;
import greg.Dispatcher;
import greg.DispatcherFactory;

/**
 * Caso:
 * capacidad 10 llamadas concurrentes y 6 empleados
 * ejecucion 10 llamadas concurrentes
 * 
 * Resultado:
 * 6 llamadas atendidas/contabilizadas
 * 4 llamadas perdidas
 * 
 * Para que todas las llamadas sean atendidas la capacidad de llamadas concurrentes del
 * call center debe ser menor o igual a la cantidad de empleados del call center.
 */
public class ConcurrentCallCenterTest {
	
	@BeforeClass//@BeforeMethod @BeforeClass @BeforeTest	
	public void before() {

		DispatcherFactory factory = new DispatcherFactoryImp();
		CallCenterBuilder builder = new ConcurrentCallCenterBuilder(3, 2, 1, factory, 10);
		callCenter = builder.build();

		sinAtender.set(0);
	}
	
	@Test(threadPoolSize = 10, invocationCount = 10)//timeOut = 10000
	public void testDispatchCall() throws InterruptedException {
		
		if (!callCenter.dispatchCall())
			sinAtender.addAndGet(1);
	}

	@AfterClass
	public void after() {
		assertEquals(sinAtender.get(), 4);
	}

	private Dispatcher callCenter;

	private final AtomicInteger sinAtender = new AtomicInteger(0);
}
