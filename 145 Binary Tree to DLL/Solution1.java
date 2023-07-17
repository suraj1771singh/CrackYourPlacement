//----------MORRIS TRAVERSAL
class Solution {

    Node bToDLL(Node root) {
        Node curr = root;
        Node head = null;
        Node prev = null;
        while (curr != null) {
            if (curr.left == null) {
                if (head == null)
                    head = curr;
                curr.left = prev;
                if (prev != null)
                    prev.right = curr;
                prev = curr;
                curr = curr.right;
            } else {
                Node next = curr.left;
                while (next.right != null && next.right != curr)
                    next = next.right;

                if (next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                } else {
                    curr.left = next;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return head;
    }
}