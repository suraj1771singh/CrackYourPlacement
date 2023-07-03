class Solution {
    int cnt;

    public int reversePairs(int[] nums) {
        cnt = 0;
        int n = nums.length;
        mergeSort(0, n - 1, nums);
        return cnt;
    }

    void mergeSort(int l, int h, int[] a) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(l, mid, a);
            mergeSort(mid + 1, h, a);
            merge(l, mid, h, a);
        }
    }

    void merge(int l, int mid, int h, int[] a) {
        int n1 = mid - l + 1, n2 = h - mid;
        int a1[] = new int[n1];
        int a2[] = new int[n2];
        for (int i = 0; i < n1; i++)
            a1[i] = a[l + i];
        for (int i = 0; i < n2; i++)
            a2[i] = a[mid + i + 1];

        int i = 0, j = 0, k = l;

        // count pairs
        for (; i < n1; i++) {
            while (j < n2 && a[i] > 2 * a[j])
                j++;
            cnt += j;
        }
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }
        while (i < n1)
            a[k++] = a1[i++];
        while (j < n2)
            a[k++] = a2[j++];
    }
}