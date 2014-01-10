import java.util.HashMap;

/*
1.2.11 Develop an implementation SmartDate of our Date API that raises an excep-
tion if the date is not legal.

 */

public class SmartDate {

	private final int value;
	private static int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public SmartDate(int month, int day, int year) throws InvalidDateException {
		checkDate(month, day, year);
		this.value = (512*year + 32*month + day);
	}
	
	public void checkDate(int m, int d, int y) throws InvalidDateException  {
		if (y <= 1) {
			throw new InvalidDateException("Invalid year value");
		}
		if (m < 1 || m > 12) {
			throw new InvalidDateException("Invalid month value");
		}
		if (d < 1 || d > days[m-1]) {
			throw new InvalidDateException("Invalid day value");
		}
	}
	
	public int month() {
		return (value/32)%16;
	}
	
	public int day() {
		return value%32;
	}
	
	public int year() {
		return value/512;
	}
	
	public String toString() {
		return day() + "/" + month() + "/" + year();
	}
}
