public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<String> st = new Stack<>();
        String a[] = data.split(",");
        for (int i = a.length - 1; i >= 0; i--)
            st.add(a[i]);
        return f(0, st);
    }

    TreeNode f(int ind, Stack<String> st) {
        if (st.isEmpty())
            return null;
        String data = st.pop();
        if (data.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(data));
        node.left = f(ind + 1, st);
        node.right = f(ind + 2, st);
        return node;
    }
}