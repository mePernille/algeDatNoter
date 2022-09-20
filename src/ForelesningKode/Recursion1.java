package ForelesningKode;

public class Recursion1 {

    public static void main(String[] args){
        System.out.println("Rekursjon");
        countdown(10);
        System.out.println("______");


/*
        for(int k=0; k <=5; k++){
            System.out.println(k + "! = " + factorial(k));
        }
*/
        int[] x = {1, 2, 4, 6, 9, 12, 13, 99};
        System.out.println(binarySearch(x, 100));

        for(int xi : x) System.out.println("verdi " + xi + " er i index " + binarySearch(x, xi));


    }


    public static void countdown(int n){
        /*
         Et krav til rekursiv funktion: en funktion som kalder sig selv
         1) Funktionen må ha et eller flere basistilfælde, som kan behandles uden nye rekursive kald
         2) Vi må undgå en evig rekursjon. Funktionen må kalde sig selv på tilfælde/innput som er
         'enklere' end det den blev kald med (kalder sig selv med fx n-1, i steden for n)
         Uten disse to får vi en uendelig rekursjon, aka stackOverflow
        */
        if(n==0){
            System.out.println(n + "....-lift off!!!");
                    return;
        }
        System.out.println(n + "...");
        countdown(n-1);
    }

    // Funktion Fakultet:
    public static int factorial(int n){

        if(n == 0){     // basis tilfælde
            return 1;
        }

        return n*factorial(n-1);
    }

    // Hvordan bruke rekursjon til at lave binærsøk


    public static int binarySearch(int [] x, int verdi){
        return binarySearch(x, verdi, 0, x.length-1);
    }
    public static int binarySearch( int[] x, int verdi, int v, int h) {

        if (v == h) { // basistilfælde
            return (verdi == x[v]) ? v : -v; // -v giver os indexen i minus til der hvor det tallet som vi søger efter skulle ha stået det fandtes i tabellen
            // man kunne ha skrevet -(v+1) i de tilfælde hvor man ser efter et tal fx et minus tal som burde ha stået på index 0, da må man huske at det da er indexen bare + 1 så får man -8 burde tallet ha stået på index 7
        }
            int m = (v + h) / 2;   // finn midten m

            if (verdi == x[m]) return m;

            if (verdi > x[m]) return binarySearch(x, verdi, m+1, h);
            else return binarySearch(x, verdi, v, m-1);

            // hvis x[m] == verdi, retuner m, ellers rekursjon/binærsøk(x, verdi, m+1, h)
        }
    }
