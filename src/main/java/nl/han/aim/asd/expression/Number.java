package nl.han.aim.asd.expression;

public class Number extends Expression {
    private String value;

    public Number(String value) {
        this.value = value;
    }

    public double eval() {
        return Double.parseDouble(value);
    }
    @Override
    public String toString() {
        return value;
    }
}
