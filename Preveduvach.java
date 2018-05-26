import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;
public class Exercise {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> mapa = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] makAng = s.split(" ");
            mapa.put(makAng[1],makAng[0]);
        }
        String s = new String();
        while(true) {
        s=br.readLine();
        if(s.equals("KRAJ")) break;
        if(mapa.containsKey(s)) {
            System.out.println(mapa.get(s));
        }
        else {
            System.out.println("/");
        }
        }

    }
}