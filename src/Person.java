
public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String employer;

    public Person(String firstName, String lastName, String employer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employer = employer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployer() {
        return employer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public int compareTo(Person input) {
        return this.lastName.compareTo(input.lastName);
    }

    public boolean equals(Person input) {
        return this.lastName.equals(input.lastName);
    }

}