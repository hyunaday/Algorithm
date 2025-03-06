import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //첫째 줄에 준하의 놀람을 출력한다. 놀람은 아이디 뒤에 ??!를 붙여서 나타낸다.
        
        String lastString = "??!";
        String a = sc.next();
        
        System.out.println(a + lastString);
    }
}