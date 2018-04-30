package utilities;

public enum Wait {
	LOW(10), MED(20), MAX(30);
	private int interval;

	Wait(int interval) {
		this.interval = interval;
	}

	public int interval() {
		return interval;
	}
}