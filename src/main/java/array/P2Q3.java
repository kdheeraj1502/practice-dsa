package array;

public class P2Q3 {

    public static int findSequence(int N){
        if(N == 1) return 1;
        int i = 1;
        int count = 1;
        while(count <= N){
            i++;
            int num = i;
            while(num % 2 == 0){
                num /= 2;
            }
            while(num % 3 == 0){
                num /= 3;
            }
            if(num == 1){
                count++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
            System.out.println(findSequence(2));
    }
}
