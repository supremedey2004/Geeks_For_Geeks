class Solution {
public:
    bool canRepresentBST(vector<int> &arr) {
        stack<int> st;
        int lowerBound = INT_MIN;

        for (int x : arr) {

            // Invalid if current value is smaller than allowed
            if (x < lowerBound)
                return false;

            // Move to right subtree
            while (!st.empty() && x > st.top()) {
                lowerBound = st.top();
                st.pop();
            }

            st.push(x);
        }

        return true;
    }
};