public class LongestPalindromicSubstring {

    // time O(n^2), space O(1)
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int lenOdd = explore(s, i, i); // centre of the palindrome is an odd-length sequence of chars (1 char included)
            int lenEven = explore(s, i, i + 1); // centre of the palindrome are two identical chars
            int len = Math.max(lenOdd, lenEven);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int explore(String s, int left, int right){
        int l = left;
        int r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
