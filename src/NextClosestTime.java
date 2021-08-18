import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public static String nextClosestTime(String time){

        Set<Integer> digits = new HashSet<>();
        for(int i = 0; i < time.length(); i++){
            if(time.charAt(i) == ':') continue;
            int digit = time.charAt(i) - '0';

            digits.add(digit);
        }

        int minutes = Integer.parseInt(time.substring(3));
        int hours = Integer.parseInt(time.substring(0, 2));

        boolean isFound = false;
        while(!isFound){
            minutes++;
            System.out.println(hours + ":" + minutes);
            if(minutes == 60){
                hours++;
                minutes = 0;
                if(hours == 24){
                    hours = 0;
                }
            }
            if(digits.contains(minutes / 10) && digits.contains(minutes % 10) &&
            digits.contains(hours / 10) && digits.contains(hours % 10)) {
                isFound = true;
            }
        }

        String ans = "";
        ans += hours == 0 ? "00:" : hours + ":";
        ans += minutes == 0 ? "00" : minutes;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(nextClosestTime("23:59"));
    }
}
