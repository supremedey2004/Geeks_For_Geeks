class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) {
            return 0;
        }

        String s = String.valueOf(n);
        int len = s.length();
        long ans = 0;

        // Count numbers with fewer digits
        for (int digits = 1; digits < len; digits++) {
            int firstChoices = 9;

            // First digit cannot be d
            if (d != 0) {
                firstChoices--;
            }

            long ways = firstChoices;

            // Remaining digits have 9 choices each
            for (int j = 1; j < digits; j++) {
                ways *= 9;
            }

            ans += ways;
        }

        // Count numbers having the same number of digits as n
        for (int i = 0; i < len; i++) {
            int current = s.charAt(i) - '0';

            // Try smaller digits
            for (int digit = 0; digit < current; digit++) {
                if (i == 0 && digit == 0) {
                    continue;
                }

                if (digit == d) {
                    continue;
                }

                long ways = 1;

                // Remaining positions
                for (int j = i + 1; j < len; j++) {
                    ways *= 9;
                }

                ans += ways;
            }

            // If n contains d, stop
            if (current == d) {
                return (int) ans;
            }
        }

        // n itself does not contain d
        return (int) (ans + 1);
    }
}