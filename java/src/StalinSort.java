public class StalinSort {

    public static int[] stalinSort(int[] array){
        int prev = array[0];

        for(int i = 1; i < array.length; i++){
            if(prev < array[i]){
                prev = array[i];
            } else {
                System.out.println("Purging: " + array[i]);
                array[i] = -1;
                i++;
            }
        }

        return array;
    }

    public static void main(String[] args) {

    }

}
