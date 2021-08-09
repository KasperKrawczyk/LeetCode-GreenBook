import java.util.*;

public class Apocalypse {
    public static double runFamilies (int n){
        int boys = 0;
        int girls = 0;

        for(int i = 0; i < n; i++){
            int[] family = runFamily();
            boys += family[0];
            girls += family[1];
        }

        return girls / (double) (boys + girls);
    }

    public static int[] runFamily(){
        Random random  = new Random();

        int boys = 0;
        int girls = 0;
        while(girls == 0){
            if(random.nextBoolean()){
                girls++;
            } else {
                boys++;
            }
        }

        return new int[]{boys, girls};
    }

    public static void main(String[] args) {

    }

}
