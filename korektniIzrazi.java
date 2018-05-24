import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise {
    public static boolean isGood(String expression) {
        Stack<Character> stek = new Stack<>();
        for(int i=0; i<expression.length();i++) {
            if(expression.charAt(i)=='(' || expression.charAt(i)=='{' || expression.charAt(i)=='[') {
                stek.push(expression.charAt(i));
            }
            else if (expression.charAt(i)==')') {
                if (stek.isEmpty()) {
                    return false;
                }
                if (stek.pop()!='(') {
                    return false;
                }
            }

            else if (expression.charAt(i)=='}') {
                if (stek.isEmpty()) {
                    return false;
                }
                if (stek.pop()!='{') {
                    return false;
                }
            }

            else if (expression.charAt(i)==']') {
                if (stek.isEmpty()) {
                    return false;
                }
                if (stek.pop()!='[') {
                    return false;
                }
            }
        }
        if(stek.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(isGood(s));
    }
}
