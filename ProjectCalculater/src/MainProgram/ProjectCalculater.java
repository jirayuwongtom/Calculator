package MainProgram;
import java.util.Scanner;
public class ProjectCalculater {
    static class Calculator {
        private double x;
        private double y;

        public Calculator(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public void setX(double x) {
            this.x = x;
        }
        public void setY(double y) {
            this.y = y;
        }
        public double calculate(){
            return x;
        }
    }
    
    static class Add extends Calculator { 
        public Add(double x , double y){
            super(x , y);
        }
        @Override
        public double calculate() { 
            return getX() + getY(); 
        } 
    }
    static class Subtract extends Calculator { 
        public Subtract(double x , double y){
            super(x , y);
        }
        @Override
        public double calculate() { 
            return getX() - getY(); 
        } 
    }
    static class Multiply extends Calculator {
        public Multiply(double x , double y){
            super(x , y);
        }
        @Override
        public double calculate() {
            return getX() * getY();
        }
    }
    static class Divide extends Calculator {
        public Divide(double x , double y){
            super(x , y);
        } 
        @Override
        public double calculate() {
            if (getY() == 0) {
                System.out.println("It cannot be divided by 0.");
                return 0;
            }
            return getX() / getY();
        }
    }
    static class Percent extends Calculator {
        public Percent(double x , double y){
            super(x , y);
        } 
        @Override
        public double calculate() { 
            return (getX() * getY()) / 100; 
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
                tempNum = tempNum + c;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || i == Sinput.length() - 1) {
                if(!tempNum.isEmpty()) {
                    numbers[numCount++] = Double.parseDouble(tempNum);
                    tempNum = ""; 
                    if (i < Sinput.length() - 1) {
                        operators[opCount++] = c;
                    }
                }
            }
        }
        for (int i = 0; i < opCount; i++) {
            char op = operators[i];
            if (op == '*' || op == '/' || op == '%') {
                Calculator calc = null;
                if (op == '*') {
                    calc = new Multiply(numbers[i], numbers[i + 1]);
                }else if (op == '/') {
                    calc = new Divide(numbers[i], numbers[i + 1]);
                }else if (op == '%') {
                    calc = new Percent(numbers[i], numbers[i + 1]);
                }
                double result = calc.calculate();
                System.out.println("    Process: " + calc.getX() + " " + op + " " + calc.getY() + " = " + result);
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
            Calculator calc;
            if (operators[i] == '+') {
                calc = new Add(finalResult, numbers[i + 1]);
            }else {
                calc = new Subtract(finalResult, numbers[i + 1]);
            }
            double old = finalResult;
            finalResult = calc.calculate();
            System.out.println("    Process: " + old + " " + operators[i] + " " + calc.getY() + " = " + finalResult);
        }
        System.out.println("-----------------------------------");
        System.out.println("Output : " + finalResult);
        input.close();
    }
}