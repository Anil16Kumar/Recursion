/*
Given an array arr[], generate and return all possible subarrays. The subarrays must be returned in the following order:
      1. Subarrays starting from the first element, followed by subarrays starting from the second element, and so on.
      2. For each starting index, subarrays should be in increasing length.

Examples:

Input: arr[] = [1, 2, 3]
Output: [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Explanation: Starting with the first element, we generate subarrays [1], [1, 2], and [1, 2, 3]. Then, starting from the second element, we get [2] and [2, 3].  Finally, starting from the third element, we only get [3].
Input: arr[] = [1, 2]
Output: [[1], [1, 2], [2]]
Explanation: Starting with the first element, we generate subarrays [1] and [1, 2]. Then, starting from the second element, we get [2].
Input: arr[] = [1, 1]
Output: [[1], [1, 1], [1]]
Explanation: Starting with the first element, we generate subarrays [1] and [1, 1] (including both elements). Starting from the second element, we only get the subarray [1].
Constraints:
1 ≤ arr.size() ≤ 200
1 ≤ arr[i] ≤ 10^3
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generating_All_Subarrays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t= scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            int nums[]=new int[n];
            for(int i=0;i<n;i++)
                nums[i]=scanner.nextInt();

            List<List<Integer>> answer=getSubArrayUsingRecursion(nums);
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> getSubArrayUsingRecursion(int[] nums){
        List<List<Integer>> answer=new ArrayList<>();
        startingPoint(nums, 0, answer);
        return answer;
    }
    public static void startingPoint(int[] nums, int start, List<List<Integer>> answer){
        if(start==nums.length)
            return;

        endingPoint(nums, start, start, new ArrayList<>(), answer);

        startingPoint(nums, start+1, answer);
    }
    public static void endingPoint(int[] nums, int start, int end, List<Integer> temp, List<List<Integer>> answer){
        if(end==nums.length)
            return;

        temp.add(nums[end]);
        answer.add(new ArrayList<>(temp));
        endingPoint(nums,start, end+1, temp, answer);
    }


    public static List<List<Integer>> getSubArrays(int[] nums){
        List<List<Integer>> answer=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=i;j<nums.length;j++){
                temp.add(nums[j]);
                answer.add(new ArrayList<>(temp));
            }
        }
        return answer;
    }

}
