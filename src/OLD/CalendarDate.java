package OLD;/*
 * Aaron Wu
 * 1/27/20
 * 1.1 OLD.CalendarDate program
 */

public class CalendarDate {

    /**
     * month - integer from 1-12, represents month
     */
    private int month;
    /**
     * day - integer, 1-31, 1-30, 1-28 or 1-29 depending on month/leap year
     */
    private int day;
    /**
     * year - integer representing year
     */
    private int year;

    /**
     * Default constructor for OLD.CalendarDate class/sets date to January 1st, 2018
     */
    public CalendarDate() {
        month = 1;
        day = 1;
        year = 2018;
    }

    /**
     * Constructor for OLD.CalendarDate to set month, day, and year If dates have an
     * error, will default to January 1st, 2018
     *
     * @param month Integer to represent month
     * @param day   Integer to represent day of month
     * @param year  Integer to represent year
     */
    public CalendarDate(int month, int day, int year) {
        this();
        if (!isDayError(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }

    // GETTERS
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    // SETTERS
    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Input integer for year and checks for leap year
     *
     * @param year Integer to represent year
     * @return boolean, true if leap year, false if not
     */
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
    }

    /**
     * Checks if date from parameters is an error/nonexistent date
     *
     * @param month Integer to represent month
     * @param day   Integer to represent day of month
     * @param year  Integer to represent year
     * @return boolean, true if date has an error, false if it is correct
     */
    public boolean isDayError(int month, int day, int year) {
        if (month <= 0 || day <= 0 || year <= 0) {
            return true;
        }
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

    /**
     * Finds the date one day after after this OLD.CalendarDate object
     *
     * @return String with the month, day, and year of the next date
     */
    public String nextDate() {
        int month1 = month;
        int day1 = day;
        int year1 = year;
        if (day < 28) {
            day1++;
        } else if (month == 2) { // check if month is February
            if (isLeapYear(year)) { // check for leap year
                if (day == 29) { // leap year, check for February 29th
                    month1++;
                    day1 = 1;
                } else { // not February 29th
                    day1++;
                }
            } else { // not leap year, check if day is February 28th
                if (day == 28) {
                    month1++;
                    day1 = 1;
                }
            }
        } else if (month == 12 && day == 31) { // Check if day is December 31st
            month1 = 1;
            day1 = 1;
            year1++;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 30) {
                month1++;
                day1 = 1;
            }
            // If this point is reached month must have 31 days
        } else if (day == 31) {
            month1++;
            day1 = 1;
        }
        return monthConverter(month1, day1, year1);
    }

    /**
     * Finds the date one day prior to this OLD.CalendarDate object
     *
     * @return String with the month, day, and year of the previous date
     */
    public String prevDate() {
        int month1 = month;
        int day1 = day;
        int year1 = year;
        if (day != 1) { // If day isn't the 1st, subtracting by 1 is enough
            day1--;
        } else if (month == 3) { // Check if month is march
            month1 = 2;
            if (isLeapYear(year)) { // Check for leap year
                day1 = 29;
            } else {
                day1 = 28;
            }
            // Months that come after 31 day-long months
        } else if (month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) {
            day1 = 31;
            month1--;
        } else if (month == 1) { // Check for January 1st
            month1 = 12;
            day1 = 31;
            year1--;
        } else { // At this point, must precede 30 day month
            day1 = 30;
            month1--;
        }
        return monthConverter(month1, day1, year1);
    }

    /**
     * Finds the what weekday this OLD.CalendarDate object falls on
     *
     * @return String with the given weekday
     */
    public String weekday() {
        int year1 = year;
        int month1 = month;
        if (month == 1 || month == 2) {
            year1--;
            month1 += 10;
        } else {
            month1 -= 2;
        }
        String yearString = Integer.toString(year1);
        int c = Integer.parseInt(yearString.substring(0, 2));
        int y = Integer.parseInt(yearString.substring(2));
        int w = (day + (int) Math.floor((2.6 * month1) - .2) + y + (int) Math.floor((double) y / 4)
                + (int) Math.floor((double) c / 4) - (2 * c)) % 7;
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

    /**
     * Converts the three integers for month, day, and year into a more readable
     * format: Month name (not number), day, year Ex: January 1, 2018
     *
     * @param month Integer to represent month
     * @param day   Integer to represent day of month
     * @param year  Integer to represent year
     * @return String in format Month name,day, year
     */
    public String monthConverter(int month, int day, int year) {
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

    /**
     * toString method for this OLD.CalendarDate object, calls monthConverter with
     * private data
     *
     * @return String in format Month name,day, year
     */
    public String toString() {
        return monthConverter(month, day, year);
    }

}