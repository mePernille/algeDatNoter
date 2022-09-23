package eksempelklasser;

public class omslagsklasse {

    // denne helttalls klassen blir som den integreret type Integer som man vanligvis ville bruke
    public final class Heltall implements Comparable<Heltall>{
        private final int verdi; // et heltall som instansvariabel
        public Heltall(int verdi){this.verdi = verdi;} //konstruktør
        public int compareTo(Heltall h){
            return verdi < h.verdi ? -1 : (verdi == h.verdi ? 0 : 1);
        }

        public boolean equals(Object o){
            if (o == this) return true; // sammenligner med sig selv
            if(!(o instanceof Heltall)) return false; // fejl datatype
            return verdi == ((Heltall)o).verdi;
        }
        public boolean equals(Heltall h){ return verdi == h.verdi;}
        public int hashCode() { return 31 + verdi; }
        public String toString() { return Integer.toString(verdi); }

    }
}
