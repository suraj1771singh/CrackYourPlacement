// Using Contant Extra space
class Solution {
    public Node connect(Node root) {
        f(root, null);
        return root;
    }

    void f(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        f(curr.left, curr.right);
        f(curr.right, curr.next == null ? null : curr.next.left);
    }
}
// Time complexity : O(n);
// Space complexity : O(1)