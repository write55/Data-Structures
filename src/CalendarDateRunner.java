public class CalendarDateRunner {
    public static void main(String[] args) {
        CalendarDate one = new CalendarDate();
        CalendarDate two = new CalendarDate(2, 29, 2020);
        System.out.println(one.toString());
        System.out.println(two.toString());
    }
}
