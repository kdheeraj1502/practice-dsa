package bit.manupulation;

public class SquareOfNumber {

    static int square(int n)
    {
        if (n == 0)
            return 0;
        if (n < 0)
            n = -n;
        int x = n >> 1;
        // n = 2x => x =>  n/2;
        // n2 = 4x2 => 4 * n2/4
        // n = 2x + 1 =>   x = (n - 1)/2;
        // n2 = 4x2 + 4x + 1
        if (n % 2 != 0) {
            int sqr = square(x);
            int first = (sqr << 2);
            int second = (x << 2) + 1;
            return first + second;
        }
        else{
            int sqr = square(x);
            int num1 = sqr << 2;
            return num1;
        }

    }

    public static void main(String[] args) {
        System.out.println(square1(5));
    }
    /**
 0101
     5 * 2^0 + 5 * 4
     */
    static int square1(int n)
    {
        int x = n;
        int ans = 0;
        int i = 0;
        while(x > 0){
            if((x & 1) != 0){
                    ans += n << i;
            }
            x >>=1;
            i++;
        }
        return ans;
    }

    public static int calculateSquare(int num)
    {
        int input = num;
        if(num < 0){
            input = -num;
        }
        int ans = 0;
        for(int i = 0; i < input; i++){
            ans += input;
        }
        return ans;
    }

    static int squareRec(int n)
    {
        return squareRec(n );
    }
}
