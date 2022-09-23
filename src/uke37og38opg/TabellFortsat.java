package uke37og38opg;

import eksempelklasser.Maaned;
import eksempelklasser.Student;
import eksempelklasser.Studium;
import eksempelklasser.omslagsklasse;

import java.util.Arrays;
import java.util.Random;

import static Uke35Opg.Tabell.fratilKontroll;

public class TabellFortsat {
    public static int maks(double[] a) // Programkode 1.4.1 a)
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maks(char[] c) // Programkode 1.4.1 a)
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = c[0];             // største verdi

        for (int i = 1; i < c.length; i++) if (c[i] > maksverdi)
        {
            maksverdi = c[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static void bytt(Object[] a, int i, int j) { // programkode 1.4.3 d)
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static Integer[] randPermInteger(int n) { // Også programkode 1.4.3 d)
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) // Programkode 1.4.2 e)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    //Her kommer den generelle generiske metoden isteden for mange maks metoder

    public static <T extends Comparable<? super T>> int maks(T[] a){ // Programkode 1.4.2 b)
        int m = 0;      //indeks til største værdien
        T maksverdi = a[0];  // den største verdien

        for(int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0){
        maksverdi = a[i] ; // største verdi opdateres
        m = i;              // indeksen til største verdi opdateres
        }

        return m;  // returnere positionen til den største værdien
    }

    public static void skriv(Object[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        for(int i = fra; i < til-1; i++){ // skal skrive ut a med mellemrom, uten mellemrom til slut
            System.out.print(a[i] + " ");
        }
        System.out.print(a[til-1]);
    }

    public static void skriv(Object[] a){
       skriv(a,0,a.length);
    }

    public static void skrivln(Object[] a,int fra, int til){
       skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(Object[] a){
        skrivln(a,0,a.length);

    }

    public static void main(String[] args){

        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] stir = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] c = "JASMIN".toCharArray();
        String[] ss = {"Per", "Kari","Ole","Anne","Ali","Eva"};


        int l = TabellFortsat.maks(d);     // posisjonen til den største i d
        int m = TabellFortsat.maks(stir);     // posisjonen til den største i s
        int se = TabellFortsat.maks(c); // posisjonen til den største verdi i c

        // Integer[] aaa = randPermInteger(20);
        // skriv(aaa);


 /*
        double[] ddd = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] ccc = new Double[ddd.length];
        for(int i = 0; i< ddd.length; i++) ccc[i] = ddd[i];

        innsettingssortering(ccc);
        skrivln(ccc);

        TabellFortsat.innsettingssortering(ss);
        System.out.println(Arrays.toString(ss));
        */

        int[] tabellos = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        omslagsklasse.Heltall[] h = new omslagsklasse.Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new omslagsklasse.Heltall(a[i]);
        TabellFortsat.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

        for (Studium dut : Studium.values())
        {
            System.out.println(dut.toString() + " (" + dut.name() + ")");
        }

        Student[] s = new Student[5];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen

        TabellFortsat.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);

        for ( Maaned mnd : Maaned.høst()){
            System.out.println(mnd.toString() + " ( " + mnd.name() + ") " + mnd.mndnr());
        }
    }
}
