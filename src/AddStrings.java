public class AddStrings {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        int i = n1 - 1;
        int j = n2 - 1;

        String ans = "";
        int carry = 0;

        while(i >= 0 || j >= 0){
            int curNum1Digit = i >= 0 ? num1.charAt(i) - '0' : 0;
            int curNum2Digit = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = curNum1Digit + curNum2Digit;
            sum += carry;
            carry = sum / 10;
            String insert = sum % 10 + "";
            ans = insert + ans;
            i--;
            j--;

            if(i < 0 && j < 0 && carry > 0){
                ans = carry + ans;
            }
        }
        return ans;
    }

}
