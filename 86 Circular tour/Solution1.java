class Solution {

    int tour(int p[], int d[]) {
        // Consider first petrol pump as a starting point
        int start = 0;
        int end = 1;
        int n = d.length;
        int curr_petrol = p[start] - d[start];

        /*
         * Run a loop while all petrol pumps are not visited.
         * And we have reached first petrol pump again with 0 or more petrol
         */
        while (end != start || curr_petrol < 0) {
            // If curremt amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= p[start] - d[start];
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0)
                    return -1;
            }

            // Add a petrol pump to current tour
            curr_petrol += p[end] - d[end];

            end = (end + 1) % n;
        }

        // Return starting point
        return start;
    }
}