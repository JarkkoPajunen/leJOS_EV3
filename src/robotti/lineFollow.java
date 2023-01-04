package robotti;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class lineFollow extends Thread {

	dataExchange DE;
	EV3ColorSensor cs1;

//	MovePilot luokan tarvitsemat wheel, chassis oliot ja itse MovePilot
	Wheel wheel1 = WheeledChassis.modelWheel(Motor.A, 2.2).offset(-2);
	Wheel wheel2 = WheeledChassis.modelWheel(Motor.B, 2.2).offset(2);
	Chassis chassis1 = new WheeledChassis(new Wheel[] { wheel1, wheel2 }, WheeledChassis.TYPE_DIFFERENTIAL);

	MovePilot pilot = new MovePilot(chassis1);

	/**
	 * lineFollow luokan rakentaja, jossa dataExchange luokka
	 */
	public lineFollow(dataExchange DE) {
		this.DE = DE;

		cs1 = new EV3ColorSensor(SensorPort.S2);
		cs1.setCurrentMode("Red");
	}

	/**
	 * lineFollow säikeen run-metodi, jossa funktio viivan seuraukselle ja esteen
	 * väistölle
	 * 
	 * @param colorsample värisensorin arvojen merkitykset vaalea = 70 ja tumma = 0
	 * @param colorRaja   kynnysarvo värisensorille
	 */
	public void run() {

		final SampleProvider sp1 = cs1.getRedMode();

		int colorsample;
		int colorRaja = 25;

		int roundNumber = 1;
		System.out.println("Olemme kierroksella " + roundNumber);

		while (true) {

			float[] sample1 = new float[sp1.sampleSize()];
			sp1.fetchSample(sample1, 0);
			colorsample = (int) (sample1[0] * 100);

//			lineFollow funktio rivit 51 - 69

			if (DE.getCommand() == 1) {

				Motor.A.forward();
				Motor.B.forward();

				if (colorsample > colorRaja) {
					Motor.A.setSpeed(150);
					Motor.B.setSpeed(80);

				} else {

					Motor.A.setSpeed(80);
					Motor.B.setSpeed(150);
				}

			} else {

//				Kierroslukumittari, Toisella kierroksella sulkee ohjelman halutusti
				if (roundNumber == 2) {
					Motor.A.close();
					Motor.B.close();
					System.out.println("Mehut loppu, ei jaksa painaa ");
					System.exit(0);

//				Esteeen väistämisen funktio rivit 78 - 111 
				} else {

					Motor.A.stop();
					Motor.B.stop();
					System.out.println("Miinan kierto!! ");

					Delay.msDelay(200);

					pilot.setAngularSpeed(100);

					pilot.rotate(-60);
					Delay.msDelay(150);
					pilot.travel(10);
					pilot.rotate(60);
					pilot.travel(10);
					pilot.rotate(60);
					pilot.travel(8);
					pilot.rotate(-60);

//					Korjausliike esteen väistöön, jos robotti ei pysähdy viivalle
					while (colorsample > colorRaja) {
						pilot.travel(2);
						pilot.rotate(-50);

						if (colorsample > colorRaja) {
							break;
						}
					}

//					Robotin asettaminen viivanseuraus tilaan väistön jälkeen
					DE.setCommand(1);

					roundNumber++;

				}

			}

		}
	}
}
