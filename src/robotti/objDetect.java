package robotti;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class objDetect extends Thread {
	dataExchange DE;
	private EV3UltrasonicSensor us1;

	/**
	 * Säikeen rakentaja, jossa mukana dataExchange luokka
	 */
	public objDetect(dataExchange DE) {
		this.DE = DE;

		us1 = new EV3UltrasonicSensor(SensorPort.S1);
	}

	/**
	 * Säikeen run-metodi, jossa SampleProvider olio ja funktio esteen
	 * tarkastamiselle
	 * 
	 * @param distanceValue Ultraäänisensorin saama arvo
	 */
	public void run() {
		while (true) {

			final SampleProvider sp2 = us1.getDistanceMode();

			int distanceValue = 0;

			float[] sample2 = new float[sp2.sampleSize()];
			sp2.fetchSample(sample2, 0);
			distanceValue = (int) (sample2[0] * 100);

//			Esteen tarkastimisen funktio De.setCommand arvot 1 = seuraa viivaa 0 = tee väistö
			if (distanceValue < 15) {
				DE.setCommand(0);

			} else {
				DE.setCommand(1);
			}

		}
	}
}
