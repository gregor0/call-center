package greg.impl;

import java.util.concurrent.ThreadLocalRandom;

import greg.Dispatcher;

/**
 * Empleado del call center que atiende llamadas.
 * 
 * @author greg
 */
public class Empleado implements Dispatcher {

	/**
	 * Solo puede atender una llamada a la vez.
	 * Permite acceder solo un Thread a la vez.
	 * 
	 * @throws InterruptedException
	 */
	@Override
	public synchronized boolean dispatchCall() throws InterruptedException {
		int randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		Thread.sleep(randomNum*1000);
		return true;
	}

}
