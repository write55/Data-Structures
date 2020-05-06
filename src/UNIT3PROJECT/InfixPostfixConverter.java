package UNIT3PROJECT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixPostfixConverter {

    /**
     * Method to read in file of infix strings and send to postFix converter method
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
            System.out.println(PostFixRunner.postFixCalculator(infixToPostfix(input)));
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    /**
     * Takes an operation in infix notation and converts it to postfix notation
     *
     * @param input String of operation in infix notation
     * @return String of operation converted to postfix notation
     */
    public static String infixToPostfix(String input) {
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
     * Takes a mathematical operator and returns its precedence as an integer, higher value is higher precedence
     *
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

    public static void main(String[] args) throws IOException {
        // readFile();
    }
}
