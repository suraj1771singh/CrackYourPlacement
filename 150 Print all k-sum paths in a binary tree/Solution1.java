import java.util.*;

public class Solution1 {
    void printPath(TreeNode node, int k) {
        f(node, k, new ArrayList<>());
    }

    void f(TreeNode node, int k, List<Integer> path) {
        path.add(node.val);
        f(node.left, k, path);
        f(node.right, k, path);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k)
                print(i, path);
        }
        path.remove(path.size() - 1);
    }

    void print(int start, List<Integer> path) {
        for (int i = start; i < path.size(); i++)
            System.out.print(path.get(i) + " ");
        System.out.println();
    }
}
// Time complexity : O(n^2)
// Space complexity : O(h)