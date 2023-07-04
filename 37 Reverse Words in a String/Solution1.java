class Solution {
    public String reverseWords(String s) {
        String a[] = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i].isEmpty())
                continue;
            str.append(a[i] + " ");
        }
        return str.toString().trim();
    }
}