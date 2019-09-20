package greg;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import greg.impl.DispatcherImp;
import greg.impl.EquipoAtencionContadorDeLlamadas;


public class DispatcherTest {

	@Test(expectedExceptions = { NoSuchElementException.class }, expectedExceptionsMessageRegExp = "Sin empleados disponibles")
	public void testDispatchCall_SinEmpleadosDisponibles() throws InterruptedException {

		Dispatcher dispatcher = new DispatcherImp(0,0,0);
		dispatcher.dispatchCall();
	}

	@Test
	public void testDispatchCall() throws InterruptedException {

		Dispatcher dispatcher = new DispatcherImp(0,1,0);
		dispatcher.dispatchCall();
	}

	/**
	 * Prueba el orden de los empleados en el proceso de atencion.
	 * 1° Operador
	 */
	@Test
	public void testDispatchCall_ProcesoAtencionOperador() throws InterruptedException {

		EquipoAtencionContadorDeLlamadas<Operador> operadores = new EquipoAtencionContadorDeLlamadas<Operador>(true);
		EquipoAtencionContadorDeLlamadas<Supervisor> supervisores = new EquipoAtencionContadorDeLlamadas<Supervisor>(true);
		EquipoAtencionContadorDeLlamadas<Director> directores = new EquipoAtencionContadorDeLlamadas<Director>(true);

		Dispatcher dispatcher = new DispatcherImp(operadores,supervisores,directores);

		dispatcher.dispatchCall();

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

		EquipoAtencionContadorDeLlamadas<Operador> operadores = new EquipoAtencionContadorDeLlamadas<Operador>(false);
		EquipoAtencionContadorDeLlamadas<Supervisor> supervisores = new EquipoAtencionContadorDeLlamadas<Supervisor>(true);
		EquipoAtencionContadorDeLlamadas<Director> directores = new EquipoAtencionContadorDeLlamadas<Director>(true);

		Dispatcher dispatcher = new DispatcherImp(operadores,supervisores,directores);

		dispatcher.dispatchCall();

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

		EquipoAtencionContadorDeLlamadas<Operador> operadores = new EquipoAtencionContadorDeLlamadas<Operador>(false);
		EquipoAtencionContadorDeLlamadas<Supervisor> supervisores = new EquipoAtencionContadorDeLlamadas<Supervisor>(false);
		EquipoAtencionContadorDeLlamadas<Director> directores = new EquipoAtencionContadorDeLlamadas<Director>(true);

		Dispatcher dispatcher = new DispatcherImp(operadores,supervisores,directores);

		dispatcher.dispatchCall();

		assertEquals(operadores.getLlamadas(), 1);
		assertEquals(supervisores.getLlamadas(), 1);
		assertEquals(directores.getLlamadas(), 1);
	}

}
