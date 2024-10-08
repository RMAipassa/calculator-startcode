package nl.han.aim.asd.expression;

public class Subtraction extends Expression {

    private String operator = "-";
    private Expression left;
    private Expression right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double eval() {
        return left.eval() - right.eval();
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
    @Override
    public String toString() {
        return left.toString() + operator + right.toString();
    }
}
