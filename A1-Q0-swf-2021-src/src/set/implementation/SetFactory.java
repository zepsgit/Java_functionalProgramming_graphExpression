package set.implementation;

import java.util.Iterator;
import set.SetFactoryI;
import set.SetI;
import set.implementation.LinkedList.Node;;
/**
 * <title>public class implementing setFactoryI and 
 * nonpublic class implementing SetI
 * </title>
 * <h3>Declaration</h3>
 * <p>This file was prepared by Zepeng Chen. It was completed by me alone.</p>
 * @author Zepeng Chen
 * @studentNumber 202094147
 * @email zepengc@mun.ca
 */
public class SetFactory implements SetFactoryI {
    /** Create an empty set. */
	public SetI makeSet() {
		return new Set();
	}
	
	/** Create a set with one integer in it. */
	public SetI makeSet(int x) {
		return new Set(x);
	}
	
	/** Create a set that contains a range of integers from first to first+count-1. */
	public SetI makeSet(int first, int count) {
		return new Set(first, count);
	}
//manual test for debugging
	 public static void main(String args[]) {
	 	SetFactory s = new SetFactory();
	 	SetI mySet = s.makeSet(2);
	 	SetI other = s.makeSet(1, 4);
	 	System.out.println("myset is " + mySet.toString());
	 	System.out.println("other is "+other.toString());
	 	String intersec = other.intersection(mySet).toString();
	 	String subtractI = mySet.subtract(other).toString();
	 	String subtract = other.subtract(mySet).toString();
	 	String uni = mySet.union(other).toString();
	 	String mySets=mySet.toString();
	 	String others=other.toString();
	 	System.out.println(others+" contains 2 "+other.contains(2));
	 	System.out.println(mySets+" unite "+others+uni);
	 	System.out.println(others+"subtract"+mySets+subtract);
	 	System.out.println(mySets+"subtract"+others+" "+subtractI);
	 	System.out.println(mySet+"intersect"+others+" "+intersec);
	 	
	 	SetI s1 = s.makeSet(1, 9) ;
		SetI t1 = s.makeSet( ) ;
		int lowest = -100 ;
		int highest = +100 ; 
		boolean [] expected = new boolean[  highest - lowest + 1 ] ;
		for( int x= -3 ; x < 20 ; ++x ) {
			if( x%2 == 0 ) t1 = s.makeSet( x ).union( t1 ) ;
			if( 1 <= x && x <= 9 && x%2 == 0 ) expected[ x-lowest ] = true ;
		}
		System.out.println("t1 is "+t1.toString());
		System.out.println("s1 is "+s1.toString());
		System.out.println("s1 intersect t1 is"+s1.intersection(t1));
		System.out.println("t1 intersect s1 is"+t1.intersection(s1));
	 }
}

/**
 * This class is immutable and nonpublic
 */
 final class Set implements SetI {
	/**create an empty container for Set */
	LinkedList myList = new LinkedList();
	 //Node temp = myList.head;
	//polymorphic constructor
	Set() {
	
	}
	
	Set(int first) {
		myList.addNode(first);
	}
	
	Set(int first, int count) {
		for (int i = 0; i < count; i++) {
			myList.addNode(first + i);
		}
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			Node temp = myList.head;
			Node prev;
            @Override
            public boolean hasNext() {
				return temp!= null;
            }

            @Override
			public Integer next() {
				prev = temp;
				temp = temp.next;
				return prev.data;
				
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};
	}
	/** Does this set contain x? */
	public boolean contains(int x) {
		Node temp = myList.head;
		while (temp != null) {
			if (temp.data == x) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	/** How many items are in this set. */
	public int size() {
		return myList.length();
	}
	
	/** Returns a set that contains everything in this set and also every thing in other. */
	public SetI intersection(SetI other) {
	
		Node temp=myList.head;
		Set interSec = new Set();
		//Intersect(A,B) is the collection of when B.contains(A) is ture 
		while(temp!=null) {
			if(other.contains(temp.data)) {
				interSec.myList.addNode(temp.data);
			}
			temp=temp.next;
		}
		return interSec;
	}
	
	/** Returns a set that contains everything in this set that is also in other. */
	public SetI union(SetI other) {
		Set uni = new Set();
		Node temp = myList.head;
		while (temp != null) {
			if (!other.contains(temp.data)) {
				uni.myList.addNode(temp.data);//add the node does not exist in other
			}
			temp = temp.next;
		}
		//clone other
		for (Integer x : other) {
			uni.myList.addNode(x);
		}
		return uni;
	}
	
	/** Returns a set that contains everything in this set that is not in the other. */
	public SetI subtract(SetI other) {
		Node temp = myList.head;
		
		Set subTrac = new Set();
		while (temp != null) {
			int count=0;//reset after every loop
			for (Integer x : other) {
				if (x != temp.data) {
					count++;
					if (count == other.size()) {
						subTrac.myList.addNode(temp.data);
					}
				}
				else {
					break;
				}
			}
			temp = temp.next;
		}
		return subTrac;	
	}
	
	/** Returns true if and only if everything in this set is also in other */
	public boolean subset(SetI other) {
		Node temp = myList.head;
		while (temp != null) {
			if (other.contains(temp.data)) {
				temp = temp.next;
			} else
				return false;
		}
		return true;
	}

	/** Convert to a string. */
	
	public String toString() {
		/**get array from data in List */
		Node temp=myList.head;
		final int[] dataArr = new int[myList.length()];
		for (int i = 0; i < myList.length(); i++) {
			dataArr[i] = temp.data;
			temp = temp.next;
		}
	
		int[] a = dataArr;
		int iMax = a.length - 1;  
		if (iMax == -1)  //if the array is empty
			return "{}";  
		
		StringBuilder b = new StringBuilder(); 
		b.append('{'); 
		for (int j = 0; ; j++) { 
			b.append(a[j]);  
			if (j == iMax)  //complete traverse
			return b.append('}').toString(); 
			b.append(", "); 
		}

	}
	
	/** Is other a set with the same contents. */
	@Override
	public boolean equals(Object other) {
		if (other instanceof SetI) {
			SetI otherAsSetI = (SetI) other;
			return otherAsSetI.subset(this) && this.subset(otherAsSetI);
		} else {
			return false;
		}
	}
	
}
