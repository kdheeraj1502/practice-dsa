public class SingletoneEx {

    private static final SingletoneEx object = null;

    private SingletoneEx(){

    }

    public static SingletoneEx getInstance(){
        if(object==null){
            return new SingletoneEx();
        }
        return object;
    }

    public static void main(String[] args) {
        SingletoneEx obj = SingletoneEx.getInstance();
    }
}
