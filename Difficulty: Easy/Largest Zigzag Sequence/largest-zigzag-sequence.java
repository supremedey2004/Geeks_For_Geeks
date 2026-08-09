class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        // dp[j] = maximum sum ending at column j
        // in the previous row
        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        // Process remaining rows
        for (int i = 1; i < n; i++) {

            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {

                // Previous column must be different
                for (int k = 0; k < n; k++) {

                    if (k != j) {
                        curr[j] = Math.max(
                            curr[j],
                            dp[k] + mat[i][j]
                        );
                    }
                }
            }

            dp = curr;
        }

        // Find maximum sum in the last row
        int ans = 0;

        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp[j]);
        }

        return ans;
    }
}