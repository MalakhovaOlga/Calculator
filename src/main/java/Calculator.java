/**
    * Class Calculator to execute operations addition, subtraction, multiplication or division with two numbers
    * @author Malakhova Olga
    * @version 1.0
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main (String args[]) {
        System.out.println("Enter two numbers to execute operation addition, subtraction, multiplication or division");
        System.out.println("Examples: 5.0+5.0, 3.2-2.3, 4.4*0, 7.4/2.8");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String [] members = analyseInputString (input);
        float a = Float.parseFloat(members[0]);
        float b = Float.parseFloat(members[1]);
        char sign = members[2].charAt(0);
        float c = executeOperation(a,b,sign);
        System.out.printf(input + " = %.4f", c);
    }

    /**
     *
     * @param input input string to parse
     * @return array of operation members (numbers and the sign)
     */
    public static String[] analyseInputString (String input) {
        String [] members = new String [3];
        int i = 0;

        Pattern pattern = Pattern.compile("\\-?\\d+(\\.\\d{0,})?");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[i] = input.substring(start,end);
//            System.out.println(members[i]);
            i++;
        }

        pattern = Pattern.compile("[/*+-]");
        matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            members[2] = input.substring(start,end);
//            System.out.println(members[i]);
        }
        return members;
    }

    /**
     *
     * @param a the first operation member
     * @param b the second operation member
     * @param sign operation sign (+, -, *, or /)
     * @return result of the operation
     */
    public static float executeOperation (float a, float b, char sign) {
        float c = 0;

        switch (sign) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a + b;
                break;
            case '*':
                c = a * b;
                break;
            case '/':
                c = a / b;
                break;
        }
        return c;
    }
}
