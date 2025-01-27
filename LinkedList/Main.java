package LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertLinkedList(1,0);
        sll.insertLinkedList(2, 1);
        sll.insertLinkedList(3, 2);
        sll.insertLinkedList(4, 3);


        sll.traverseList();
        sll.searchNode(5);
        sll.deleteNode(0);

        sll.traverseList();
    }
}
