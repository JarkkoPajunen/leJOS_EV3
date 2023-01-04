package robotti;

import lejos.hardware.Sound;
import lejos.utility.Delay;

public class musa {

	/**
	 * Soittaa biisin
	 */
	public void biisi() {

		/**
		 * Super mario bros. Theme Sound.playTone(Nuotin Taajuus Hz, nuotin kesko ms)
		 */
		Sound.playTone(659, 200); // E
		Delay.msDelay(10);
		Sound.playTone(659, 200); // E
		Delay.msDelay(50);
		Sound.playTone(659, 200); // E
		Delay.msDelay(50);
		Sound.playTone(523, 200); // C
		Delay.msDelay(10);
		Sound.playTone(659, 200); // E
		Delay.msDelay(50);
		Sound.playTone(783, 350); // G
		Delay.msDelay(75);
		Sound.playTone(392, 350); // -G

//		Biisin loppu osa

//		Delay.msDelay(100);
//		Sound.playTone(1046, 200); //C
//		Delay.msDelay(75);
//		Sound.playTone(783, 200); //G
//		Delay.msDelay(50);
//		Sound.playTone(652, 200); //E
//		Delay.msDelay(30);
//		Sound.playTone(880, 200); //A
//		Delay.msDelay(50);
//		Sound.playTone(987, 200); //B
//		Delay.msDelay(40);
//		Sound.playTone(392, 200); //Bb
//		Delay.msDelay(40);
//		Sound.playTone(880, 200); //A
//		Delay.msDelay(40);
//		Sound.playTone(783, 200); //G
//		Delay.msDelay(40);
//		Sound.playTone(1318, 200); //E^
//		Delay.msDelay(40);
//		Sound.playTone(1568, 200); //G^
//		Delay.msDelay(40);
//		Sound.playTone(880, 200); //A^
//		Delay.msDelay(40);
//		Sound.playTone(1396, 200); //F^
//		Delay.msDelay(40);
//		Sound.playTone(1568, 200); //G^
//		Delay.msDelay(40);
//		Sound.playTone(1318, 200); //E^
//		Delay.msDelay(40);
//		Sound.playTone(1046, 200); //C^
//		Delay.msDelay(40);
//		Sound.playTone(1174, 200); //D^
//		Delay.msDelay(40);
//		Sound.playTone(987, 200); //B^
//		Delay.msDelay(40);

	}

}