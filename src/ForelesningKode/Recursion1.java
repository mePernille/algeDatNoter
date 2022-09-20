package ForelesningKode;

public class Recursion1 {

    public static void main(String[] args){
        System.out.println("Rekursjon");
        countdown(10);
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
}
