package homework;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] coinTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int t = 1; t <= testCases; t++) {
            int target = scanner.nextInt();
            int[] dp = new int[target + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int coin : coinTypes) {
                for (int i = coin; i <= target; i++) {
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            System.out.print("#" + t + " ");
            for (int coin : coinTypes) {
                int count = dp[target] >= coin ? 1 : 0;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}
