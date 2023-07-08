import java.util.*;

class Solution {
    int cnt[];

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        // store indcies
        int a[][] = new int[n][2];
        cnt = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = new int[] { nums[i], i };
        mergesort(0, n - 1, a);
        List<Integer> res = new ArrayList<>();
        for (int num : cnt)
            res.add(num);
        return res;
    }

    void mergesort(int l, int h, int a[][]) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergesort(l, mid, a);
            mergesort(mid + 1, h, a);
            merge(l, mid, h, a);
        }
    }

    void merge(int l, int mid, int h, int a[][]) {
        int n1 = mid - l + 1, n2 = h - mid;
        int a1[][] = new int[n1][2];
        int a2[][] = new int[n2][2];
        for (int i = 0; i < n1; i++)
            a1[i] = a[l + i];
        for (int i = 0; i < n2; i++)
            a2[i] = a[mid + 1 + i];

        // count inversion
        int i = 0, j = 0;
        for (; i < n1; i++) {
            while (j < n2 && a1[i][0] > a2[j][0])
                j++;
            cnt[a1[i][1]] += j;
        }
        i = 0;
        j = 0;
        int k = l;
        // sort
        while (i < n1 && j < n2) {
            if (a1[i][0] < a2[j][0])
                a[k++] = a1[i++];
            else
                a[k++] = a2[j++];
        }
        while (i < n1)
            a[k++] = a1[i++];
        while (i < n2)
            a[k++] = a2[j++];
    }
}
// Time complexity : O(n*logn)