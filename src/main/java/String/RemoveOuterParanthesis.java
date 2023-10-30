package String;

public class RemoveOuterParanthesis {

    public static void main(String[] args) {

        String str = "((()))(())()";
        StringBuilder ans = new StringBuilder();
        int startIdx = 0;
        int openCount = 0;

        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('){
                openCount++;
            } else if(ch==')'){
                openCount--;
            }

            if(openCount == 0){
                ans.append(str, startIdx+1 , i);
                startIdx = i+1;
            }
        }

        System.out.println(ans);
    }
}
