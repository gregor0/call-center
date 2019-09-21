package greg.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import greg.Dispatcher;


public class CallCenterTest {

	public void testDispatchCall_SinEmpleadosDisponibles() throws InterruptedException {

		Dispatcher callCenter = new CallCenter(0,0,0);
		assertFalse(callCenter.dispatchCall());
	}

	@Test
	public void testDispatchCall() throws InterruptedException {

		Dispatcher callCenter = new CallCenter(0,1,0);
		assertTrue(callCenter.dispatchCall());
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 1° Operador
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionOperador() throws InterruptedException {

		DispatcherContadorDeLlamadas operadores = new DispatcherContadorDeLlamadas(true);
		DispatcherContadorDeLlamadas supervisores = new DispatcherContadorDeLlamadas(true);
		DispatcherContadorDeLlamadas directores = new DispatcherContadorDeLlamadas(true);

		Dispatcher callCenter = new CallCenter(operadores,supervisores,directores);

		callCenter.dispatchCall();

		assertEquals(operadores.getLlamadas(), 1);
		assertEquals(supervisores.getLlamadas(), 0);
		assertEquals(directores.getLlamadas(), 0);
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 2° Supervisor
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionSupervisor() throws InterruptedException {

		DispatcherContadorDeLlamadas operadores = new DispatcherContadorDeLlamadas(false);
		DispatcherContadorDeLlamadas supervisores = new DispatcherContadorDeLlamadas(true);
		DispatcherContadorDeLlamadas directores = new DispatcherContadorDeLlamadas(true);

		Dispatcher callCenter = new CallCenter(operadores,supervisores,directores);

		callCenter.dispatchCall();
		
		assertEquals(operadores.getLlamadas(), 1);
		assertEquals(supervisores.getLlamadas(), 1);
		assertEquals(directores.getLlamadas(), 0);
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 3° Director
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionDirector() throws InterruptedException {

		DispatcherContadorDeLlamadas operadores = new DispatcherContadorDeLlamadas(false);
		DispatcherContadorDeLlamadas supervisores = new DispatcherContadorDeLlamadas(false);
		DispatcherContadorDeLlamadas directores = new DispatcherContadorDeLlamadas(true);
	
		Dispatcher callCenter = new CallCenter(operadores,supervisores,directores);

		callCenter.dispatchCall();
		
		assertEquals(operadores.getLlamadas(), 1);
		assertEquals(supervisores.getLlamadas(), 1);
		assertEquals(directores.getLlamadas(), 1);
	}

}
