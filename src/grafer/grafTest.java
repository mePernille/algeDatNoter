package grafer;

import eksempelklasser.Graf;

import java.io.IOException;

public class grafTest {
  public static void main(String[] args) throws IOException {

      String url = "https://www.cs.hioa.no/~ulfu/appolonius/kap11/1/graf2.txt";
      Graf graf = new Graf(url);
      for (String node : graf)  // bruker iteratoren i grafen
      {
          System.out.println(node + " -> " + graf.kanterFra(node));
      }
  }
}
