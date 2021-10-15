package expr;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Zepeng Chen
 * @studentId 202094147
 * @emai zepengc@mun.ca
 *              -----------Declaration---------------
 * This file was prepared by Zepeng Chen. It was completed by me alone
 * --------------------------------------------------------------------
 * This file create different classes which implement the same interface.
 * Different classes have different functionalities of doing addtion, subtraction, etc.
 */
class ConstExp implements Expression {
    double constData;
    public ConstExp(double x) {
        constData = x;
    }

    
    public double value(double x) {
        /**
         * The argument x is unused
         * Leave it just for being in accordance with the superclass method
         */
        return constData;
    }

    @Override
    public String toString() {
        return ""+constData;
    }

}

class AddExp implements Expression {
    Expression left;
    Expression right;

    AddExp(Expression a, Expression b) {
        left = a;
        right = b;
    }
    
    public double value(double x) {
        double d = left.value(x) + right.value(x);
        return d;
    }
    
    @Override
    public String toString() {
        String s;
        s = left.toString() +" + "+ right.toString();
        return s;
    }

}

class SubtractExp implements Expression {
    Expression left;
    Expression right;
    SubtractExp(Expression a, Expression b) {
        left = a;
        right = b;
    }

    public double value(double x) {
    /**
     * The first parameter is minuend
     * The second parameter is subtrahend
     */
        double d = left.value(x) - right.value(x);
        return d;
    }
    
    @Override
    public String toString() {
        String s;
        s = left.toString() +" - "+ right.toString();
        return s;
    }

}

class MultiplyExp implements Expression {
    Expression left;
    Expression right;

    MultiplyExp(Expression a, Expression b) {
        left = a;
        right = b;
    }
    
    public double value(double x) {
        double d = left.value(x) * right.value(x);
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = left.toString() +"*"+ right.toString();
        return s;
    }

}

class DivideExp implements Expression {
    Expression left;
    Expression right;

    DivideExp(Expression a, Expression b) {
        left = a;
        right = b;
    }
    
    public double value(double x) {
        double d = left.value(x) / right.value(x);
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = left.toString()+"/"+right.toString();
        return s;
    }

}

class X implements Expression {
    
    /**This class receive an input variable for another function 
     * such as sin(Expression a), cos(Expression b), etc.
     */
    double XData;

    public double value(double x) {
        XData = x;
        return XData;
    }

    public String toString() {
        //String s=String.format("%.5f",XData);
        return "x";
    }

}

class SinExp implements Expression {
    Expression root;
    SinExp(Expression a) {
        root = a;
    }
    
    @Override
    public double value(double x) {

        double d = Math.sin(root.value(x));
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = "sin(" + root.toString() + ")";
        return s;
    }  
}

class CosExp implements Expression {
    Expression root;
    CosExp(Expression a) {
        root = a;
    }
    
    @Override
    public double value(double x) {

        double d = Math.cos(root.value(x));
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = "cos(" + root.toString() + ")";
        return s;
    }  
}

class TanExp implements Expression {
    Expression root;
    TanExp(Expression a) {
        root = a;
    }
    
    @Override
    public double value(double x) {

        double d = Math.tan(root.value(x));
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = "tan(" + root.toString() + ")";
        return s;
    }  
}

class LnExp implements Expression {
    Expression root;

    LnExp(Expression a) {
        root = a;
    }

    @Override
    public double value(double x) {

        double d = Math.log(root.value(x));
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = "ln(" + root.toString() + ")";
        return s;
    }
}

class ExpExp implements Expression {
    Expression root;

    ExpExp(Expression a) {
        root = a;
    }

    @Override
    public double value(double x) {

        double d = Math.exp(root.value(x));
        return d;
    }

    @Override
    public String toString() {
        String s;
        s = "exp(" + root.toString() + ")";
        return s;
    }
}

class Parenthesized implements Expression {
    Expression root;
    Parenthesized(Expression a) {
        root = a;
    }
    @Override
    public double value(double x) {
        // TODO Auto-generated method stub
        return root.value(x);
    }

    public String toString() {
        return "(" + root.toString() + ")";
    }

}