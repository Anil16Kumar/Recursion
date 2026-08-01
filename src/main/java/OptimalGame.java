import java.util.Scanner;

/*
You are given an integer array arr[] of size n. The array elements represent n coins of values v1, v2, ....vn.
You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the coin's value.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Examples:

Input: arr[] = [5, 3, 7, 10]
Output: 15
Explanation: The user collects the maximum value as 15(10 + 5). It is guaranteed that we cannot get more than 15 by any possible moves.
Input: arr[] = [8, 15, 3, 7]
Output: 22
Explanation: The user collects the maximum value as 22(7 + 15). It is guaranteed that we cannot get more than 22 by any possible moves.
Constraints:
2 <= n <= 10^3
1 <= arr[i] <= 10^6
* */
public class OptimalGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            int Arr[]=new int[n];
            for(int i=0;i<n;i++)
                Arr[i]=scanner.nextInt();
            System.out.println(maximumAmount(Arr));
        }
    }

    public static int maximumAmount(int[] Arr){
        int i=0, j=Arr.length-1;
        return maximumAmountHelp(Arr, i, j);
    }
    public static int maximumAmountHelp(int Arr[], int  i, int j){
        if(i>j)
            return 0;
        else if(i==j)
            return Arr[i];
        else if(i+1==j)
            return Math.max(Arr[i], Arr[j]);

        return Math.max(
            Arr[i]+ Math.min(maximumAmountHelp(Arr,i+2,j),maximumAmountHelp(Arr,i+1,j-1)),
            Arr[j]+ Math.min(maximumAmountHelp(Arr,i,j-2),maximumAmountHelp(Arr,i+1,j-1))
        );
    }
}

/*
Suppose the coins are

[8, 15, 3, 7]

Imagine they're placed in a line.

 8    15    3    7
 ↑                ↑
Left           Right

Rules:

You can only pick the first coin or the last coin.
After you pick, your opponent picks.
Then you pick again.
Continue until all coins are gone.
Step 2: Your Goal

Your goal is not to collect the most coins.

Your goal is to collect the maximum total value.

Step 3: Suppose You Pick 8

Coins become

[15, 3, 7]

Now it's your opponent's turn.

He can choose

15

or

7

Will he choose 7?

No.

He wants to win too.

He will choose 15 because it's better for him.

Now the coins become

[3,7]

Now your turn.

You take

7

Opponent gets

3

Final score

You

8 + 7 = 15

Opponent

15 + 3 = 18

You lose.

Step 4: Suppose Instead You Pick 7

Initial coins

[8,15,3,7]

You pick

7

Remaining

[8,15,3]

Opponent now has only two choices.

8

or

3

Notice something?

15 is now in the middle.

The opponent cannot take it.

He must choose either

8

or

3

Suppose he chooses

8

Remaining

[15,3]

Now your turn.

You take

15

Opponent gets

3

Final

You

7 + 15 = 22

Opponent

8 + 3 = 11

You win.

Big Lesson

Sometimes taking the smaller coin now helps you get a bigger coin later.

That's why greedy doesn't work.

Step 5: So What Choices Do You Have?

Suppose the current coins are

i.............j

Like

[5,3,7,10]

You only have 2 choices.

Take

5

or

Take

10

Nothing else.

Step 6: If You Take Left Coin

Suppose

[5,3,7,10]

You take

5

Remaining

[3,7,10]

Now opponent plays.

He has two choices.

Take

3

or

Take

10
Case 1

Opponent takes

3

Remaining

[7,10]

Now it's your turn again.

Case 2

Opponent takes

10

Remaining

[3,7]

Now it's your turn again.

Which Case Will Happen?

Will opponent choose randomly?

No.

He wants you to get less money.

So he'll choose whichever option is worse for you.

That's why we say

Assume the opponent always makes the move that minimizes your future profit.

Step 7: Same If You Take Right

Suppose you take

10

Remaining

[5,3,7]

Opponent now chooses

5

or

7

Again,

he'll choose the move that hurts you the most.

Why do we use min()?

Imagine after your move, there are two possible future scores for you:

Option A → Later you can earn 20

Option B → Later you can earn 12

Will the opponent allow you to earn 20?

Of course not.

He will force you into

12

That's why we write

min(20,12)

=

12

Because the opponent always chooses the path that's worst for you.

Why do we use max()?

Now imagine you have two choices.

Take left

→ Final score = 15

Take right

→ Final score = 22

Which one will you choose?

Obviously

22

So you always do

max(leftChoice,rightChoice)
The Complete Thinking

Every turn, think like this:

Can I take LEFT?

        OR

Can I take RIGHT?

After I take one,

the opponent will play.

Since the opponent is smart,

he'll always leave me with the smaller future score.

So:

I choose the maximum (max) because I want the best outcome.
Opponent chooses the minimum (min) because they want the worst outcome for me.
Think of it like a chess game

You don't think:

"What move should I play?"

You think:

"If I play this move, what will my opponent do next?"

And then:

"After my opponent's best move, what will I do?"

This back-and-forth thinking is exactly what makes this a DP/minimax problem.
* */
