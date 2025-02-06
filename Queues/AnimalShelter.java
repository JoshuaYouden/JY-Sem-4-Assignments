package Queues;

public class AnimalShelter {
    private int[] arr;
    private int backOfQueue;
    private int frontOfQueue;
    private int numberOfAnimals;

    public AnimalShelter(int size) {
        this.arr = new int[size];
        this.backOfQueue = -1;
        this.frontOfQueue = -1;
        this.numberOfAnimals = 0;
        System.out.println("Queue for animal shelter created with a size of " + size);
    }

    public boolean isFull() {
        if (backOfQueue == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return (numberOfAnimals == 0);
    }

    public void enQueue(int animals) {
        if (isFull()) {
            System.out.println("The Queue is full, sorry!");
        } else if (isEmpty()) {
            frontOfQueue = 0;
            backOfQueue++;
            arr[backOfQueue] = animals;
            System.out.println("Inserted " + animals + " to the Queue!");
        } else {
            backOfQueue++;
            numberOfAnimals++;
            arr[backOfQueue] = animals;
            System.out.println("Inserted " + animals + " to the Queue!");
        }
    }

    public int deQueue() {
        int result = 0;
        if (isEmpty()) {
            System.out.println("The Queue is empty.");
        } else {
            result = arr[frontOfQueue];
            frontOfQueue++;
            if (frontOfQueue > backOfQueue) {
                frontOfQueue = backOfQueue = -1;
            }
            numberOfAnimals--;
        }
        return result;
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[frontOfQueue];
        } else {
            System.out.println("The Queue is empty.");
            return -1;
        }
    }

    public void deleteQueue() {
        arr = null;
        System.out.println("Queue has been deleted.");
    }
}
