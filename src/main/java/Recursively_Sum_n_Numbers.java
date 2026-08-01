/*
Given a number n, recursively sum the numbers from 1 to n and return the sum.

Examples:

Input: n = 5
Output: 15
Explanation: Sum from 1 to 5 is 1 + 2 + 3 + 4 + 5 = 15.
Input: n = 4
Output: 10
Explanation: Sum from 1 to 4 is 1 + 2 + 3 + 4 = 10.
Constraints:
0 ≤ n ≤ 100
* */

import java.util.Scanner;

public class Recursively_Sum_n_Numbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int num=scanner.nextInt();
            System.out.println(recursiveSum(num));
        }
    }
    public static int recursiveSum(int num){
        if(num==0)
            return num;
        return num+recursiveSum(num-1);
    }
}

