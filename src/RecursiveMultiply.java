/**
 * From Greenbook
 */
public class RecursiveMultiply {
    // solution 1
    public static int product(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        return productRec(smaller, bigger);
    }

    private static int productRec(int smaller, int bigger){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        } else {
            return productRec(smaller - 1, bigger) + bigger;
        }
    }

    // solution 2
    public static int productDiv(int a, int b){
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        int[] dp = new int[a + 1];
        return productDivRec(dp, smaller, bigger);

    }

    public static int productDivRec(int[] dp, int smaller, int bigger){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        } else if (dp[smaller] > 0){
            return dp[smaller];
        }

        int smallerDivided = smaller >> 1;
        int half1 = productDivRec(dp, smallerDivided, bigger);
        int half2 = smaller % 2 == 1 ? productDivRec(dp, smaller - smallerDivided, bigger) : half1;

        dp[smaller] = half1 + half2;
        return dp[smaller];
    }

    // solution 3
    public int productFast(int a, int b){
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        return productFastRec(smaller, bigger);
    }

    private int productFastRec(int smaller, int bigger){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        }

        int smallerDivided = smaller >> 1;
        int half = productFastRec(smallerDivided, bigger);

        if(smaller % 2 == 1){
            return half + half + bigger; // instead of calling Rec() on the odd part, we can just add 'bigger' to doubled even part
        } else {
            return half + half;
        }
    }
}
