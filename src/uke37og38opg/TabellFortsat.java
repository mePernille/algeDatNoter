package uke37og38opg;

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
    public static int maks(String[] a) //Programkode 1.4.1 b)
    {
        int m = 0;                          // indeks til største verdi
        String maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    //Her kommer den generelle generiske metoden isteden for mange maks metoder

    public static <T extends Comparable<? super T>> int maks(T[] a){
        int m = 0;      //indeks til største værdien
        T maksverdi = a[0];  // den største verdien

        for(int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0){
        maksverdi = a[i] ; // største verdi opdateres
        m = i;              // indeksen til største verdi opdateres
        }

        return m;  // returnere positionen til den største værdien
    }

    public static void main(String[] args){

        int[] a = {5,2,7,3,9,1,8,4,6};
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        char[] c = "JASMIN".toCharArray();

        int l = TabellFortsat.maks(d);     // posisjonen til den største i d
        int m = TabellFortsat.maks(s);     // posisjonen til den største i s
        int se = TabellFortsat.maks(c); // posisjonen til den største verdi i c

        System.out.println(d[l] + " " + s[m] + " " + c[se]);
    }

}
