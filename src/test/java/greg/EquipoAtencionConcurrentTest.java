package greg;

import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greg.impl.CallCenterUtil;
import greg.impl.EquipoAtencionImp;

/*
 * 2 empleados
 * 10 llamadas concurrentes
 */
public class EquipoAtencionConcurrentTest {
	
	/*
	 * 2 empleados
	 */
	@BeforeClass	
	public void before() {
		equipoAtencion = new EquipoAtencionImp<Operador>(CallCenterUtil.NewOperadores(2));		
		sinAtender.set(0);
	}
	
	/*
	 * 10 llamadas concurrentes
	 * alguna llamada deberia perderse, 8 aprox
	 */
	@Test(threadPoolSize = 10, invocationCount = 10)
	public void test10Llamadas() throws InterruptedException {

		if (!equipoAtencion.atenderLlamada())
			sinAtender.addAndGet(1);
	}

	/*
	 * alguna llamada sin atender
	 */
	@AfterClass
	public void after() {
		assertNotEquals(sinAtender.get(), 0);
	}

	private EquipoAtencion<Operador> equipoAtencion;

	private final AtomicInteger sinAtender = new AtomicInteger(0);
}
