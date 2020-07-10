package com.mygglo;

import com.mygglo.utils.MyMath;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MyMath myMath = new MyMath();

        System.out.println("Test1");
        int result = myMath.sum(new int[]{1, 2, 3});
        System.out.println("Result " + result);
    }
}
