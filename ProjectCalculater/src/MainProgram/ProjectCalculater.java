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

    class AddCalculator extends Calculator {
        public AddCalculator(int x , int y) {
            super(x , y);
        }
    }


public int getResult() {
    return this.result;
}

public void calculate_process() {
        if (this.operator.equals("+")) {
            this.result = this.x + this.y;
        } 
        else if (this.operator.equals("-")) {
            this.result = this.x - this.y;
        } 
        else if (this.operator.equals("*")) {
            this.result = this.x * this.y;
        } 
        else if (this.operator.equals("/")) {
            if (this.y != 0) {
                this.result = this.x / this.y;
            } else {
                System.out.println("Error: Cannot divide by zero");
                this.result = 0;
            }
        } 
        else {
            System.out.println("Invalid Operator");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        input.close();
    }




}