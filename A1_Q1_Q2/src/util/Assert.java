package util;

public class Assert {
	static public void check( boolean x ) {
		check( x, "Assertion failed." ) ;//should use Assert.check
	}
	
	static public void check( boolean x, String message ) {
		if( !x ) { throw new AssertionError( message ) ; }
	}
}
