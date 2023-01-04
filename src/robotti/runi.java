package robotti;

import lejos.hardware.Button;

/**
 * LeJOS lego robotin Viivan seuraus ja esteen v�ist�
 * 
 * @author Mikko, Jarkko, Lassi
 * @since 10.03.2022
 * 
 */

public class runi {

	private static dataExchange DE;
	private static lineFollow LF;
	private static objDetect OD;
	static musa musa;

	/**
	 * Main s�ie, jossa k�ynnistet��n kaikki muut s�ikeet ja my�s itse ohjelma
	 */
	public static void main(String[] args) {
		DE = new dataExchange();
		LF = new lineFollow(DE);
		OD = new objDetect(DE);
		musa = new musa();

		Button.LEDPattern(2);
		System.out.println("Baina nabbula!");
		Button.waitForAnyPress();

		musa.biisi();

		LF.start();
		OD.start();

	}

}