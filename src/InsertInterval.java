import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        boolean mergeStart = false;
        boolean mergeEnd = false;
        int start = newInterval[0];
        int end = newInterval[1];
        int insertStart = 0;
        int insertEnd = 0;
        int[] insert;
        int i = 0;
        while (start > intervals[i][0]) {
            insertStart = i;
            i++;
        }
        i = 0;

        while (end > intervals[i][1]) {
            insertEnd = i;
            i++;
        }
        // adjust

        if (intervals[insertStart][1] >= start) {
            mergeStart = true;
        }



        if (insertEnd < len - 1 && intervals[insertEnd + 1][1] <= end) {
            mergeEnd = true;
        }
        if (mergeStart && mergeEnd) {

        }

        System.out.println(insertStart);
        System.out.println(mergeStart);
        System.out.println(insertEnd);
        System.out.println(mergeEnd);

        int[][] left = Arrays.copyOfRange(intervals, 0, insertStart);
        int[][] right = Arrays.copyOfRange(intervals, insertEnd, len);

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return intervals;

    }
}
