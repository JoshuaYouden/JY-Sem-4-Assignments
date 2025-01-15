import java.util.Arrays;
import java.util.Scanner;

public class MoviesArray {
    int[][] seats = null;

    public MoviesArray(int numberOfRows, int numberOfCols) {
        seats = new int[numberOfRows][numberOfCols];
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[0].length; col++) {
                seats[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public void reserveSeat(int row, int col) {
        try {
            row -= 1;
            col -= 1;
            if (seats[row][col] == Integer.MIN_VALUE) {
                seats[row][col] = 1;
                System.out.println("Seat reserved successfully!");
        } else {
            System.out.println("Seat is already taken! Suggesting alternative...");
            suggestAlternateSeat();
        }
    } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid row or column.");
        }
    }

  public void suggestAlternateSeat() {
    for (int row = 0; row < seats.length; row++) {
        for (int col = 0; col < seats[0].length; col++) {
            if (seats[row][col] == Integer.MIN_VALUE) {
                System.out.println("Seat found at row: " + (row + 1) + " and column: " + (col + 1));
                return;
            }
        }
    }
    System.out.println("No seats available.");
  }

  public void traverseSeats() {
    System.out.println("Current seating: ");
    for (int row = 0; row < seats.length; row++) {
        for (int col = 0; col < seats[0].length; col++) {
            System.out.print(seats[row][col] == Integer.MIN_VALUE ? "0 " : "1 ");
        }
        System.out.println();
    }
  }

  public void searchSeat(int row, int col) {
    try {
        row -= 1;
        col -= 1;
        if (seats[row][col] == Integer.MIN_VALUE) {
            System.out.println("Seat at row: " + row + " and column: " + col + " is empty.");
        } else {
            System.out.println("Seat at row: " + row + " and column: " + col + " is reserved.");
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Provided row or column doesn't exist.");
    }
  }

    public void cancelSeat(int row, int col) {
        try {
            row -= 1;
            col -= 1;
            if (seats[row][col] == 1) {
                seats[row][col] = Integer.MIN_VALUE;
                System.out.println("Seat canceled successfully!");
            } else {
                System.out.println("Seat is empty.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Provided seat doesn't exist.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoviesArray theater = new MoviesArray(5, 5);

        while (true) {
            System.out.println();
            System.out.println("Movie Theater Menu:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a seat");
            System.out.println("3. Display current seating");
            System.out.println("4. Search for a seat");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter row to reserve: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter column to reserve: ");
                    int col = scanner.nextInt();
                    theater.reserveSeat(row, col);
                    break;
                case 2:
                    System.out.print("Enter row to cancel: ");
                    row = scanner.nextInt();
                    System.out.print("Enter column to cancel: ");
                    col = scanner.nextInt();
                    theater.cancelSeat(row, col);
                    break;
                case 3:
                    theater.traverseSeats();
                    break;
                case 4:
                    System.out.print("Enter row to search: ");
                    row = scanner.nextInt();
                    System.out.print("Enter column to search: ");
                    col = scanner.nextInt();
                    theater.searchSeat(row, col);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}