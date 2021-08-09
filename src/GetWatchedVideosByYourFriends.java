import java.util.*;

public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int curLevel = 0;

        visited[id] = true;
        queue.offer(id);

        while(!queue.isEmpty()){
            if(curLevel == level) break;
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                for(int f : friends[cur]){
                    if(!visited[f]){
                        queue.offer(f);
                        visited[f] = true;
                    }
                }
            }
            curLevel++;
        }

        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<String> watched = watchedVideos.get(cur);
            for(String video : watched){
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        for(String video : map.keySet()){
            ans.add(video);
        }
        Collections.sort(ans, (a, b) -> (map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b)));
        return ans;

    }
}
