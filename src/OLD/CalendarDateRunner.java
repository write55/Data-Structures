package OLD;/*
 * Aaron Wu
 * 1/27/20
 * 1.1 OLD.CalendarDate program runner
 */

public class CalendarDateRunner {

	public static void main(String[] args) {
		CalendarDate one = new CalendarDate();
		CalendarDate two = new CalendarDate(2, 29, 2020);
		CalendarDate three = new CalendarDate(1, 1, 2021);
		CalendarDate four = new CalendarDate(12, 31, 2019);

		System.out.println(one.toString());
		System.out.println(one.weekday());
		System.out.println("Next date: " + one.nextDate());
		System.out.println("Previous date: " + one.prevDate() + "\n");

		System.out.println(two.toString());
		System.out.println(two.weekday());
		System.out.println("Next date: " + two.nextDate());
		System.out.println("Previous date: " + two.prevDate() + "\n");

		System.out.println(three.toString());
		System.out.println(three.weekday());
		System.out.println("Next date: " + three.nextDate());
		System.out.println("Previous date: " + three.prevDate() + "\n");

		System.out.println(four.toString());
		System.out.println(four.weekday());
		System.out.println("Next date: " + four.nextDate());
		System.out.println("Previous date: " + four.prevDate() + "\n");
	}

}

// OUTPUT
/*
January 1, 2018
Monday
Next date: January 2, 2018
Previous date: December 31, 2017

February 29, 2020
Saturday
Next date: March 1, 2020
Previous date: February 28, 2020

January 1, 2021
Friday
Next date: January 2, 2021
Previous date: December 31, 2020

December 31, 2019
Tuesday
Next date: January 1, 2020
Previous date: December 30, 2019
 */