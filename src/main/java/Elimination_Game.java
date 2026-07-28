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
