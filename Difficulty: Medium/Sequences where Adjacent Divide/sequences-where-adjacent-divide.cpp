class Solution {
public:
    int count(int n, int m) {
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

        // Base case: Arrays of length 1
        for (int j = 1; j <= m; j++) {
            dp[1][j] = 1;
        }

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int curr = 1; curr <= m; curr++) {
                for (int prev = 1; prev <= m; prev++) {
                    if (curr % prev == 0 || prev % curr == 0) {
                        dp[len][curr] += dp[len - 1][prev];
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans += dp[n][j];
        }

        return ans;
    }
};