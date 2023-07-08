import java.util.*;

//Idea : sort the keeping their pos in original array, then calculate swaps required to converted back sorted array back to original array
class Solution {

    public int minSwaps(int nums[]) {
        int n = nums.length;
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i] = new int[] { nums[i], i };
        }
        Arrays.sort(a, (p, q) -> p[0] - q[0]);
        int ind = 0, cnt = 0;
        while (ind < n) {
            if (a[ind][1] != ind) {
                // swap it with its orginal position in original array
                swap(ind, a[ind][1], a);
                cnt++;
            } else
                ind++;
        }
        return cnt;
    }

    void swap(int i, int j, int a[][]) {
        int temp[] = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// Time complexity : O(n*logn)