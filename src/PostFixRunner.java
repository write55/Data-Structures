import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostFixRunner {

    /**
     * Method to read in file of postFix strings and send to postFix calculator method
     *
     * @throws IOException
     */
    public static void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            System.out.println("Infix: " + input);
            System.out.println(postFixCalculator(input));
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    /**
     * Takes a postfix string as input and calculates the result, prints it out in the console
     *
     * @param input String of the given operation in postfix notation
     * @return String of the given operation's result in readable format
     */
    public static String postFixCalculator(String input) {
        System.out.println("Postfix: " + input);
        MyLinkedStack<Integer> result = new MyLinkedStack<Integer>();
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String current = st.nextToken();
            if (current.length() == 1 && !Character.isDigit(current.charAt(0))) {
                try {
                    int b = result.pop();
                    int a = result.pop();
                    switch (current) {
                        case "+":
                            result.push(a + b);
                            break;
                        case "-":
                            result.push(a - b);
                            break;
                        case "*":
                            result.push(a * b);
                            break;
                        case "/":
                            result.push(a / b);
                            break;
                        default:
                            System.out.println("Operator Error");
                            break;
                    }
                } catch (Exception ArithmeticException) {
                    System.out.println("Arithmetic error");
                }
            } else {
                result.push(Integer.parseInt(current));
            }
        }
        try {
            return "Result: " + result.peek() + "\n";
            //System.out.println("Result: " + result.peek());
        } catch (Exception EmptyStackException) {
            return "Empty Stack, input error:\n";
            //System.out.println("Empty Stack, input error");
        }
        //System.out.print("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Postfix expressions with spaces between each character, enter QUIT to quit");
        System.out.print("Expression: ");
        String input = in.readLine();
        while (!input.equals("QUIT")) {
            System.out.println(postFixCalculator(input));
            System.out.print("Expression: ");
            input = in.readLine();
        }
        System.out.println("Program complete, terminating");
    }

}
