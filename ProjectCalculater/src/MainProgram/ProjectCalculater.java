package MainProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProjectCalculater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Simple Calculator!");
        System.out.println("Operators: +  -  *  /  %  (= for find result)");
        System.out.println("Enter 'exit' to quit.");

        while (true) {
            System.out.print("Enter Number (After entering a number or operator, place a space) = ");
            String line = input.nextLine().trim();
            if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) break;
            if (line.isEmpty()) continue;

            String[] tokens = line.split("\\s+");
            if (tokens.length < 2 || !tokens[tokens.length - 1].equals("=")) {
                System.out.println("Expression must end with '='. Example: 5 + 3 * 2 =");
                continue;
            }

            try {
                List<String> steps = new ArrayList<>();

                // build token list without trailing '='
                List<String> toks = new ArrayList<>(Arrays.asList(tokens));
                toks.remove(toks.size() - 1); // remove '='

                // First pass: handle *, /, % (left-to-right)
                for (;;) {
                    boolean found = false;
                    for (int i = 0; i < toks.size(); i++) {
                        String t = toks.get(i);
                        if ("*".equals(t) || "/".equals(t) || "%".equals(t)) {
                            if (i - 1 < 0 || i + 1 >= toks.size()) throw new IllegalArgumentException("Malformed expression around: " + t);
                            double a = parseNumber(toks.get(i - 1));
                            double b = parseNumber(toks.get(i + 1));
                            double r;
                            switch (t) {
                                case "*": r = a * b; break;
                                case "/":
                                    if (b == 0) throw new ArithmeticException("Division by zero");
                                    r = a / b; break;
                                default: // %
                                    if (b == 0) throw new ArithmeticException("Modulo by zero");
                                    r = a % b; break;
                            }
                            String step = formatNumber(a) + " " + t + " " + formatNumber(b) + " = " + formatNumber(r);
                            steps.add(step);
                            // replace a, op, b with r
                            toks.set(i - 1, formatNumber(r));
                            toks.remove(i); // remove op
                            toks.remove(i); // remove b (now at i)
                            found = true;
                            break;
                        }
                    }
                    if (!found) break;
                }

                // Second pass: handle + and - (left-to-right)
                while (toks.size() > 1) {
                    double a = parseNumber(toks.get(0));
                    String op = toks.get(1);
                    double b = parseNumber(toks.get(2));
                    double r;
                    switch (op) {
                        case "+": r = a + b; break;
                        case "-": r = a - b; break;
                        default: throw new IllegalArgumentException("Unknown operator in low precedence pass: " + op);
                    }
                    String step = formatNumber(a) + " " + op + " " + formatNumber(b) + " = " + formatNumber(r);
                    steps.add(step);
                    // replace first three tokens with result
                    toks.set(0, formatNumber(r));
                    toks.remove(1);
                    toks.remove(1);
                }

                System.out.println("--- Process ---");
                for (String s : steps) System.out.println(s);
                System.out.println("Result: " + (toks.isEmpty() ? "" : toks.get(0)));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number in expression.");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        input.close();
        System.out.println("Goodbye.");
    }

    private static double parseNumber(String s) {
        return Double.parseDouble(s);
    }

    private static String formatNumber(double v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return String.format("%s", v);
    }
}