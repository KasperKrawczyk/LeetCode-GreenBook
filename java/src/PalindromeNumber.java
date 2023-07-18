public class PalindromeNumber {
    // time O(n), space O(1)
    public boolean isPalindrome(int x) {
        String s = x + "";
        System.out.println(s);
        if(s.length() % 2 == 0){
            return explore(s, s.length() / 2 - 1, s.length() / 2);
        } else {
            return explore(s, s.length() / 2, s.length() / 2);
        }

    }

    private boolean explore(String s, int left, int right){

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

}
