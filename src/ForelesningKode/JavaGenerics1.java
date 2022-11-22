package ForelesningKode;

public class JavaGenerics1 {

    public static void main(String[] args){

        int[] v = {2, 4, 6, 1, 7, 9, 13, 15};
        Integer[] v2 = {4, 2, 6, 89, 1, 98, 3}; // denne må brukes når man bruker compareTo
        Character[] c2 = {'A', 'F', 'E', 'L', 'P'}; // samme med denne

        System.out.println(maks(c2));

        String[] s = {"Algat", "er", "kjempe", "gøy", "!"};
        System.out.println("Det 'største' ord ligger på plads: " + maks(s));

        Pokemon[] pokemons = {
                new Pokemon("Blastoise", 10, 1000),
                new Pokemon("Pikachu", 8, 500),
                new Pokemon("Charmander", 7, 120),
                new Pokemon("Jigglypuff", 10, 5000)
        };
        System.out.println();
        System.out.println("Jeg vælger: " );
        for(Pokemon p:pokemons){
            System.out.println(p);
        }

        System.out.println();

        System.out.println("Indeks til den største: " + maks(pokemons));
        System.out.println(pokemons[maks(pokemons)] + "Jeg vælger DIG!");

    }

    public static int simpleIntervalCheck(int x){
        //returnere - 1 hvis x < 0 og 1 hvis >= =0
        int out= 0;
        if(x<5){
            out --;
        } else if (x>5){
            out++;
        }
        return out;
    }

    public static int ternaryIntervalCheck(int x){
        return (x<-5) ? -1 : (x>5) ? 1 : 0; // kraftfuld kode, men blir hurtig krøllede!! læsbar
        //return (x< 0) ? -1 : 1;
    }

    public static int maksInt(int[] x){
        // retunerer indeks til største verdi
        int mi = 0; //maksindeks
        int mv = x[mi];
        for(int i=1; i<x.length; i++){
            if(x[i]> mv){
                mi = i;
                mv = x[i];
            }
        }
        return mi;
    }
    // en maks metode som kan håndere BÅDE int og char og andre datatyper
    public static <T extends Comparable<? super  T >> int maks(T[] x){
        int mi = 0; //maksindeks
        T mv = x[mi];
        for(int i=1; i<x.length; i++){
            if(x[i].compareTo(mv)> 0){ //her må da  brukes compareTo
                mi = i;
                mv = x[i];
            }
        }
        return mi;
    }

    public static class Pokemon implements Comparable<Pokemon>{
        String name;
        Integer lvl;
        Integer hp;

        Pokemon(String name, int lvl, int hp){
            this.name = name;
            this.lvl = lvl;
            this.hp = hp;
        }

        public String toString(){
            return name + " (" + lvl + ", " + hp + ") ";
        }

        public int compareTo(Pokemon otherPokemon){
            //sammenlign lvl
            int out = this.lvl.compareTo(otherPokemon.lvl);
            if(out == 0){
                //sammenligner hp hvis lvl er likt
              out = hp.compareTo(otherPokemon.hp);
            }
            if(out == 0) {
                out = name.compareTo(otherPokemon.name);
            }
            return out;
        }
    }
}
