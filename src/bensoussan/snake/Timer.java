package bensoussan.snake;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {

	private long startTime;

	public Timer() {
		startTime = System.currentTimeMillis();
	}

	public long duration() {
		long currTime = System.currentTimeMillis();
		return startTime - currTime;
	}

	public String toString() {
		long duration = duration();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
		Date resultdate = new Date(duration);
		return sdf.format(resultdate);
	}
}
