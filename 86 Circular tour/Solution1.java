class Solution {

    int tour(int p[], int d[]) {
        int n = p.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += p[i] - d[i];

        if (sum < 0)
            return -1;
        int curr = 0, start = 0;
        for (int i = 0; i < n; i++) {
            curr += p[i] - d[i];
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
// Time complexity : O(n)
// Space complexity : o(1)