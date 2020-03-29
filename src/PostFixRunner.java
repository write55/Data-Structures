import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostFixRunner {

    // remove this and make it read one string at a time
    public static void readFile(MyLinkedStack<Integer> stack) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            run(input, stack);
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    public static void run(String input, MyLinkedStack<Integer> stack) {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String current = st.nextToken();
            if (current.length() == 1 && !Character.isDigit(current.charAt(0))) {
                try {
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (current) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            stack.push(a / b);
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                } catch (Exception ArithmeticException) {
                    System.out.println("Arithmetic error, try again");
                }
            } else {
                stack.push(Integer.parseInt(current));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MyLinkedStack<Integer> stack = new MyLinkedStack<Integer>();
        readFile(stack);
        try {
            System.out.println("Result: " + stack.peek());
        } catch (Exception EmptyStackException) {
            System.out.println("Empty Stack,  input error");
        }
    }

}
