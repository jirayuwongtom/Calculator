package MainProgram;
import java.util.Scanner;

class ProjectCalculater {
    protected int x;
    protected int y;
    protected String operator;
    protected int result;

    public ProjectCalculater(int x, int y , String operator) {
        this.setX(x); 
        this.setY(y); 
        this.setOP(operator);
    }

    public void calculate() {

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

    public String getOP() {
        return operator;
    }
    public void setOP(String operator) {
        this.operator = operator;
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