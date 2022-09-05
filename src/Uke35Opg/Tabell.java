package Uke35Opg;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {
    }

    public static void bytt(int[] a, int i, int j) { // metode for at bytte
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) { // metode randPerm...
        Random r = new Random(); //en generator
        int[] a = new int[n]; // en tabel med plads til n tall

        Arrays.setAll(a, i -> i + 1); // lægger ind tallene 1,2,...,n

        for (int k = n - 1; k > 0; k--) { // løkke som går n- 1 gang
            int i = r.nextInt(k + 1); // et tilfældig tall 0 til k
            bytt(a, k, i);
        }
        return a; // permutasjonen returneres.
    }

    public static int maksInterval(int[] a, int fra, int til) { // metode maks som tager maks fra et interval

        if (a == null) throw new NullPointerException("tabellen er tom/null!");

        fratilKontroll(a.length, fra, til);

        int m = fra; // m er nu indexen til største værdi i tabellen
        int maksverdi = a[fra]; // største værdi i tabellen

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i; // indexen til den største værdien opdateres
                maksverdi = a[m]; // den største værdien opdateres
            }
        }
        return m; // retunerer positionen til den største værdien
    } // maksInterval slut

    public static int maks(int[] b) {   // metode maks som tager maks fra en tabel
        return maksInterval(b, 0, b.length); // kalder den anden maks metode
    }

    public static int[] nestMaks(int[] a)  // finder næststørste og største værdi i tabellen
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maksInterval(a, 1, n);                  // leter i a[1:n>
        } else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maksInterval(a, 0, n - 1);              // leter i a[0:n-1>
        } else {
            int mv = maksInterval(a, 0, m);              // leter i a[0:m>
            int mh = maksInterval(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[]{m, nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks

    public static int minInterval(int[] a, int fra, int til) {    //metode min i et bestemt interval
        if (fra < 0 || til > a.length || fra >= til) { // tjekker om intervallet findes i tabellen
            throw new IllegalArgumentException(" intervallet findes ikke ");
        }
        int min = fra; // min er nu indexen til mindste værdi i tabellen
        int minverdi = a[fra]; // den mindste værdi i tabellen

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                min = i; // opdatere indexen
                minverdi = a[min]; // opdatere selve værdien
            }
        }
        return min;
    } // minInterval slutter

    public static int min(int[] b) {
        return minInterval(b, 0, b.length);
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) throw new ArrayIndexOutOfBoundsException("fra(" + fra + ")er negativ!"); // fra er negativ

        if (til > tablengde)
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengden (" + tablengde + ")"); // til er udenfor tabellen

        if (fra > til)
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        if (fra == til) throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - et tomt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0) throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde) throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde" + tablengde + ")");

        if (v > h + 1) throw new ArrayIndexOutOfBoundsException((" v = " + v + ", h = " + h));
    }

    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    public static void skrivln(int[] a, int fra, int til) {
        fratilKontroll(a.length, fra, til);
        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void skriv(char[] c, int fra, int til) {
        fratilKontroll(c.length, fra, til);
        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
    }

    public static void skrivln(char[] c, int fra, int til) {
        fratilKontroll(c.length, fra, til);
        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
        System.out.println();
    }

}