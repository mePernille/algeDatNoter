package treer;

import Uke35Opg.Tabell;

import java.util.Arrays;

import static java.lang.Math.abs;

public class testingHashCoding {


    public static void main(String[] args){

        // dette giver samme hashcode fordi der er 31 imellem de to stringe
        /*
        String a = "BB";
        String b = "Aa";
        System.out.println(a.hashCode());
        System.out.println();
        System.out.println(b.hashCode());
        */


        int n = 197;
        int[] hash = new int[n];

        for(int i = 0; i < 400; i++){
            String s = "A";
            if(i<100) s +=0; // så længe i er mindre en 100 må strengen ha et ekstra 0
            if(i<10) s += 0; // samme som over så længe i er mindre end 10
            s+= i;// denne lægger til i, fx blir strengen A009 når i = 9
            hash[s.hashCode() % n]++;
        }

        int m = Tabell.maks(hash); // posisjonen til den største verdi
        int maks = hash[m]; // den største verdi

        int[] frekvens = new int[maks +1];
        for(int i = 0; i<hash.length; i++) frekvens[hash[i]]++;

        System.out.println(Arrays.toString(frekvens));

        int h = -1;
        if(h<0) h = ~h;
        int p = h % 3;
        System.out.println(Integer.remainderUnsigned(-1, 3));
    }
}
