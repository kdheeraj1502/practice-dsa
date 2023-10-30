public class SingletoneEx {

    private static SingletoneEx object = null;

    private SingletoneEx(){

    }

    public static SingletoneEx getInstance(){
        if(object==null){
            object =  new SingletoneEx();
        }
        return object;
    }

    public static void main(String[] args) {
        SingletoneEx obj = SingletoneEx.getInstance();
    }
}
