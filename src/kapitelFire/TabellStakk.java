package kapitelFire;


import java.util.Collection;
import java.util.Arrays;
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
}
