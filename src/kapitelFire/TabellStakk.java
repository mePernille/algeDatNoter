package kapitelFire;


import eksempelklasser.Stakk;


import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java. util.StringJoiner;

public class TabellStakk<T> implements Stakk<T> {
    private T[] a;
    private int antall;

    public TabellStakk(){  // kontruktør med længde 8

        this(8);
    }

    @SuppressWarnings("unchecked")
    public TabellStakk(int lengde){
        if(lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[])new Object[lengde]; //opretter tabellen
        antall = 0; //stakken er tom
    }

    @Override
    public boolean tom() { return antall == 0;}

    @Override
    public int antall() {return antall;}

    @Override
    public void leggInn(T verdi){
        if(antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2*antall); //dobler tabellen

        a[antall ++] = verdi;
    }

    @Override
    public T kikk()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall-1];    // returnerer den øverste verdien
    }

    @Override
    public T taUt()
    {
        if (antall == 0)       // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--;             // reduserer antallet

        T temp = a[antall];   // tar var på det øverste objektet
        a[antall] = null;     // tilrettelegger for resirkulering

        return temp;          // returnerer den øverste verdien
    }

    @Override
    public void nullstill()
    {
        for(int i = 0; i < antall; i++){
            a[i] = null;
            antall = 0;
        }
    }

    @Override
    public String toString(){
        StringJoiner s = new StringJoiner(",", "[","]");
        for(int i = antall -1; i >=0; i--){
            s.add(a[i] == null? "null" : a[i].toString());
        }
        return s.toString();
        }

     public static <T> void snu(Stakk<T> A){
    
        Stakk <T> B = new TabellStakk<>();
        Stakk<T> C = new TabellStakk<>();
        while(!A.tom()) B.leggInn(A.taUt()); // legger verdierne fra A til B, de er nu i omvendt rekkefølge
        while(!B.tom()) C.leggInn(B.taUt()); // legger verdierne fra B til C
        while (!C.tom()) A.leggInn(C.taUt()); // legger verdierne tilbage i A, de er nu i omvendt rekkefølge
    }

    public static <T> void kopier(Stakk<T> A, Stakk<T> B){
        Stakk<T> hjelpeTabell = new TabellStakk<>();

    while (!A.tom()) hjelpeTabell.leggInn(A.taUt());
    while (!hjelpeTabell.tom()){
        T t = hjelpeTabell.taUt();
        A.leggInn(t);
        B.leggInn(t);
    }
    }

    //sortere sån at den mindste kommer øverst
    public static <T> void sorter(Stakk<T> A, Comparator<? super T> c){
        Stakk<T> B = new TabellStakk<T>();
        T temp;
        int n = 0;

        while(!A.tom()) {
            temp = A.taUt();
            n = 0;
            while(!B.tom() && c.compare(temp, B.taUt()) < 0){
                n++;
                A.leggInn(B.taUt());
            }
            B.leggInn(temp);
            for(int i = 0; i<n; i++) B.leggInn(A.taUt());
        }
        while(!B.tom()) A.leggInn(B.taUt());
    }

}
