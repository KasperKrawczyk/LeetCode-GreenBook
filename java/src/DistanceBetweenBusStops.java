public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int ans = 0;
        int sum = 0;

        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }

        for(int i = 0; i < n; i++){
            if(i >= start && i < destination){
                ans += distance[i];
            }
            sum += distance[i];
        }
        return Math.min(ans, sum - ans);
    }

    public int distanceBetweenBusStopsModulo(int[] distance, int start, int destination) {
        return Math.min(getDistance(distance, start, destination), getDistance(distance, destination, start));
    }

    private int getDistance(int[] distance, int start, int destination){
        int ans = 0;
        int n = distance.length;

        for(int i = start; i != destination; i = (i + 1) % n){
            ans += distance[i];
        }
        return ans;
    }

}
