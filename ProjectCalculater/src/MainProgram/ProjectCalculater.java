package MainProgram;
import java.util.Scanner;
public class ProjectCalculater {
    static class Calculator {
         public double calculate(double x, double y) { 
            return x; 
        } 
    }

    class Addition extends Calculator {
        public Addition(int x , int y) {
            super(x , y); 
        }
        public int add() {
            return this.x + this.y;
        }
        public int addTo(int currentTotal, int newValue) {
            return currentTotal + newValue;
        }
    }

    class Subtraction extends Calculator {
        public Subtraction(int x , int y) {
            super(x , y);
        }

        public int add() { return x + y; }

        public int subtract() {
            return this.x - this.y;
        }
        public int subtractTo(int currentTotal, int newValue) {
            return currentTotal - newValue;
        }
    }
    //--------------------------------
    //ตรงนี้เป็น class การคูณ
    class Multiplication extends Calculator {
        public Multiplication(int x, int y) { super(x, y); }
        public int multiply() { return x * y; }
    }
    //ตรงนี้เป็น class การหาร
    class Division extends Calculator {
        public Division(int x, int y) { super(x, y); }
        public int divide() { return (y == 0) ? 0 : x / y; }
    }
    //เพิ่มเติมคลาส multiplication และ division ที่สืบทอดมาจากคลาส Calculator 
    //--------------------------------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your expression : ");
        String expression = input.nextLine().replace(" ", "");

        ProjectCalculater pc = new ProjectCalculater();
        Addition addObj = pc.new Addition(0, 0);
        Subtraction subObj = pc.new Subtraction(0, 0);

        String[] parts = expression.split("(?=[+-])");
        
        int total = 0;

        for (String part : parts) {
            if (part.startsWith("+")) {
                int val = Integer.parseInt(part.substring(1));
                total = addObj.addTo(total, val);
            } else if (part.startsWith("-")) {
                int val = Integer.parseInt(part.substring(1));
                total = subObj.subtractTo(total, val);
            } else {
                total = Integer.parseInt(part);
            }
        }

        System.out.println("Result: " + total);
        input.close();
    }
}