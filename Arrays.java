import java.util.Vector;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;


public class Arrays {
	
	private static final char NUL = '\u0000';

	/**
	 * count the number of negative elements of an integers array
	 * @effects
	 * 		count = 0
	 * 		foreach element e in array a
	 * 			if e < 0
	 * 			count++
	 * 		return count
	 * i.e countNegative([1, -2, -5, 7]) = 2
	 * 	   countNegative([4,1,2]) = 0
	 * @param a
	 * @return
	 */
	public static int countNegative(int[] a){
		int count = 0;
		for(int e : a){
			if(e < 0)
				count++;
		}
		return count;
	}
	
	/**
	 * find the minimum number element in an array of integers
	 * @require  a neq null
	 * @effect
	 * 		minNum is the first element in array a
	 * 			foreach element e in array a
	 * 				if minNum > e
	 * 					minNum = e
	 * 			return minNum
	 * i.e minNum([1, 2, 4]) = 1
	 * 	   minNum([4, -2, 3]) = -2
	 * @param a
	 * @return
	 */
	public static int min(int[] a){
		int minNum = a[0];
		for(int e : a){
			if(minNum > e)
				minNum = e;
		}
		return minNum;
	}
	
	/**
	 * determine whether an array of integers is in ascending order
	 * @requires: a neq null
	 * @effects:
	 * 		for each element e and next element ne of e in an array a
	 * 			if e < ne
	 * 				return true
	 * 		return false
	 * @param a
	 * @return
	 */
	
	public static boolean isAscSorted(int[] a){
		for(int i=0; i < a.length; i++){
			for(int j=i+1; j < a.length; j++)
				if(a[i] < a[j])
					return true;
		}
		return false;
	}
	
	/**
	 * find the length of an array of CHARs
	 * @requires: a neq null
	 * @effects
	 * 		NUL = '\u0000'
	 * 		count  = 0;
	 * 		foreach character c in an array a
	 * 			if c != NUL
	 * 				count++
	 * 			else
	 * 				break
	 * 		return count;
	 * @param a
	 * @return
	 */
	public static int length(char[] a){
		int count = 0;
		for(char c : a){
			if(c != NUL)
				count++;
			else
				break;
		}	
		return count;
	}
	
	/**
	 * given 2 arbitrary of arrays of reals a and b, determine if a is subset, intersect or contains the 
	 * same elements with b
	 * @requires: a, b neq null 
	 * @effects:
	 * 			vector v
	 * 			compare = ""
	 * 			if a.length < b.length
	 * 				for each element e1 in array a
	 * 						if e1 != each element e2 in array b
	 * 							compare = "a is intersect b"
	 * 						else
	 * 							add e1 into v
	 * 			else
	 * 				for each element e2 in array b
	 * 						if each element e1 != e2
	 * 							compare = "a is intersect with b"
	 * 						else
	 * 							add e2 into v
	 * 
	 * 			if v.size == a.length /\ v.size == b.length
	 * 				compare = "a = b"
	 * 			if v.size == a.length /\ v.size < b.length
	 * 				compare = "b contains a"
	 * 			if v.size < a.length /\ v.size == b.length
	 * 				compare = "a contains b"
	 * 
	 * 			if v.size != a.length /\ v.size != b.length
	 * 				print all elements which a intersect with b
	 * 
	 * 			return compare
	 * 				
	 * @param a
	 * @return
	 */
	public static String compare(int[] a, int[] b){
		Vector v = new Vector();
		String compare = "";
		if(a.length < b.length){
			for(int i=0; i < a.length; i++){
				if(a[i] != b[i]){
					compare = "a is intersect with b";
				}else{
					v.add(a[i]);
				}
			}
		}else{
			for(int i=0; i < b.length; i++){
				if(a[i] != b[i]){
					compare = "a is intersect with b";
				}else{
					v.add(b[i]);
				}
			}
		}
		
		
		if(v.size() == a.length && v.size() == b.length){
			compare = "a = b";
		}
		
		if(v.size() == a.length && v.size() < b.length){
			compare = "b contains a";
		}
		
		if(v.size() < a.length && v.size() == b.length){
			compare = "a contains b";
		}
		if(v.size() != a.length && v.size() != b.length ){
			System.out.println("the same elements : ");
			for(int j =0; j< v.size();j++){
				
				System.out.print(v.get(j)+" ");
			}
		}
		return compare;
	}
	
