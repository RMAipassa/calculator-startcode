package nl.han.aim.asd.expression;

public class Multiplier extends Expression {

    private String operator = "*";
    private Expression left;
    private Expression right;

    public Multiplier(Expression left, Expression right) {
        this.left = left;
        this.right = right;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double eval() {
        return left.eval() * right.eval();
    }

    @Override
    public String toString() {
        return left.toString() + operator + right.toString();
    }
}
