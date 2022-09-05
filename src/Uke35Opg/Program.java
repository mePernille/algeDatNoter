package Uke35Opg;

public class Program {

    public static void main(String[] args) {

        int[] a = Tabell.randPerm(10);  // en tilfældig tabel
        int[] b = Tabell.nestMaks(a); // metoden returnere en tabel

        int m = b[0], nm = b[1]; // sætter m til at være maks værdi og nm til at være nestmaks

        Tabell.skrivln(a,0,a.length);

        System.out.print("største(" + a[m] + ") har position " + m );
        System.out.println(", næst største(" + a[nm] + ") har position " + nm);

    }
}
