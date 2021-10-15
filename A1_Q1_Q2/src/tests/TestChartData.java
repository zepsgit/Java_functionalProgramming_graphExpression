package tests;

import static org.junit.Assert.*;
import org.junit.*;
import expr.*; 

public class TestChartData {
	
	ChartData cd = new ChartData() ;
	
	public static void main(String args[]) {
		ChartData cd=new ChartData();
		System.out.println("XMin is"+cd.getXMin());
		System.out.println("XMax is"+cd.getXMax());
		System.out.println(Double.NEGATIVE_INFINITY < cd.getXMin( ));
		
		assertNotNull( cd.getExpression() ) ;
		assertTrue( Double.NEGATIVE_INFINITY < cd.getXMin( ) ) ;
		assertTrue( cd.getXMin( ) < cd.getXMax( ) ) ;
		assertTrue( cd.getXMax( ) < Double.POSITIVE_INFINITY ) ;
		assertTrue( Double.NEGATIVE_INFINITY < cd.getYMin( ) ) ;
		assertTrue( cd.getYMin( ) < cd.getYMax( ) ) ;
		assertTrue( cd.getYMax( ) < Double.POSITIVE_INFINITY ) ;
	}
	
	@After
	public void checkInvariant( ) {
		// It's not always the case that a class invariant can be
		// checked using only the public interface. Better to 
		// put checks into the mutators and constructors.
		// That also ensures that the
		// checking happens during system tests as well as
		// unit tests.
//		assertNotNull( cd.getExpression() ) ;//not invoke set method cd.getExpression should be null
//		assertTrue( Double.NEGATIVE_INFINITY < cd.getXMin( ) ) ;
//		assertTrue( cd.getXMin( ) < cd.getXMax( ) ) ;
//		assertTrue( cd.getXMax( ) < Double.POSITIVE_INFINITY ) ;
//		assertTrue( Double.NEGATIVE_INFINITY < cd.getYMin( ) ) ;
//		assertTrue( cd.getYMin( ) < cd.getYMax( ) ) ;
//		assertTrue( cd.getYMax( ) < Double.POSITIVE_INFINITY ) ;
	}

	@Test public void testBasics() {
		
		checkInvariant( ) ;
		
		cd.setXRange(-20.5, +20.5);	
		checkInvariant( ) ;
		assertEquals( -20.5, cd.getXMin(), 0.00001 );
		assertEquals( 20.5, cd.getXMax(), 0.00001 );
		
		cd.setYRange(-100.001, -11.001);	
		checkInvariant( ) ;
		assertEquals( -100.001, cd.getYMin(), 0.00001 );
		assertEquals( -11.001, cd.getYMax(), 0.00001 );
		Expression a = (new ExpressionFactory()).x() ;
		cd.setExpression( a );
		checkInvariant( ) ;
		assertEquals(a, cd.getExpression() ); 	
	}
	
	@Test public void preconditionChecking0() {
		boolean ok ;
		try {
			cd.setXRange( 12, 12 );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;//I think this assignment should be deleted
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; 
			}
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking1() {
		boolean ok ;
		try {
			cd.setXRange( Double.NEGATIVE_INFINITY, 12 );
			ok = true ; }//original ok=false should be true
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; 
			}
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking2() {
		boolean ok ;
		try {
			cd.setXRange( 12, Double.POSITIVE_INFINITY );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking3() {
		boolean ok ;
		try {
			cd.setXRange( 12, Double.NaN );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}
	
	@Test public void preconditionChecking4() {
		boolean ok ;
		try {
			cd.setYRange( 12, 12 );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking5() {
		boolean ok ;
		try {
			cd.setYRange( Double.NEGATIVE_INFINITY, 12 );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking6() {
		boolean ok ;
		try {
			cd.setYRange( 12, Double.POSITIVE_INFINITY );
			ok = true ; }
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking7() {
		boolean ok ;
		try {
			cd.setYRange( 12, Double.NaN );
			ok = true ; }
		catch( AssertionError ex) { 
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}

	@Test public void preconditionChecking8() {
		boolean ok ;
		try {
			cd.setExpression( null ) ;
			ok = true ;}
		catch( AssertionError ex) {
			ok = true ; }
		catch( Throwable ex) {
			ok = false ;
			assertTrue( "Precondition violated, but exception thrown was not an AssertionError.", false) ; }
		assertTrue( "Precondition violated, but no exception thrown.", ok) ;
	}
}
