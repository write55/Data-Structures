
public class Patient implements Comparable<Patient> {

    private String fn; // first name
    private String ln; // last name
    private int priority;

    public Patient(String fn, String ln, int priority) {
        this.fn = fn;
        this.ln = ln;
        this.priority = priority;
    }

    // GETTERS
    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public int getPriority() {
        return priority;
    }

    // SETTERS
    public void setFn(String fn) {
        this.fn = fn;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Compares the priority of one patient to another
     * returns negative if the priority of this patient is higher (lower number)
     * returns positive if the priority of this patient is lower (higher number)
     *
     * @param o other patient object to compare priorities with
     * @return integer, positive if priority of this patient higher, negative if lower
     */
    public int compareTo(Patient o) {
        return this.priority - o.priority;
    }

    /**
     * Returns the private data of the patient in a readable format
     *
     * @return String with the private data of the patient
     */
    public String toString() {
        return "\nFirst Name: " + fn + "\nLast Name: " + ln + "\nPriority: " + priority + "\n";
    }
}
