class Solution {
public:
    int countMinOperations(vector<int>& arr) {
        int increments = 0;
        int doubles = 0;

        for (int x : arr) {
            increments += __builtin_popcount(x);

            int cnt = 0;
            while (x > 1) {
                x >>= 1;
                cnt++;
            }
            doubles = max(doubles, cnt);
        }

        return increments + doubles;
    }
};