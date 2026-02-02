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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        input.close();
    }
}