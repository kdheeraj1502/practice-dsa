package recursion;

public class TowerOfHanoi {

    public static void moveDisk(char s, char d, char e, int n){
        if(n <= 0) return;
        moveDisk(s, e, d , n - 1);
        System.out.println("Move disk " + n + " From " + s + " to " + d);
        moveDisk(e, d, s , n - 1); // making  E as Source and S as destination
    }

    public static void main(String[] args) {
        moveDisk('S', 'D', 'E', 3);
    }
}
