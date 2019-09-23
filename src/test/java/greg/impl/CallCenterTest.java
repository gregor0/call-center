package greg.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import greg.Dispatcher;
import greg.DispatcherFactory;


public class CallCenterTest {

	public void testDispatchCall_SinEmpleadosDisponibles() throws InterruptedException {

		Dispatcher callCenter = new CallCenter();
		assertFalse(callCenter.dispatchCall());
	}

	@Test
	public void testDispatchCall() throws InterruptedException {

		DispatcherFactory factory = new DispatcherFactoryImp();
		SimpleCallCenterBuilder builder = new SimpleCallCenterBuilder(0, 1, 0, factory);
		Dispatcher callCenter = builder.build();

		assertTrue(callCenter.dispatchCall());
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 1° Operador
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionOperador() throws InterruptedException {

		CallCenterContadorDeLlamadasBuilder builder = new CallCenterContadorDeLlamadasBuilder(true, true, true);
		
		Dispatcher callCenter = builder.build();

		callCenter.dispatchCall();

		assertEquals(builder.getEquipoOperadores().getLlamadas(), 1);
		assertEquals(builder.getEquipoSupervisores().getLlamadas(), 0);
		assertEquals(builder.getEquipoDirectores().getLlamadas(), 0);
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 2° Supervisor
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionSupervisor() throws InterruptedException {

		CallCenterContadorDeLlamadasBuilder builder = new CallCenterContadorDeLlamadasBuilder(false, true, true);
		
		Dispatcher callCenter = builder.build();

		callCenter.dispatchCall();

		assertEquals(builder.getEquipoOperadores().getLlamadas(), 1);
		assertEquals(builder.getEquipoSupervisores().getLlamadas(), 1);
		assertEquals(builder.getEquipoDirectores().getLlamadas(), 0);

	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 3° Director
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionDirector() throws InterruptedException {

		CallCenterContadorDeLlamadasBuilder builder = new CallCenterContadorDeLlamadasBuilder(false, false, true);
		
		Dispatcher callCenter = builder.build();

		callCenter.dispatchCall();

		assertEquals(builder.getEquipoOperadores().getLlamadas(), 1);
		assertEquals(builder.getEquipoSupervisores().getLlamadas(), 1);
		assertEquals(builder.getEquipoDirectores().getLlamadas(), 1);
		
	}

}
