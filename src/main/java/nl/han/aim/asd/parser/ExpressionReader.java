package nl.han.aim.asd.parser;

import nl.han.aim.asd.expression.*;
import nl.han.aim.asd.expression.Number;

import java.util.Stack;

/**
 * Created by Michel Koolwaaij on 10-10-18.
 */
public class ExpressionReader extends ExpressionsBaseListener {
    Stack<Expression> expressions = new Stack<Expression>();

    public Expression getTopExpression() {
        return expressions.peek();
    }

    @Override
    public void exitExpression(ExpressionsParser.ExpressionContext ctx) {
        // Check if the expression is a single number
        if (ctx.getChildCount() == 1) {
            String numberText = ctx.getText();
            expressions.push(new Number(numberText));  // Push number onto stack
        }
        // Check if the expression is a binary operation
        else if (ctx.getChildCount() == 3) {
            // Pop the right operand first, then the left operand
            Expression right = expressions.pop();
            Expression left = expressions.pop();

            // Debugging output to see what's being processed
            String operator = ctx.getChild(1).getText();
            // Construct the appropriate expression based on the operator
            switch (operator) {
                case "+":
                    expressions.push(new Addition(left, right));
                    break;
                case "-":
                    expressions.push(new Subtraction(left, right));
                    break;
                case "*":
                    expressions.push(new Multiplier(left, right));
                    break;
                case "/":
                    expressions.push(new Division(left, right));
                    break;
            }
        }
    }

}


