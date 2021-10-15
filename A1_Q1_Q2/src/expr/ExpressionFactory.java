package expr;

import java.lang.Math;

public class ExpressionFactory implements ExpressionFactoryI {

    public Expression add(Expression a, Expression b) {
        return new AddExp(a, b);
    }

    public Expression subtract(Expression a, Expression b) {
        return new SubtractExp(a, b);
    }

    public Expression multiply(Expression a, Expression b) {
        return new MultiplyExp(a, b);
    }

    public Expression divide(Expression a, Expression b) {
        return new DivideExp(a, b);
    }

    public Expression constant(double value) {
        return new ConstExp(value);
    }

    public Expression x() {
        return new X();
    }

    public Expression sin(Expression a) {
        return new SinExp(a);
    }

    public Expression cos(Expression a) {
        return new CosExp(a);
    }

    public Expression tan(Expression a) {
        return new TanExp(a);
    }

    public Expression ln(Expression a) {
        return new LnExp(a);
    }

    public Expression parenthesized(Expression a) {
        return new Parenthesized(a);
    }
    
    public Expression exp(Expression a) {
        return new ExpExp(a);
    }
    public static void main(String args[]) {
        double x = 9;
        ExpressionFactory f = new ExpressionFactory();
        Expression a = f.constant(2);
        Expression b = f.multiply(a, f.x());
        Expression c = f.divide(f.constant(Math.PI), a);
        Expression d = f.add(b, c);
        Expression e = f.sin(d);
        System.out.println(f.x().toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString()+" at "+x+" is "+e.value(x));
    
    }

}
