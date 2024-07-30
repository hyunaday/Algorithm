import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        char[] text = sc.next().toCharArray();
        char[] newText = new char[text.length];
        // System.out.println(Arrays.toString(text));
        
        for (int i = 0; i < text.length; i++) {
            if (text[i] <= 90) {                                // 대문자 Z 의 ASCII 코드인 90 을 기준으로 이보다 작은수는 대문자.
                newText[i] = (char)(text[i] + 32);              // ASCII 코드에서 대문자와 소문자는 32 간격 차이를 갖음.
            }
            else if (text[i] >= 97) {                           // 소문자 a 의 ASCII 코드인 97 을 기준으로 이보다 큰수는 소문자.
                newText[i] = (char)(text[i] - 32);              // ASCII 코드에서 대문자와 소문자는 32 간격 차이를 갖음.
            }
        }
        // System.out.println(Arrays.toString(newText));           // TEST PRINT
        
        for (int i = 0; i < newText.length; i++) {
            System.out.print(newText[i]);
        }
    }
}