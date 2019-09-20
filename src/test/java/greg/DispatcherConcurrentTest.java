package greg;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.impl.DispatcherImp;

/*
 * 6 empleados
 * 10 llamadas concurrentes
 */
public class DispatcherConcurrentTest {
	
	/*
	 * 6 empleados
	 */
	@BeforeClass//@BeforeMethod @BeforeClass @BeforeTest	
	public void before() {
		dispatcher = new DispatcherImp(3, 2, 1);
		sinAtender.set(0);
	}
	
	/*
	 * 10 llamadas concurrentes
	 * 6 llamadas atendidas y 4 sin atender (perdidas)
	 */
	@Test(threadPoolSize = 10, invocationCount = 10)//timeOut = 10000
	public void test10Llamadas() throws InterruptedException {

		try {
			dispatcher.dispatchCall();
		} catch (NoSuchElementException e) {
			sinAtender.addAndGet(1);
		}
				
	}

	@AfterClass
	public void after() {
		assertEquals(sinAtender.get(), 4);
	}

	private Dispatcher dispatcher;

	private final AtomicInteger sinAtender = new AtomicInteger(0);
}
