import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

import java.util.Scanner;

class Gragjanin {
    public String imePrezime;
    public int lKarta;
    public int pasos;
    public int vozacka;

    Gragjanin(String imePrezime,int lKarta, int pasos, int vozacka) {
        this.imePrezime=imePrezime;
        this.lKarta=lKarta;
        this.pasos=pasos;
        this.vozacka=vozacka;
    }
    public String getImePrezime() {
        return imePrezime;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
}
 class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

interface Queue<E> {
    public boolean isEmpty ();
    public int size ();
    public E peek ();
    public void clear ();
    public void enqueue (E x);
    public E dequeue ();
}
class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}

public class Exercise {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedQueue<Gragjanin> personalID = new LinkedQueue<>();
        LinkedQueue<Gragjanin> passports = new LinkedQueue<>();
        LinkedQueue<Gragjanin> drivingLicence = new LinkedQueue<>();
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int i=0;i<N;i++) {
            String ime = br.readLine();
            int lKarta = Integer.parseInt(br.readLine());
            int pasos = Integer.parseInt(br.readLine());
            int vozacka = Integer.parseInt(br.readLine());
            Gragjanin licnost = new Gragjanin(ime,lKarta,pasos,vozacka);

            if(lKarta==1) {
                personalID.enqueue(licnost);
            }
            else if (pasos==1) {
                passports.enqueue(licnost);
            }
            else if (vozacka==1) {
                drivingLicence.enqueue(licnost);
            }
        }
        while(!personalID.isEmpty()) {
            if(personalID.peek().vozacka==0 && personalID.peek().pasos==0) {
                System.out.println(personalID.dequeue().imePrezime);
            }
            else if(personalID.peek().pasos==1) {
                passports.enqueue(personalID.dequeue());
            }
            else if(personalID.peek().vozacka==1) {
                drivingLicence.enqueue(personalID.dequeue());
            }
        }
        while(!passports.isEmpty()) {
            if(passports.peek().vozacka==0) {
                System.out.println(passports.dequeue().imePrezime);
            }
            else {
                drivingLicence.enqueue(passports.dequeue());
            }
        }
        while (!drivingLicence.isEmpty()) {
            System.out.println(drivingLicence.dequeue().imePrezime);
        }
    }
}

