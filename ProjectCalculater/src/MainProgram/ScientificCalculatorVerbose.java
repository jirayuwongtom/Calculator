package MainProgram;
import java.util.Scanner;
public class ScientificCalculatorVerbose {
    static class Percent {
        public double calculate(double x, double y) { return (x * y) / 100; }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        String input = scan.nextLine();
        input = input.replace(" ", "");
        int pos = input.indexOf('%');
        if (pos == -1) {
            System.out.println("Incorrect format: It should be... a%b");
            scan.close();
            return;
        }
        try {
            double left = Double.parseDouble(input.substring(0, pos));
            double right = Double.parseDouble(input.substring(pos+1));
            Percent p = new Percent();
            double result = p.calculate(left, right);
            System.out.println("Calculate: " + left + " % " + right + " = " + result);
            System.out.println("Result = " + result);
        } catch (NumberFormatException e) {
        }
        scan.close();
    }
}