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
}