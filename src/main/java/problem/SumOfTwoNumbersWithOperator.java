package problem;

public class SumOfTwoNumbersWithOperator {
    public static int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        System.out.println(getSum(a, b));
    }
}
