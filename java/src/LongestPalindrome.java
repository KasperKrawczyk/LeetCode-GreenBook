import java.util.*;

public class LongestPalindrome {
    public  int longestPalindrome(String s){
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : map.keySet()){
            if(map.get(c) % 2 == 0){
                ans += map.get(c);
            } else {
                ans += map.get(c) - 1;
            }
        }
        return ans == s.length() ? ans : ans + 1;
    }

}
