package tree;


public class FindClosest {
    public static int findClosestValueInBst(BST tree, int target) {
        int result[] = new int[1];
        int diff [] =  {Integer.MAX_VALUE};
        findClosest(tree, target, diff, result);

        return result[0];
    }

    public static void findClosest(BST root, int target, int diff[],
                                   int result[]){
        if(root != null){
            if(target <= root.value){
                int sub = Math.abs(root.value - target);
                if(diff[0] > sub){
                    result[0] = root.value;
                    diff[0] = sub;
                }
                findClosest(root.left, target, diff, result);
            } else{
                int sub = Math.abs(root.value - target);
                if(diff[0] > sub){
                    result[0] = root.value;
                    diff[0] = sub;
                }
                findClosest(root.right, target, diff, result);
            }
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new FindClosest.BST(10);
        root.left = new FindClosest.BST(5);
        root.left.left = new FindClosest.BST(2);
        root.left.left.left = new FindClosest.BST(1);
        root.left.right = new FindClosest.BST(5);
        root.right = new FindClosest.BST(15);
        root.right.left = new FindClosest.BST(13);
        root.right.left.right = new FindClosest.BST(14);
        root.right.right = new FindClosest.BST(22);

        int expected = 13;
        int actual = FindClosest.findClosestValueInBst(root, 12);
        System.out.println(actual);
    }
}
