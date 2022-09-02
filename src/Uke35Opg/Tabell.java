package Uke35Opg;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

    private Tabell(){}
    public static void bytt(int[] a, int i , int j){ // metode for at bytte
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n) { // metode randPerm...
        Random r = new Random(); //en generator
        int[] a = new int[n]; // en tabel med plads til n tall

        Arrays.setAll(a, i -> i + 1); // lægger ind tallene 1,2,...,n

        for(int k = n -1; k > 0; k--){ // løkke som går n- 1 gang
            int i = r.nextInt(k+1); // et tilfældig tall 0 til k
            bytt(a,k,i);
        }
        return a; // permutasjonen returneres.
    }

    public static int maksInterval(int[] a, int fra, int til){ // metode maks som tager maks fra et interval
        if(fra<0 || til > a.length || fra >= til){ // tjekker om intervallet findes i tabellen
            throw new IllegalArgumentException(" intervallet findes ikke ");
        }

        int m = fra; // m er nu indexen til største værdi i tabellen
        int maksverdi = a[fra]; // største værdi i tabellen

        for(int i = fra + 1; i < til; i++){
            if(a[i] > maksverdi){
                m = i; // indexen til den største værdien opdateres
                maksverdi = a[m]; // den største værdien opdateres
            }
        }
        return m; // retunerer positionen til den største værdien
    } // maksInterval slut

    public static int maks(int[] b){   // metode maks som tager maks fra en tabel
        return maksInterval(b, 0, b.length); // kalder den anden maks metode
    }

    public static int minInterval (int[] a, int fra, int til) {    //metode min i et bestemt interval
        if(fra<0 || til > a.length || fra >= til){ // tjekker om intervallet findes i tabellen
            throw new IllegalArgumentException(" intervallet findes ikke ");
        }
        int min = fra; // min er nu indexen til mindste værdi i tabellen
        int minverdi = a[fra]; // den mindste værdi i tabellen

        for(int i = fra + 1; i < til; i++){
            if(a[i] < minverdi){
                min = i; // opdatere indexen
                minverdi = a[min]; // opdatere selve værdien
            }
        }
        return min;
    } // minInterval slutter

    public static int min(int[] b){
        return minInterval(b, 0, b.length);
    }

    public static void skriv(int[] a, int fra, int til){
        // fratilKontroll(a.length, fra, til); //hvor kommer denne fratilKontrol fra i løsningen?
        if( til - fra > 0) System.out.print(a[fra]);
        for( int i = fra +1; i < til; i ++) System.out.print(" " + a[i]);
    }
    public static void main(String[] args) {
        // Tabell tabell = new Tabell();

        int[] a = Tabell.randPerm(20);  // en tilfældig tabel
        for(int k : a) System.out.print(k + " "); // skriver a til skærm
        int m = Tabell.min(a); // finder positionen til maksværdien

        System.out.println("Største værdien ligger på plads: " + m); // hvor skal toString metoden lægges til?
    }
}
