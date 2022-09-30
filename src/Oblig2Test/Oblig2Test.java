package Oblig2Test;

public class Oblig2Test {

    class Node {
        int value; // data, i dettte tilfælde en int
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head, tail = null;

    public void addNode(int value){
        // create new node
        Node nyNode = new Node(value);

        if(head == null){
            head = tail = nyNode;

            head.prev = null;

            tail.next = null;
        }
        else{
            tail.next = nyNode;

            nyNode.prev = tail;

            tail = nyNode;

            tail.next = null;
        }
    }

    // denne metode vil printe ud listen af noder

    public void display() {
        Node current = head;
        if(head == null){
            System. out.println("listen er tom");
            return;
        }
        System.out.println("Dobbeltlenket liste: ");
        while(current != null){
            // printer ud hver node 'by incrementing the pointer'

            System.out.println(current.value + " ");
            current = current.next;
        }
    }

    Node position(Node head, int index) { // iterativ fordi vi bruger en for løkke(?)
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    /*
    if()
            assert(size ==0)
            ?(first ==null&&last ==null)
            :(first.prev ==null&&last.next ==null);
    LinkedList =
*/
}
