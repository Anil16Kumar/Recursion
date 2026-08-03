import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Given a number n, generate n bit Gray codes. A Gray code sequence starts with a string of n zeros, and every consecutive Gray code in the sequence differs from the previous one by exactly one bit.

Examples:
Input: n = 2
Output: ["00", "01", "11", "10"]
Explanation: The sequence starts with 00, and every consecutive pair of codes differs by exactly one bit.
Input: n = 3
Output: ["000", "001", "011", "010", "110", "111", "101", "100"]
Explanation: The sequence starts with 000, and each consecutive Gray code differs from the previous one by exactly one bit.
Constraints :
1 ≤ n ≤ 16
* */
public class GenrateGrayCode {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            ArrayList<String> answer=generateGrayCode(n);
            System.out.println(answer);
        }
    }
    public static ArrayList<String> generateGrayCode(int n){
        if(n==1){
            ArrayList<String> base=new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        ArrayList<String> prev=generateGrayCode(n-1);
        ArrayList<String> ans=new ArrayList<>();

        for(String str: prev)
            ans.add("0"+str);

        for(int i=prev.size()-1;i>=0;i--)
            ans.add("1"+prev.get(i));

        return ans;
    }
}
