import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> pre = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int numTaken = 0;
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            pre.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            pre.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int b = queue.poll();
            numTaken++;

            for (int a : pre.get(b)) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    queue.offer(a);
                }
            }

        }

        return numCourses == numTaken;
    }
}
