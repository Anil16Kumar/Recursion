/*

Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3^x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 3^3

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3^x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3^x = (-1).
* */

import java.util.Scanner;

public class Power_of_Three {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while(n-->0){
            int num=scanner.nextInt();
            num=(num<0)?-1*(num):num;
            System.out.println(isPowerOfThree(num));
        }
    }

    public static boolean isPowerOfThree(int n){
        if(n==1)
            return true;
        if(n==0 || n%3!=0)
            return false;
        return isPowerOfThree(n/3);
    }
}
