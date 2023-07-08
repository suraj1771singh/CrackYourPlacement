import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        int next[] = new int[nums2.length];
        Arrays.fill(next, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[st.peek()] < nums2[i])
                next[st.pop()] = i;
            st.push(i);
        }
        System.out.println(Arrays.toString(next));
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int ind = map.get(nums1[i]);
            int val = next[ind];
            if (val == -1)
                res[i] = -1;
            else
                res[i] = nums2[val];
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)