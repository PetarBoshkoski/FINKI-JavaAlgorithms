
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.ArrayList;


interface Stack<E>{
    public E pop();
    public void clear();
    public E peek();
    public boolean isEmpty();
}

class SLLNode<E>{
    protected E data;
    protected SLLNode succ;
    SLLNode(){}
    SLLNode(E data, SLLNode<E> succ){
        this.data = data;
        this.succ = succ;
    }
}

class StackList<E> implements Stack{
    SLLNode<E> top;
    StackList(){
        top = null;
    }
    public void push(E data){
        SLLNode<E> ins = new SLLNode<>(data, top);
        top = ins;
    }
    public E pop(){
        if(top == null) System.out.print("Nema elementi vo stekot. ");
        E ret = top.data;
        top = top.succ;
        return ret;
    }

    public void clear(){top = null;}

    public E peek(){return top.data;}

    public boolean isEmpty(){return (top==null);}

}


public class Exercise {

    public static void revertString(String s1) {
        StackList<Character> stek = new StackList<>();
        char exp[] = s1.toCharArray();
        for (char c : exp) {
            System.out.println(c);
            stek.push(c);
        }
        while (!stek.isEmpty()) {
            System.out.println(stek.pop());
        }

    }

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int N = Integer.parseInt(s);
            String[] redovi = new String[N];
            for(int i=0;i<N;i++) {
                redovi[i]=br.readLine();
            }

            int valid;
            StackList<String> stek = new StackList<>();
            for (int i=0;i<N;i++) {
                if (redovi[i].charAt(0) == '[' && redovi[i].charAt(1)=='/') {
                    if(redovi[i].substring(2,redovi[i].length()-1).equals(stek.peek())) {
                        stek.pop();
                    }
                    else {
                        break;
                    }
                }
               else if(redovi[i].charAt(0)=='[') {
                    stek.push(redovi[i].substring(1,redovi[i].length()-1));
                    //System.out.println(stek.peek());
                }


             //   System.out.println(stek.pop());

            }
        System.out.println(stek.isEmpty());
            if(stek.isEmpty()) {
                valid=1;
            }
            else {
                valid=0;
            }
        System.out.println(valid);
        br.close();
    }
}
