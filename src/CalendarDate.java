
public class CalendarDate {

	private int month;
	private int day;
	private int year;

	public CalendarDate() {
		month = 1;
		day = 1;
		year = 2018;
	}

	public CalendarDate(int month, int day, int year) {
		if (isDayError(month, day, year)) {
			// call first constructor here - how do you do that?
			this.month = 1;
			this.day = 1;
			this.year = 2018;
		} else {
			this.month = month;
			this.day = day;
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
	}

	// consider splitting these up to use for the next/prior date thing
	public boolean isDayError(int month, int day, int year) {
		if (isLeapYear(year)) {
			if (month == 2 && day > 29) {
				return true;
			}
		} else {
			if (month == 2 && day > 28) {
				return true;
			}
		}
		// Check if month is one with 30 days
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30) {
				return true;
			}
		} else { // Month is either has 31 days or isn't any of them
			if (day > 31) {
				return true;
			}
		}
		// No day errors, final check for month error
		return month > 12;
	}

	public String nextDate() {
		if (day < 28) {
			day++;
		} else if (month == 2) { // check if month is February
			if (isLeapYear(year)) { // check for leap year
				if (day == 29) { // leap year, check for February 29th
					month++;
					day = 1;
				} else {
					day++;
				}
			} else { // not leap year, check if day is February 28th
				if (day == 28) {
					month++;
					day = 1;
				}
			}
		} else if (month == 12 && day == 31) { // Check if day is December 31st
			month = 1;
			day = 1;
			year++;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day == 30) {
				month++;
				day = 1;
			}
			// If this point is reached month must have 31 days
		} else if (day == 31) {
			month++;
			day = 1;
		}
		return this.toString();
	}

	// I don't know if either of these actually works - they should tho
	// Fix both so that they don't use private data
	public String prevDate() {
		if (day != 1) {
			day--;
		} else if (month == 3) {
			month = 2;
			if (isLeapYear(year)) {
				day = 29;
			} else {
				day = 28;
			}
		} else if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) {
			day = 31;
			month--;
		} else if (month == 1) {
			month = 12;
			day = 31;
			year--;
		} else {
			day = 30;
			month--;
		}
		return this.toString();
	}

	public String weekday() {
		int year1 = this.year;
		int month1 = month;
		if (month == 1 || month == 2) {
			year1--;
			month1 += 10;
		} else {
			month1 -= 2;
		}
		int y = year1 % 100;
		String yearString = Integer.toString(year1);
		int c = Integer.parseInt(yearString.substring(0, 2));
		int w = (day + (int) Math.floor((2.6 * month1) - .2) + y + (int) Math.floor(y / 4) + (int) Math.floor(c / 4)
				- (2 * c)) % 7;
		if (w < 0) {
			w += 7;
		}
		String out = "";
		switch (w) {
		case 0:
			out = "Sunday";
			break;
		case 1:
			out = "Monday";
			break;
		case 2:
			out = "Tuesday";
			break;
		case 3:
			out = "Wednesday";
			break;
		case 4:
			out = "Thursday";
			break;
		case 5:
			out = "Friday";
			break;
		case 6:
			out = "Saturday";
			break;
		}
		return out;
	}

	public String toString() {
		String mn = "";
		switch (month) {
		case 1:
			mn = "January";
			break;
		case 2:
			mn = "February";
			break;
		case 3:
			mn = "March";
			break;
		case 4:
			mn = "April";
			break;
		case 5:
			mn = "May";
			break;
		case 6:
			mn = "June";
			break;
		case 7:
			mn = "July";
			break;
		case 8:
			mn = "August";
			break;
		case 9:
			mn = "September";
			break;
		case 10:
			mn = "October";
			break;
		case 11:
			mn = "November";
			break;
		case 12:
			mn = "December";
			break;
		}
		return mn + " " + day + ", " + year;
	}

	public void tester() {
		System.out.println(this.getMonth() + "/" + this.getDay() + "/" + this.getYear());
		System.out.println(this.toString() + ", " + this.weekday());
	}

	public static void main(String[] args) {
		CalendarDate date = new CalendarDate(2, 28, 2020);
		date.tester();
		date.nextDate();
		date.tester();
	}
}