	/**
	 * 
	 */
	
	
	/**
	 * compute the frequencies of each element of an array of reals
	 * @requires: a neq null
	 * @effect
	 * 		count = 0
	 * 		foreach element e in an array a
	 * 			for each element e1 in an array a
	 * 				if e = e1
	 * 				count++
	 * 		print the result
	 * 		reset count
	 * 			
	 * i.e freq([1, 2, 7, 2, 1, 1]) = [3, 2, 1, 2, 3, 3]
	 * @param a
	 */
	public static void freq(int[] a){
		int count = 0;
		for(int i=0; i < a.length; i++){
			for(int j=0; j < a.length; j++){
				if(a[i] == a[j])
					count++;
				if(j<i && a[j]== a[i]){
					count = 0;
					break;
				}	
			}
			if(count >=1){
			System.out.println(a[i] + " --> "+count);
			count = 0;
			}
		}
		
	}

	
	/**
	 * the main procedure
	 * @param agrs
	 */
	public static void main(String[] agrs){
//		int[] arr = {1, -2, -5,1,-2};
//		int [] arr2 = {1, -2,5,8};
//		char[] a = {'a', 'v', 'e', NUL, 'r', 'm'};
//		System.out.println("Count Negatives: "+countNegative(arr));
//		System.out.println("Min Number: "+min(arr));
//	 	System.out.println("Is Ascending Order: "+isAscSorted(arr));
//		System.out.println("Length of a CHARs array: "+length(a));
//	    freq(arr);
//	    System.out.println("Compare: "+compare(arr, arr2));]
		
		System.out.println("*** Please input some information ***");
		System.out.println("Enter the length of your first array: ");
		int len1 = TextIO.getlnInt();
		
		int[] a1 = new int[len1];
		System.out.println("Enter your numbers");
		for(int i=0; i < len1; i++){
			System.out.println("Enter a1["+i+"]: ");
			a1[i] = TextIO.getlnInt();
		}
		
		
		System.out.println("Enter the length of your second array: ");
		int len2 = TextIO.getlnInt();
		
		int[] a2 = new int[len2];
		System.out.println("Enter your numbers");
		for(int i=0; i < len2; i++){
			System.out.println("Enter a2["+i+"]: ");
			a2[i] = TextIO.getlnInt();
		}
		
		System.out.println("Enter the length of your a CHARS array: ");
		int len3 = TextIO.getlnInt();
		
		char[] a = new char[len3];
		System.out.println("Enter your numbers");
		for(int i=0; i < len3; i++){
			System.out.println("Enter a["+i+"]: ");
			a[i] = TextIO.getlnChar();
		}
		
		///////////////////////////////////////////////////////////////////
		
		boolean q = false;
		while(q = true){
		System.out.println("*** MENU ***");
		System.out.println("1. Count number of negatives");
		System.out.println("2. Find the minimum number in an array");
		System.out.println("3. Find the length of an array contains NUL values");
		System.out.println("4. Frequency");
		System.out.println("5. Comparision");
		System.out.println("6. Press x to quit!");
		
		System.out.println(" ------------------------------------------------");
		System.out.println("");
		
		System.out.println("Enter your choice");
		String choice = TextIO.getln();
		
		
		switch(choice){
			case "1": {
				System.out.println("Count Negatives of your first array: "+countNegative(a1));
				System.out.println("Count Negatives of your second array: "+countNegative(a2));
				System.out.println();
				System.out.println(" ----------------------------------------------------------");
				System.out.println();
				break;
			}
			
			case "2": {
				System.out.println("Minimum number of 1st array: "+min(a1));
				System.out.println("Minimum number of 2nd array: "+min(a2));
				System.out.println();
				System.out.println(" ----------------------------------------------------------");
				System.out.println();
				break;
			}
			
			case "3": {
				System.out.println("Length of 1st array: "+length(a));
				System.out.println();
				System.out.println(" ----------------------------------------------------------");
				System.out.println();
				break;
			}
			
			case "4": {
				freq(a1);
				freq(a2);
				System.out.println();
				System.out.println(" ----------------------------------------------------------");
				System.out.println();
				break;
			}
			
			case "5":{
				System.out.println(compare(a1, a2));
				System.out.println();
				System.out.println(" ----------------------------------------------------------");
				System.out.println();
				break;
			}
			
			case "x": case "X": {
				System.exit(0);
			}
		}
	}
		
	}
}
