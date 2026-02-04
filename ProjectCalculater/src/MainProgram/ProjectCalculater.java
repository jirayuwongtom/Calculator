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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("โจทย์ : ");
        String input = scan.nextLine(); 
        input = input.replace(" ", "");
        double[] numbers = new double[100]; 
        char[] operators = new char[100];
        int numCount = 0;
        int opCount = 0;
        String tempNum = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-') {
                tempNum += c;
            }
            if (c == '+' || c == '-' || i == input.length() - 1) {
                if(tempNum.isEmpty()) continue;
                
                numbers[numCount++] = Double.valueOf(tempNum);
                tempNum = ""; 
                
                if (i < input.length() - 1) {
                    operators[opCount++] = c;
                }
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
                System.out.println(oldResult + " " + op + " " + nextNumber + " = " + finalResult);
            }
        }
        System.out.println(" = " + finalResult);
        scan.close();
    }
}