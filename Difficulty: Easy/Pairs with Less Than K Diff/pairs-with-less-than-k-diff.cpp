class Solution {
public:
    int countPairs(vector<int>& arr, int k) {
        sort(arr.begin(), arr.end());

        int n = arr.size();
        int i = 0, j = 1;
        long long ans = 0;

        while (j < n) {
            if (arr[j] - arr[i] < k) {
                ans += (j - i);
                j++;
            } else {
                i++;
                if (i == j)
                    j++;
            }
        }

        return ans;
    }
};