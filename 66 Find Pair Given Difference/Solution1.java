import java.util.Arrays;

class Solution {
    public boolean findPair(int arr[], int size, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {

            if (binSearch(arr[i] - n, 0, i - 1, arr))
                return true;

        }
        return false;
    }

    boolean binSearch(int x, int l, int h, int a[]) {

        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == x)
                return true;
            else if (x < a[mid])
                h = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}
// Time complexity : O(n*logn)