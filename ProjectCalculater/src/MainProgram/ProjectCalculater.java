package MainProgram;

public class ProjectCalculater {
    protected int x;
    protected int y;
    protected String operator;
    protected int result;

    public ProjectCalculater(int x, int y , String operator) {
        this.setX(x); 
        this.setY(y); 
        this.setOP(operator);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

<<<<<<< HEAD
        System.out.printf("HELLO TIME");
        System.out.println("HELLO JAVA");
        System.out.printf("HELLO TIME2");
        System.out.printf("HELLO TIME3");
        input.close();
=======
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
>>>>>>> Dev_Timelnwza007
    }
}