package treer;

import java.util.Arrays;

public class HeapSort {
    public static void main(String [] args){
        int value[] = {-99, 5,9,8,3,1};

        heapsort(value);
    }

    static void heapsort(int[] value){
        System.out.println("Array før sortering" + Arrays.toString(value));
        heapify(value);
        System.out.println("Array efter heapify " + Arrays.toString(value));

        for(int i = 1; i< value.length; ++i){
            int first = 1;
            int last = value.length -i;

            System.out.println("Bytter " + first + " med " + last);

            int temp = value[first];
            value[first] = value[last];
            value[last] = temp;

            int current = first;
            int left_child = current * 2;
            int right_child = current *2 +1;
            while(true){
                //venstre barn er mindst af barna, og mindre end parent
              if(left_child<last
                      && value[left_child]< value[right_child]
                      && value[left_child] < value[current]){
                  System.out.println("bytter " + current + " med " + left_child);
                  int temp2 = value[left_child];
                  value[left_child] = value[current];
                  value[current] = temp2;
                  current = left_child;

              }
                // højre barn er mindst av barna, og mindre end parent
              if(right_child < last
                       && value[right_child] < value[left_child]
                      && value[right_child] < value[current]){
                  System.out.println("bytter " + current + " med " + right_child);
                  int temp2 = value[right_child];
                  value[right_child] = value[current];
                  value[current] = temp2;
                  current = right_child;

              }// vi har fundet rigtig plads
              else{
                  break;
              }

              left_child = current*2;
              right_child = current*2+1;

            }
        }
        System.out.println("Array efter uttak " + Arrays.toString(value));

    }
    static void heapify(int[] values) {
        // en funktion som gør om en array til et træ
        for (int i = 1; i < values.length; i++) { // starter på 1 og ikke nul

            int current = i;
            int parent = i/2;

            while(parent > 0 && values[parent] > values[current]){
                System.out.println("bytter " + current + " med " + parent);
                int temp = values[parent];
                values[parent] = values[current];
                values[current] = temp;
                current = parent;
                parent = current / 2;

            }
        }
    }
}
