package MainProgram;
import java.util.Scanner;
public class ProjectCalculater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter X : ");
        int x = input.nextInt();

        System.out.print("Enter operator (+ - * / %) : ");
        String op = input.next();

        System.out.print("Enter Y : ");
        int y = input.nextInt();
        
        if (op.equals("+")) {
            System.out.print("Result = " + (x + y));
        }else if (op.equals("-")) {
            System.out.print("Result = " + (x - y));
        }else if (op.equals("*")) {
            System.out.print("Result = " + (x * y));
        }else if (op.equals("/")) {
            if (y != 0) {
                System.out.print("Result = " + (x / y));
            }else{
                System.out.println("Error: Cannot divide by zero");
            }
        }else if (op.equals("%")) {
            System.out.print("Result = " + (x % y));
        }else{
            System.out.println("Invalid operator");
        }

        System.out.printf("HELLO TIME");
        System.out.println("HELLO JAVA");
        System.out.printf("HELLO TIME2");
        System.out.printf("HELLO TIME3");
        input.close();
    }
}