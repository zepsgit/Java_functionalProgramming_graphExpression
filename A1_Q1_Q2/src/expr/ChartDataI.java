package expr;

public interface ChartDataI {
	public void setExpression( Expression a );
	public Expression getExpression( );
	public void setXRange( double xMin, double xMax );
	public double getXMin( );
	public double getXMax( );
	public void setYRange( double yMin, double yMax );
	public double getYMin( );
	public double getYMax( );
}
