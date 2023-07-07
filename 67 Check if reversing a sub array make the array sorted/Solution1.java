class solution {
    boolean isReverseSubarraySorted(int arr[], int n) {
        // Find the first and last index where array is not sorted
        // check in between those points, sorted in descending order or not
        int start = n, end = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                start = i;
                break;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                end = i;
                break;
            }
        }
        if (start >= end)
            return true;

        for (int i = start + 1; i <= end; i++)
            if (arr[i - 1] < arr[i])
                return false;

        return true;

    }
}
// Time complexity : O(n)