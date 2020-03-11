
public class Person implements Comparable<Person> {

    /**
     *
     */
    private String firstName;
    /**
     *
     */
    private String lastName;
    /**
     *
     */
    private String employer;

    /**
     *
     * @param firstName
     * @param lastName
     * @param employer
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
     *
     * @param input
     * @return
     */
    public int compareTo(Person input) {
        return this.lastName.compareTo(input.lastName);
    }

    /**
     *
     * @param input
     * @return
     */
    public boolean equals(Person input) {
        return this.firstName.equals(input.firstName) && this.lastName.equals(input.lastName) && this.employer.equals(input.employer);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nEmployer: " + employer;
    }

}