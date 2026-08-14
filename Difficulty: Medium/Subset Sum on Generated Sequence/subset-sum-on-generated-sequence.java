class Solution {
    public boolean isPossible(int[] arr, int s, int x) {

        ArrayList<Long> nums = new ArrayList<>();

        long sum = s;

        // First number on the paper
        nums.add(sum);

        // Generate the sequence
        for (int a : arr) {
            long next = sum + a;

            // Future numbers will only become larger
            if (next > x) {
                break;
            }

            nums.add(next);
            sum += next;
        }

        // Check subset sum using greedy from largest to smallest
        long remaining = x;

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) <= remaining) {
                remaining -= nums.get(i);
            }

            if (remaining == 0) {
                return true;
            }
        }

        return false;
    }
}