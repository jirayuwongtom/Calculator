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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.close();
    }
}