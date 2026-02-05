package MainProgram;
import java.util.Scanner;
public class ProjectCalculater {
    static class Calculator {
        public double calculate(double x, double y) { 
            return x;
        } 
    }
    static class Add extends Calculator { 
        public double calculate(double x, double y) { 
            return x + y;
        } 
    }
    static class Subtract extends Calculator { 
        public double calculate(double x, double y) { 
            return x - y; 
        } 
    }
    static class Multiply extends Calculator {
        public double calculate(double x, double y) {
            return x * y;
        }
    }
    static class Divide extends Calculator {
        public double calculate(double x, double y) {
            if (y == 0) {
                System.out.println("It cannot be divided by 0.");
                return 0;
            }
            return x / y;
        }
    }
    static class Percent extends Calculator {
        public double calculate(double x, double y) { 
            return (x * y) / 100; 
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number : ");
        String Sinput = input.nextLine(); 
        double[] numbers = new double[100]; 
        char[] operators = new char[100];
        int numCount = 0;
        int opCount = 0;
        String tempNum = "";
        for (int i = 0; i < Sinput.length(); i++) {
            char c = Sinput.charAt(i);
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '%') {
                tempNum += c;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || i == Sinput.length() - 1) {
                if(tempNum.isEmpty()) continue;
                numbers[numCount++] = Double.valueOf(tempNum);
                tempNum = ""; 
                if (i < Sinput.length() - 1) {
                    operators[opCount++] = c;
                }
            }
        }
        for (int i = 0; i < opCount; i++) {
            char op = operators[i];
            if (op == '*' || op == '/' || op == '%') {
                Calculator calc = null;
                if (op == '*') calc = new Multiply();
                else if (op == '/') calc = new Divide();
                else if (op == '%') calc = new Percent();
                double val1 = numbers[i];
                double val2 = numbers[i+1];
                double result = calc.calculate(val1, val2);
                System.out.println("    Process: " + val1 + " " + op + " " + val2 + " = " + result);
                numbers[i] = result;
                for (int j = i + 1; j < numCount - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                for (int j = i; j < opCount - 1; j++) {
                    operators[j] = operators[j + 1];
                }
                numCount--;
                opCount--;
                i--;
            }
        }
        double finalResult = numbers[0];
        for (int i = 0; i < opCount; i++) {
            char op = operators[i];
            double nextNumber = numbers[i+1];
            double oldResult = finalResult; 
            Calculator calc = null;
            if (op == '+') calc = new Add();
            else if (op == '-') calc = new Subtract();
            
            if (calc != null) {
                finalResult = calc.calculate(finalResult, nextNumber);
                System.out.println("    Process: " + oldResult + " " + op + " " + nextNumber + " = " + finalResult);
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("Output : " + finalResult);
        input.close();
    }
}