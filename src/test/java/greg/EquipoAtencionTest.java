package greg;



import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import greg.impl.CallCenterUtil;
import greg.impl.EquipoAtencionImp;

public class EquipoAtencionTest {
	
	@Test
	public void testAtenderLlamada() throws InterruptedException {
	
		EquipoAtencion<Operador> equipoAtencion = new EquipoAtencionImp<Operador>(CallCenterUtil.NewOperadores(3));

		assertTrue(equipoAtencion.atenderLlamada());
		
	}

	@Test
	public void testAtenderLlamada_SinEmpleadosDisponibles() throws InterruptedException {
	
		EquipoAtencion<Operador> equipoAtencion = new EquipoAtencionImp<Operador>();
		
		assertFalse(equipoAtencion.atenderLlamada());
		
	}

}
