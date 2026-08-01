import java.util.Scanner;

/*
Max Profit with Money Exchange using n/2, n/3, and n/4
Difficulty: EasyAccuracy: 13.0%Submissions: 1K+Points: 2Average Time: 12m
Ritika has a coin worth n dollars.  she can exchange any coin worth n at the bank into three separate coins worth n/2, n/3, and n/4 (each value rounded down, i.e., integer division). She keeps exchanging coins wherever it results in profit.

Find the maximum total amount of money Ritika can end up with.

Examples:

Input: n = 5
Output: 5
Explanation: 5 => 5 / 2 + 5 / 3 + 5 / 4 = 2 + 1 + 1 = 4 (< 5), so exchanging gives a loss.
Hence, the maximum amount she can have is 5 itself (no exchange).
Input: n = 12
Output: 13
Explanation: 12 => 12 / 2 + 12 / 3 + 12 / 4 = 6 + 4 + 3 = 13 (> 12), so she exchanges.
None of 6, 4, or 3 can be exchanged further for profit.
Hence, the maximum amount is 13.
Constraints:
1 ≤ n ≤ 10^8
* */
public class MaximumProfit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int num=scanner.nextInt();
            System.out.println(maxExchangeMoney(num));
        }
    }

    public static int maxExchangeMoney(int num){
        if(num>=(num/2 + num/3 + num/4))
            return num;
        return Math.max(num, maxExchangeMoney(num/2) +
                maxExchangeMoney(num/3)+maxExchangeMoney(num/4));
    }
}
