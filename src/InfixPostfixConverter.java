import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InfixPostfixConverter {


    public static void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            System.out.println("Infix: " + input);
            postFix(run(input));
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    public static String run(String input) {
        MyArrayStack<Character> operators = new MyArrayStack<Character>(input.length());
        StringBuilder convert = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)) {
                convert.append(current);
                convert.append(" ");
            } else {
                if (current == '(') {
                    operators.push(current);
                } else if (current == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        convert.append(operators.pop());
                        convert.append(" ");
                    }
                    if (!operators.isEmpty() && operators.peek() != '(') {
                        return "Input Error";
                    } else {
                        operators.pop();
                    }
                } else {
                    while (!operators.isEmpty() && precedence(current) <= precedence(operators.peek())) {
                        if (operators.peek() == '(') {
                            return "Input Error";
                        }
                        convert.append(operators.pop());
                        convert.append(" ");
                    }
                    operators.push(current);
                }
            }
        }
        while (!operators.isEmpty()) {
            if (operators.peek() == '(') {
                return "Input Error";
            }
            convert.append(operators.pop());
            convert.append(" ");
        }
        return convert.toString();
    }

    /**
     * @param input Character, should be operator to check precedence
     * @return Integer value for precedence of operator, higher value is higher precedence
     */
    public static int precedence(Character input) {
        switch (input) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    /**
     *
     * @param input
     */
    public static void postFix(String input) {
        System.out.println("Postfix: " + input);
        MyArrayStack<Integer> result = new MyArrayStack<Integer>(input.length());
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
            System.out.println("Result: " + result.peek());
        } catch (Exception EmptyStackException) {
            System.out.println("Empty Stack, input error");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}
