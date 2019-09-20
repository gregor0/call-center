package greg;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.impl.DispatcherImp;

/*
 * 10 empleados
 * 11 llamadas concurrentes
 */
public class DispatcherConcurrent11Test {
	
	/*
	 * 10 empleados
	 */
	@BeforeClass	
	public void before() {
		dispatcher = new DispatcherImp(4, 3, 3);
		sinAtender.set(0);
	}
	
	/*
	 * 11 llamadas concurrentes
	 * 11 llamadas atendidas, bloquea para esperar atender la 11°
	 */
	@Test(threadPoolSize = 11, invocationCount = 11)
	public void test10Llamadas() throws InterruptedException {

		try {
			dispatcher.dispatchCall();
		} catch (NoSuchElementException e) {
			sinAtender.addAndGet(1);
		}
				
	}

	@AfterClass
	public void after() {
		assertEquals(sinAtender.get(), 0);
	}

	private Dispatcher dispatcher;

	private final AtomicInteger sinAtender = new AtomicInteger(0);
}
