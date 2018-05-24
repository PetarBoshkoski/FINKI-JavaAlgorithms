import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise {
    public static int letters(char[] expression) {
        Stack<Character> stek = new Stack<>();
        int t=0;
        int s=0;
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == 'S' || expression[i] == 'T') {
                stek.push(expression[i]);
            }
            while (!stek.isEmpty()) {
                char bukva = stek.pop();
                if (bukva=='T') {
                    t++;
                }
                else if (bukva=='S') {
                    s++;
                }
            }
        }
        if(t%s==0) {
            return 1;
        }
        else {
            return 0;
        }
        }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char [] ss = s.toCharArray();
        System.out.println(letters(ss));
    }
}
