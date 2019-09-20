package greg;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Empleado del CallCenter que atiende llamadas.
 * 
 * @author greg
 *
 */
public abstract class Empleado {

	/**
	 * Solo puede atender una llamada a la vez.
	 * Permite acceder solo un Thread a la vez.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void atenderLlamada() throws InterruptedException {
		int randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		Thread.sleep(randomNum*1000);
	}

}
