package bit.manupulation;

public class PositionOfOnlySetBit {
    static int findPosition(int N) {
        int count = 0;
        int pos = 0;
        while(N > 0){
            if((N & 1) == 1){
                count++;
            }
            N = N >> 1;
            pos++;
        }
        return count == 1 ? pos : -1;
    }

    public static void main(String[] args) {
        System.out.println(findPosition(8));
    }
}
