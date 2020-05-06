package UNIT3PROJECT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostFixRunner {

    /**
     * Takes a postfix string as input and calculates the result, prints it out in the console
     *
     * @param input String of the given operation in postfix notation
     * @return String of the given operation's result in readable format
     */
    public static String postFixCalculator(String input) {
        MyLinkedStack<Integer> result = new MyLinkedStack<Integer>();
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder str = new StringBuilder("\nPostfix: " + input);
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
                            str.append("\nOperator Error");
                            break;
                    }
                } catch (Exception ArithmeticException) {
                    str.append("\nArithmetic error");
                    break;
                }
            } else {
                result.push(Integer.parseInt(current));
            }
        }
        try {
            int out = result.peek();
            str.append("\nResult: ").append(out).append("\n");
        } catch (Exception EmptyStackException) {
            str.append("\nEmpty Stack, input error\n");
        }
        return str.toString();
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
