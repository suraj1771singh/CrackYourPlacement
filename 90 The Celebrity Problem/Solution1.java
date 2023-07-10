//Four cases
/*
 case 1 : when i know j => i cannot of celeb
 case 2 : when j know i => j cannot be celeb
 case 3 : when i know j and j know i => none can be celeb
 case 4 : when both don't know each other => none can be celeb
*/
class Solution {

    int celebrity(int M[][], int n) {
        int celeb = -1;
        for (int i = 0; i < n; i++) {
            if (celeb == -1) celeb = i;
            else {
                if ((M[celeb][i] ^ M[i][celeb]) == 0) celeb = -1;
                else if (M[celeb][i] == 1) celeb = i;
            }
        }
        if (celeb == -1) return -1;
        for (int i = 0; i < n; i++) {
            if (i != celeb && (M[celeb][i] == 1 || M[i][celeb] == 0)) return -1;
        }
        return celeb;
    }
}
// Time complexity : O(n)
// Spce complexity : O(1)