package DoubleLinkedList;

/**
 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node (T state) {
            this.state = state;
        }

    }

    private Node currentState;
    
    //Undo operation
    public T undo(){
       if (currentState == null || currentState.prev == null) {
           System.err.println("No states to undo");
           return null;
       }
        currentState = currentState.prev;
        return currentState.state;
    }

    //perform an operation
    public void addState (T newState) {
        Node newNode = new Node(newState);

        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
        }

        currentState = newNode;
        currentState.next = null;

    }

    //Redo Operation
    public T redo(){
        if (currentState == null || currentState.next == null) {
            System.err.println("No states to redo");
            return null;
        }

        currentState = currentState.next;
        return currentState.state;
    }

    public void printStates() {
        if (currentState == null) {
            System.out.println("No states found");
            return;
        }

        Node tempNode = currentState;
        while (tempNode.prev != null) {
            tempNode = tempNode.prev;
        }

        while (tempNode != currentState) {
            System.out.print(tempNode.state + " <> ");
            tempNode = tempNode.next;
        }

        System.out.print(currentState.state);
        System.out.println();
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");
        manager.addState("State 4");
        manager.addState("State 5");

        manager.printStates();
        manager.undo();
        manager.undo();
        manager.printStates();
        manager.redo();

    }
}
