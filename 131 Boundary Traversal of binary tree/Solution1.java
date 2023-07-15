import java.util.*;

class Solution {
    ArrayList<Integer> res;

    ArrayList<Integer> boundary(Node node) {
        res = new ArrayList<>();
        if (!isLeaf(node))
            res.add(node.data);
        addLeftNodes(node.left);
        addLeafNodes(node);
        addRightNodes(node.right);
        return res;
    }

    void addLeftNodes(Node node) {
        while (node != null) {
            if (isLeaf(node))
                break;
            res.add(node.data);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    void addLeafNodes(Node node) {
        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }
        if (node.left != null)
            addLeafNodes(node.left);
        if (node.right != null)
            addLeafNodes(node.right);
    }

    void addRightNodes(Node node) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (isLeaf(node))
                break;
            temp.add(node.data);
            if (node.right == null)
                node = node.left;
            else
                node = node.right;
        }
        Collections.reverse(temp);
        res.addAll(temp);

    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}