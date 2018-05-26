import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;
public class Exercise {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> mapa = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String imePass = br.readLine();
            String[] razdeliHash = imePass.split(" ");
            mapa.put(razdeliHash[0], razdeliHash[1]);
        }
        String[] novVlez;
        while (true) {
            novVlez = br.readLine().split(" ");
            if (novVlez[0].equals("KRAJ")) break;
            if(mapa.containsKey(novVlez[0]) && mapa.get(novVlez[0]).equals(novVlez[1])) {
                System.out.println("Najaven");
            }
            else
                System.out.println("Nenajaven");
                //novVlez = br.readLine().split(" ");
        }
    }
}