package expr;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import util.Assert;

public class ChartData implements ChartDataI {
	//According to the test source code,
	//when the create an instance of ChartData,
	//all method should satisfy the precondition
	//so just initialize some value to satisfy the precondition
	ExpressionFactory f=new ExpressionFactory();
    Expression e=f.constant(0);
    double xMin=0;
    double xMax=1;
    double yMin=0;
    double yMax=1;

    public void setExpression(Expression a) {
    	/* a is not null*/
    	e = a;
    	boolean x=(e!=null);
        Assert.check(x);
       
    }

    public Expression getExpression() {
        /*getExpression() != null*/
        return e;
    }

    public void setXRange( double xMin, double xMax ){
    	//xMin < xMax
    	boolean x=xMin < xMax;
        Assert.check(x);
        this.xMin=xMin;
        this.xMax=xMax;
    }

    public double getXMin() {
        /**Double.NEGATIVE_INFINITY < getXMin( ) */
        return this.xMin;
    }

    public double getXMax() {
        /**
         * getXMin( ) < getXMax( )
         * getXMax( ) < Double.POSITIVE_INFINITY
         */
        return this.xMax;
    }

    public void setYRange(double yMin, double yMax) {
        
        this.yMin=yMin;
        this.yMax=yMax;
        boolean x=(yMin<yMax);
        Assert.check(x);
    }

    public double getYMin() {
    /**Double.NEGATIVE_INFINITY < getYMin( ) 
    * getYMin( ) < getYMax( )
    */ 
        return this.yMin;
    }

    public double getYMax() {
        /**getYMax( ) < Double.POSITIVE_INFINITY */
        return this.yMax;
    }
}
