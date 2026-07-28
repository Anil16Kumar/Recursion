/*
You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:

Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
Given the integer n, return the last number that remains in arr.



Example 1:

Input: n = 9
Output: 6
Explanation:
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr = [2, 4, 6, 8]
arr = [2, 6]
arr = [6]
Example 2:

Input: n = 1
Output: 1


Constraints:

1 <= n <= 10^9
**/

import java.util.Scanner;

public class Elimination_Game {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int num=scanner.nextInt();
            System.out.println(lastRemaining(num));
        }
    }
    public static int lastRemaining(int n) {
        int Arr[]=new int[n];
        for(int i=0;i<n;i++)
            Arr[i]=i+1;
        boolean oddPosition=true;
        return lastRemainingHelp(Arr,oddPosition);
    }
    public static int lastRemainingHelp(int[] Arr, boolean leftToRight) {

        if (Arr.length == 1)
            return Arr[0];

        int startIndex;
        int size;

        if (leftToRight) {
            startIndex = 1;
            size = Arr.length / 2;
        } else {
            if (Arr.length % 2 == 0) {
                startIndex = 0;
                size = (Arr.length + 1) / 2;
            } else {
                startIndex = 1;
                size = Arr.length / 2;
            }
        }

        int[] Brr = new int[size];
        int j = 0;

        for (int i = startIndex; i < Arr.length; i += 2) {
            Brr[j++] = Arr[i];
        }

        return lastRemainingHelp(Brr, !leftToRight);
    }
}
