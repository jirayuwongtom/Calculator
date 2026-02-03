package MainProgram;
import java.util.Scanner;

public class ProjectCalculater {
    class Calculator {
        protected int x;
        protected int y;

        public Calculator(int x, int y) {
            this.x = x; 
            this.y = y; 
        }
         public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
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
        public int subtract() {
            return this.x - this.y;
        }
        public int subtractTo(int currentTotal, int newValue) {
            return currentTotal - newValue;
        }
    }

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