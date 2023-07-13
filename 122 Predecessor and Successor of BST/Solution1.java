import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
        int successor = -1;
        int predecessor = -1;
        BinaryTreeNode<Integer> curr = root;
        ArrayList<Integer> res = new ArrayList<>();
        while (curr != null) {
            if (curr.data <= key)
                curr = curr.right;
            else {
                successor = curr.data;
                curr = curr.left;
            }
        }
        curr = root;
        while (curr != null) {
            if (curr.data >= key)
                curr = curr.left;
            else {
                predecessor = curr.data;
                curr = curr.right;
            }
        }
        successor = successor == key ? -1 : successor;
        predecessor = predecessor == key ? -1 : predecessor;
        res.add(predecessor);
        res.add(successor);
        return res;
    }
}