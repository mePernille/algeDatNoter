package EksamenOving;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class oving {
    public static int fjernDuplikater(int[] a){

        //Rød-sorte træer

        //venstrerotation programkode 9.2.6 e) fra kompendiet
        private static <T> Node<T> vRotasjon(Node<T> p, Node<T> q)  // venstrerotasjon
        {
            p.høyre = q.venstre;
            q.venstre = p;
            return q;
        }

        //høyreroation programkode 9.2.6 e) fra kompendiet også
        private static <T> Node<T> hRotasjon(Node<T> p, Node<T> q)  // høyrerotasjon
        {
            p.venstre = q.høyre;
            q.høyre = p;
            return q;
        }

        // metoden skal returner hvor mange forkellige verdier som er i listen, altså længden - duplikaterne

    if(a.length == 0) return 0; // ingen forskellige verdier

        int j = 1;
        for(int i = 1; i<a.length; i++){
            // hvis (a[i-1] != a[i]), tas ikke a[i] med
            if(a[i-1] != a[i]) a[j++] = a[i];

        }

        //nuller resten af tabellen
        for(int i = j; i< a.length; i++){
            a[i] = 0;
        }
        return j; // antall forskellige verdier
    }

}
