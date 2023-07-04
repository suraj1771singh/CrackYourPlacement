import java.util.*;

class Solution {
    void printCombination(int n, int r, int[] a) {
        f(0, r, a, new ArrayList<>());
    }

    void f(int ind, int k, int a[], List<Integer> temp) {
        if (k == 0) {
            // print all elements
            for (int i : temp)
                System.out.print(i + " ");
            System.out.println();
            return;
        }
        if (ind >= a.length)
            return;

        temp.add(a[ind]);
        f(ind + 1, k - 1, a, temp);
        temp.remove(temp.size() - 1);
        f(ind + 1, k, a, temp);
    }
}
// Time complexity : O(2^n)