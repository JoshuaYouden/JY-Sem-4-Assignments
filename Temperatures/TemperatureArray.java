import java.util.Arrays;
import java.util.Scanner;

public class TemperatureArray {
    int[] temperatures;

    public TemperatureArray(int size) {
        temperatures = new int[size];
        for (int i = 0; i < size; i++) {
            temperatures[i] = Integer.MIN_VALUE;
        }
    }

    public void insertTemperature(int index, int value) {
        try {
            if (temperatures[index] == Integer.MIN_VALUE) {
                temperatures[index] = value;
                System.out.println("Temperature inserted successfully at index " + index);
            } else {
                System.out.println("The location is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access the array.");
        }
    }

    public double calculateAverage() {
        int sum = 0;
        int count = 0;
        for (int temp : temperatures) {
            if (temp != Integer.MIN_VALUE) {
                sum += temp;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }

    public int countAboveAverage(double average) {
        int count = 0;
        for (int temp : temperatures) {
            if (temp != Integer.MIN_VALUE && temp > average) {
                count++;
            }
        }
        return count;
    }

    public void displayTemperatures() {
        System.out.println("Temperatures: " + Arrays.toString(temperatures));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the number of temperature readings: ");
        int size = scanner.nextInt();

        TemperatureArray tempArray = new TemperatureArray(size);

        for (int i = 0; i < size; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            int value = scanner.nextInt();
            tempArray.insertTemperature(i, value);
        }


        double average = tempArray.calculateAverage();
        System.out.println("Average temperature: " + average);

        int aboveAverageCount = tempArray.countAboveAverage(average);
        System.out.println("Number of days above the average temperature: " + aboveAverageCount);

        tempArray.displayTemperatures();

        scanner.close();
    }
}

