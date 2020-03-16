package OLD;

public class Person implements Comparable<Person> {

    /**
     * firstName - String to hold first name
     */
    private String firstName;
    /**
     * lastName - String to hold last name
     */
    private String lastName;
    /**
     * employer - String to hold employer
     */
    private String employer;

    /**
     * Constructor for OLD.Person object, creates new OLD.Person object with given first
     * name, last name, and employer
     *
     * @param firstName String for new OLD.Person's first name
     * @param lastName  String for new OLD.Person's last name
     * @param employer  String for new OLD.Person's employer
     */
    public Person(String firstName, String lastName, String employer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employer = employer;
    }

    // GETTERS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployer() {
        return employer;
    }

    // SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * Compares the last names of two person objects
     *
     * @param input OLD.Person object to be compared to
     * @return int, positive if input is before, negative if input is after
     */
    public int compareTo(Person input) {
        return this.lastName.compareTo(input.lastName);
    }

    /**
     * Checks if all three fields (first name, last name, and employer) are
     * equal
     *
     * @param input OLD.Person object to be compared to
     * @return boolean, true if all three fields of a OLD.Person object are
     * identical the input
     */
    public boolean equals(Person input) {
        return this.firstName.equals(input.firstName) && this.lastName.equals(input.lastName)
                && this.employer.equals(input.employer);
    }

    /**
     * Returns String of first name, last name, and employer in readable format
     *
     * @return String with private data
     */
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nEmployer: " + employer;
    }

}