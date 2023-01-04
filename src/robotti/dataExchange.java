package robotti;

public class dataExchange {

	/**
	 * dataExchange luokka, jossa yksi arvo jonka avulla objDetect ja lineFollow
	 * kommunikoivat
	 */
	private int command = 1;

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public dataExchange() {

	}

}
