import java.util.*;

class GfG {
    int maxLen(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                ans = Math.max(ans, len);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}