import java.util.Arrays;
import java.util.HashMap;

/**
 * From https://www.youtube.com/watch?v=rw4s4M3hFfs
 */
public class ApartmentBlocks {
    static class ApartmentBlock {
        HashMap<String, Boolean> buildings = new HashMap<>();

        public ApartmentBlock(String[] buildings, boolean[] presence) {
            setBuildings(buildings, presence);
        }

        public void setBuildings(String[] buildings, boolean[] presence) {
            for(int i = 0; i < buildings.length; i++){
                this.buildings.put(buildings[i], presence[i]);
            }
        }
    }
    // time O(mn), space O(n)
    public static int countDistances(ApartmentBlock[] apartmentBlocks, String[] buildings){
        int n = apartmentBlocks.length;
        int[] maxDist = new int[n];
        HashMap<String, Integer> maxDistMap = new HashMap<>();
        for(String b : buildings){
            maxDistMap.put(b, Integer.MAX_VALUE);
        }
        Arrays.fill(maxDist, Integer.MIN_VALUE);

        for(int i = 0; i < n; i++){
            ApartmentBlock cur = apartmentBlocks[i];
            int curMaxDist = Integer.MIN_VALUE;

            for(String b : buildings){
                if(cur.buildings.get(b)){
                    maxDistMap.put(b, i);
                }
                curMaxDist = Math.max(curMaxDist, Math.abs(maxDistMap.get(b) - i));
            }

            maxDist[i] = curMaxDist;
        }

        int bestBlock = 0;
        int prevMin = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            ApartmentBlock cur = apartmentBlocks[i];
            int curMaxDist = Integer.MIN_VALUE;

            for(String b : buildings){
                if(cur.buildings.get(b)){
                    maxDistMap.put(b, i);
                }
                curMaxDist = Math.max(curMaxDist, Math.abs(maxDistMap.get(b) - i));
            }

            maxDist[i] = curMaxDist;
            if(maxDist[i] < prevMin){
                bestBlock = i;
                prevMin = maxDist[i];
            }
        }

        return bestBlock;
    }

    public static void main(String[] args) {
        String[] buildings = new String[] {"gym", "school", "store"};
        ApartmentBlock a1 = new ApartmentBlock(buildings, new boolean[]{false, true, false});
        ApartmentBlock a2 = new ApartmentBlock(buildings, new boolean[]{true, false, false});
        ApartmentBlock a3 = new ApartmentBlock(buildings, new boolean[]{true, true, false});
        ApartmentBlock a4 = new ApartmentBlock(buildings, new boolean[]{false, true, false});
        ApartmentBlock a5 = new ApartmentBlock(buildings, new boolean[]{false, true, true});

        ApartmentBlock[] apartmentBlocks = new ApartmentBlock[] {
            a1, a2, a3, a4, a5
        };

        System.out.println(countDistances(apartmentBlocks, buildings));

    }

}
