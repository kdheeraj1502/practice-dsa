package array;

public class FindDuplicate {
    public static int firstDuplicateValue(int[] array) {
        for(int i = 0; i < array.length; i++){
            int val = Math.abs(array[i]);
            if((array[val - 1]) < 0){
                return Math.abs(array[i]);
            }
            array[val - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 2, 1, 5, 3, 3, 2, 4 };
        System.out.println(firstDuplicateValue(array));
    }
}
