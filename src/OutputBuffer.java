
// InfixQueue runs the whole project and calls the methods in this file

public class OutputBuffer {

    /**
     * ArrayQueue to hold output
     */
    private MyArrayQueue<String> output;

    /**
     * Constructor, creates String Queue
     */
    public OutputBuffer() {
        output = new MyArrayQueue<String>();
    }

    /**
     * Takes a String input and checks if the output buffer is full, if full, removes and prints one item
     * Adds String input to output buffer whether buffer
     *
     * @param input String to be added to output buffer
     */
    public void addToBuffer(String input) {
        if (output.isFull()) {
            System.out.println(output.dequeue());
        }
        output.enqueue(input);
    }

    /**
     * Removes and prints all items from output buffer
     */
    public void cleanBuffer() {
        while (!output.isEmpty()) {
            System.out.println(output.dequeue());
        }
    }

}
