public class InsertInterval {
    // iterative solution, O(n), time O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        int curInterval = 0;
        int insertStart = 0;
        int insertEnd = 0;
        int[][] ans;
        int i = 0;
        while (i < len && start > intervals[i][1]) {
            i++;
        }
        insertStart = i;

        while (i < len && end >= intervals[i][0]) {
            i++;
        }
        insertEnd = i;

        ans = new int[len - insertEnd + insertStart + 1][];
        // populate left
        for (curInterval = 0; curInterval < insertStart; curInterval++) {
            ans[curInterval] = new int[] {intervals[curInterval][0], intervals[curInterval][1]};
        }

        if (insertStart == insertEnd) {
            // insert newInterval inbetween left and right
            ans[curInterval] = newInterval;
        } else {
            int newInsertLeft = Math.min(newInterval[0], intervals[insertStart][0]);
            int newInsertRight = Math.max(newInterval[1], intervals[insertEnd - 1][1]);
            ans[curInterval] = new int[] {newInsertLeft, newInsertRight};
        }
        curInterval++;

        // populate right
        for (int j = insertEnd; j < len; j++) {
            ans[curInterval] = new int[] {intervals[j][0], intervals[j][1]};
            curInterval++;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                new int[] {1, 2},
                new int[] {3, 5},
                new int[] {6, 7},
                new int[] {8, 10},
                new int[] {12, 16}
        };
        int[] interval = new int[] {4, 8};
        InsertInterval ii = new InsertInterval();
        ii.insert(intervals, interval);
    }

}
