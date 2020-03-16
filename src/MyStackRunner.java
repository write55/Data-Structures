import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyStackRunner {

    public static void readFile(MyLinkedStack<String> stack) throws IOException {
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

    public static void run(String input, MyLinkedStack<String> stack) {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String current = st.nextToken();
            if (current.length() == 1 && !Character.isDigit(current.charAt(0))) {
                // what happens if the order of operators is fucked an the stack is empty so there's nothing to pop here
                try {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    switch (current) {
                        case "+":
                            stack.push(Integer.toString(a + b));
                            break;
                        case "-":
                            stack.push(Integer.toString(a - b));
                            break;
                        case "*":
                            stack.push(Integer.toString(a * b));
                            break;
                        case "/":
                            stack.push(Integer.toString(a / b));
                            break;
                        default:
                            System.out.println("fuk");
                            break;
                    }
                } catch (Exception ArithmeticException) {
                    System.out.println("Arithmetic error, try again");
                }
            } else {
                stack.push(current);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MyLinkedStack<String> stack = new MyLinkedStack<String>();
        readFile(stack);
        try {
            System.out.println("Result: " + stack.peek());
        } catch (Exception EmptyStackException) {
            System.out.println("Empty Stack,  input error");
        }
    }

}
