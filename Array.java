/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class Array {
    static final char NUL = '\u0000';

    /**
     * brief description: this method count the negative number of elements of
     * an array
     *
     * @requires array a!=null
     * @effects count = 0 foreach element e in array a if e < 0 count++ returns
     * count
     */
    public static int countNegative(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * brief description this method find the minimum element in array
     *
     * @requires a != null
     * @effects min = the first element in array a foreach element e in array a
     *
     * if e < min min = e returns min
     *
     */
    public static int min(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    /**
     * brief description this method determine whether an array of integers is
     * in ascending order
     *
     * @requires array a != null
     * @modifies a
     * @effects isAscSorted = false temp = first element in array a foreach
     * element e in a if e >= temp temp = e isAscSorted = true else isAscSorted
     * = false return isAscSorted
     */
    public static boolean isAscSorted(int[] a) {
        boolean isAscSorted = false;
        int temp = a[0];
        for (int i = 0; i < a.length; i++) {
            if (i < temp) {
                temp = i;
                isAscSorted = false;
            } else {
                isAscSorted = true;
            }
        }
        return isAscSorted;
    }

    /**
     * brief description this method find the length of an array of Chars
     *
     * @requires array a!= null
     * @effects 
     *      <p>length = 0
     *         constant NUL = '\u0000\' 
     *         for each element e in array a
     *         if(e!= NUL)
     *              length ++ 
     *         else
     *              stop for loop     
     *         return length</p>
     *
     */
    public static int length(char[] a) {
        int length = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != NUL) {
                length++;
            }
            else{
                i = a.length;
            }
        }
        return length;
    }
    /**
     * brief description this method find the median of an array of reals,that is the array value closest to the middle
     * @requires  array a!=null
     * @effects
     *      <p> 
     *          median = 0
     *          sum = 0
     *          middle = 0
     *          double array closest : closest.length = a.length
     *          for each element e in array a
     *              sum = sum + e
     *          middle = sum/a.length
     *          for each element e in array a
     *              each element c in array closest = e
     *          min = the first element in closest
     *          for each element c in array closest
     *              if min > c
     *                  min = c
     *                  median = e
     *          return median
     *          
     *      </p>
     * 
     */
    public static double median(double[] a){
        double median = 0;
        double sum = 0;
        double middle = 0,min;
        double[] closest = new double[a.length];
        
        for(int i= 0;i<a.length;i++){
            sum = sum + a[i];
        }
        middle = sum/a.length;
        for(int i= 0; i<a.length;i++){
            closest[i] = Math.abs(middle - a[i]);
        }
        min = closest[0];
        for(int i =0;i<closest.length;i++){
            if(min>closest[i]){
                min = closest[i];
                median = a[i];
            }
        }
        
        return median;
    }
    /**
     *brief description this method compare 2 arbitrary arrays of reals a and b
     * @requires array a!= null, array b!= null
     * @effects
     *      <p>
     *      Vector v
     *      compare = ""
     *      if a.length < b.length
     *          for each element e in array a
     *              if e != each element in b
     *                  compare = "a is different from b"
     *              else 
     *                  v add e
     *      else
     *          for each element e in array b
     *              if e != each element in a
     *                  compare = "a is different from b"
     *              else 
     *                  v add e
     *      if v.size = a.length /\ v.size = b.length
     *              compare = "a = b"
     *      if v.size = a.length /\ v.size < b.length
     *              compare = "b contains a"
     *      if v.size = b.length /\ v.size < a.length
     *              compare = "a contains b"
     *      return compare
     *      </p>
     */
    public static String compare(double[] a, double[] b){
        Vector v = new Vector();
        String compare="";
        if(a.length<b.length){
            for(int i = 0; i<a.length;i++){
                if(a[i] !=b[i]){
                   compare = "a is different from b";
                   i= a.length+1;
                }
                else
                    v.add(i, a[i]);
            }
        }
        else{
            for(int i = 0; i<b.length;i++){
                if(a[i] !=b[i]){
                   compare = "a is different from b";
                   i= b.length+1;
                }
                else
                    v.add(i, a[i]);
            }
        }
        if(v.size()== a.length && v.size()== b.length){
            compare = "a = b";
        } else if(v.size() == a.length && v.size() < b.length){
            compare = "b contains a";
        } else if(v.size() == b.length && v.size() < a.length){
            compare = "a contains b";
        }
        
        
        return compare;
    }
    /**
     * brief description this method compute the frequencies of each element of an array of reals a 
     * @requires array a!= null /\ a != {}
     * @effects
     *      <p>
     *      freq = 0
     *      for each element i in array a
     *          for each element j in array a
     *              if i = j
     *                  freq++
     *      return freq        
     *      </p>
     */
    public static void freq(double[] a){
        int freq = 0;
        boolean isSame = true;
        for (int i = 0; i< a.length; i++){
            for(int j = 0;j<a.length;j++){
                if(a[i]==a[j] && isSame == true){
                    freq++;
                    if(j<i){
                        isSame = false;
                        freq = 0;
                    }
                }
            }
            isSame = true;
            if(freq>0){
                System.out.println("element "+ a[i]+ " freq "+freq);
                freq = 0;
            }

        }
    }
    public static void main(String[] args) {
        System.out.println("-----MENU-----");
        System.out.println("Please choose 1 option");
        System.out.println("1.countNegative");
        System.out.println("2.min");
        System.out.println("3.isAscSorted");
        System.out.println("4.length of char array");
        System.out.println("5.median");
        System.out.println("6.compare");
        System.out.println("7.frequency");
        
        System.out.println("your option is ");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println("Input an array of interger: ");
                System.out.println("How many elements in your array? ");
                
                Scanner scn1 = new Scanner(System.in);
                int leng = scn1.nextInt();
                int[] a = new int[leng];
                
                for(int i =0; i< a.length;i++){
                    System.out.print("element["+i+"]: ");
                    a[i] = scn1.nextInt();
                }
                int ne = countNegative(a);
                System.out.println("the number of negative number in your array is "+ne);
                break;
            case 2:
                System.out.println("Input an array of interger: ");
                System.out.println("How many elements in your array? ");
                
                Scanner scn2 = new Scanner(System.in);
                int leng2 = scn2.nextInt();
                int[] a2 = new int[leng2];
                
                for(int i =0; i< a2.length;i++){
                    System.out.print("element["+i+"]: ");
                    a2[i] = scn2.nextInt();
                }
                int ne2 = min(a2);
                System.out.println("the number of negative number in your array is "+ne2);
                break;
            case 3:
                System.out.println("Input an array of interger: ");
                System.out.println("How many elements in your array? ");
                
                Scanner scn3 = new Scanner(System.in);
                int leng3 = scn3.nextInt();
                int[] a3 = new int[leng3];
                
                for(int i =0; i< a3.length;i++){
                    System.out.print("element["+i+"]: ");
                    a3[i] = scn3.nextInt();
                }
                boolean ne3 = isAscSorted(a3);
                System.out.println("is your array AscSorted?  "+ ne3);
                break;
            case 4:
                System.out.println("input an char array with some nul character");
                System.out.println("How many elements in your array? ");
                
                Scanner scn4 = new Scanner(System.in);
                int leng4 = scn4.nextInt();
                char[] chr = new char[leng4];

                for(int i =0; i< chr.length;i++){
                    TextIO.putln("input element["+i+"]: ");
                    chr[i] = TextIO.getChar();
                }
                int ne4 = length(chr);
                System.out.println("length of your array is "+ne4);
//                char[] ch = {'c','r','\u0000','u'};
//                int l = length(ch);
                
//                System.out.println(l);
                break;
            case 5:
                System.out.println("Input an array of real number: ");
                System.out.println("How many elements in your array? ");
                
                Scanner scn5 = new Scanner(System.in);
                int leng5 = scn5.nextInt();
                double[] a5 = new double[leng5];
                
                for(int i =0; i< a5.length;i++){
                    System.out.print("element["+i+"]: ");
                    a5[i] = scn5.nextDouble();
                }
                double ne5 = median(a5);
                System.out.println("the median of your array is "+ne5);
                break;
            case 6:
                System.out.println("Input 2 array of reals number");
                System.out.println("Array 1: ");
                System.out.println("length of array 1 is: ");
                Scanner scn61 = new Scanner(System.in);
                int leng61 = scn61.nextInt();
                double[] a61 = new double[leng61];

                for(int i =0; i< a61.length;i++){
                    System.out.print("element["+i+"]: ");
                    a61[i] = scn61.nextDouble();
                }
                System.out.println("Array 2: ");
                System.out.println("length of array 2 is: ");
                Scanner scn62 = new Scanner(System.in);
                int leng62= scn61.nextInt();
                double[] a62 = new double[leng62];

                for(int i =0; i< a62.length;i++){
                    System.out.print("element["+i+"]: ");
                    a62[i] = scn62.nextDouble();
                }
                String result = compare(a61, a62);
                System.out.println(result);
                break;
            case 7:
                System.out.println("Input an array of real number: ");
                System.out.println("How many elements in your array? ");
                
                Scanner scn7 = new Scanner(System.in);
                int leng7 = scn7.nextInt();
                double[] a7 = new double[leng7];
                
                for(int i =0; i< a7.length;i++){
                    System.out.print("element["+i+"]: ");
                    a7[i] = scn7.nextDouble();
                }
                freq(a7);
                break;
                default:
                    System.out.println("Wrong chosen. Choose again!!!");
            
        }
        
    }
}
