package eksempelklasser;

import java.util.*;
import java.io.*;
import java.net.URL;

public final class Graf implements Iterable<String>  // final: skal ikke arves
{
    private static final class Node               // en indre nodeklasse
    {
        private final String navn;                  // navn/identifikator
        private final List<Node> kanter;            // nodens kanter
        private byte innkanter = 0;                 // antall innkanter
        private boolean besøkt = false;             // hjelpevariabel brukes senere
        private Node forrige = null;                // hjelpevariabel brukes senere

        private Node(String navn)                   // nodekonstruktør
        {
            this.navn = navn;                         // nodens navn
            kanter = new LinkedList<>();              // oppretter kantlisten
        }

        public String toString() { return navn; }   // nodens navn
    } // Node

    private final Map<String, Node> noder;        // en map til å lagre nodene

    public Graf() { noder = new HashMap<>(); }    // standardkonstruktør

    public boolean leggInnNode(String navn)       // ny node
    {
        if (navn == null || navn.length() == 0)
            throw new IllegalArgumentException("Noden må ha et navn!");
        if (noder.get(navn) != null) return false; // finnes navnet fra før?
        return noder.put(navn, new Node(navn)) == null;
    }

    public boolean nodeFinnes(String navn)      // finnes denne noden?
    {
        return noder.get(navn) != null;
    }


    public Iterator<String> iterator()          // klassen er iterable
    {
        return noder.keySet().iterator();
    }

    public String[] nodenavn()                 // nodenavnene som en tabell
    {
        return noder.keySet().toArray(new String[0]);
    }
    public void leggInnKant(String franode, String tilnode)
    {
        if (franode.equals(tilnode)) throw    // sjekker om de er like
                new IllegalArgumentException(franode + " er lik " + tilnode + "!");

        Node fra = noder.get(franode);  // henter franode
        if (fra == null) throw new NoSuchElementException(franode + " er ukjent!");

        Node til = noder.get(tilnode);  // henter tilnode
        if (til == null) throw new NoSuchElementException(tilnode + " er ukjent!");

        if(fra.kanter.contains(til)) throw
                new IllegalArgumentException("Kanten finnes fra før!");

        til.innkanter++;      // en ny innkant
        fra.kanter.add(til);  // legger til i kantlisten
    }

    public void leggInnKanter(String franode, String... tilnoder)
    {
        for (String tilnode : tilnoder) leggInnKant(franode, tilnode);
    }

    public String kanterFra(String node)
    {
        Node fra = noder.get(node);  // henter noden
        if (fra == null) return null;  // finnes noden?
        return fra.kanter.toString();  // listens toString-metode
    }

    public int antalNoder(){
        return noder.size();
    }

    public boolean erIsolert(String nodenavn) {

        Node p = noder.get(nodenavn);
        if(p == null) throw new NoSuchElementException(nodenavn + " er ukjent!");
        return p.kanter.size() == 0 && p.innkanter == 0;
    }

    public boolean erKant(String franode, String tilnode){


        return false;
    }


    public Graf(String url) throws IOException
    {
        this();   // standardkonstruktøren

        BufferedReader inn = new BufferedReader  // leser fra fil
                (new InputStreamReader((new URL(url)).openStream()));

        String linje;
        while ((linje = inn.readLine()) != null)
        {
            String[] navn = linje.split(" ");      // deler opp linjen

            leggInnNode(navn[0]);                  // noden kommer først

            for (int i = 1; i < navn.length; i++)  // så nodene det går kant til
            {
                leggInnNode(navn[i]);                // navnet på naboen
                leggInnKant(navn[0], navn[i]);       // legges inn som nabo
            }
        }
    }

} // Graf
