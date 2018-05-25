import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {
    public static int matIzraz(String expression) {
        int vkupno=0;
        String[] sobiranje = expression.split("\\+");
        for(int i=0;i<sobiranje.length;i++) {
            String [] mnozenje = sobiranje[i].split("\\*");
            long proizvod=1;
                for(int j=0;j<mnozenje.length;j++) {
                    proizvod*=Integer.parseInt(mnozenje[j]);
                }
                vkupno+=proizvod;
        }
        return vkupno;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
       // char [] ss = s.toCharArray();
        System.out.println(matIzraz(s));
    }
}
