import java.util.Scanner;

public class AirlineReservationSystem {
    private static final int MAX_SEATS = 10;
    private static boolean[] seats = new boolean[MAX_SEATS]; // false means available, true means booked

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Airline Reservation System");
            System.out.println("1. Book a seat");
            System.out.println("2. View available seats");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookSeat(scanner);
                    break;
                case 2:
                    viewSeats();
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Airline Reservation System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to book a seat
    public static void bookSeat(Scanner scanner) {
        System.out.print("Enter seat number to book (1 to " + MAX_SEATS + "): ");
        int seatNumber = scanner.nextInt() - 1; // Convert to 0-based index

        if (seatNumber >= 0 && seatNumber < MAX_SEATS) {
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;
                System.out.println("Seat " + (seatNumber + 1) + " booked successfully!");
            } else {
                System.out.println("Sorry, Seat " + (seatNumber + 1) + " is already booked.");
            }
        } else {
            System.out.println("Invalid seat number! Please choose a number between 1 and " + MAX_SEATS + ".");
        }
    }

    // Method to view available seats
    public static void viewSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    // Method to cancel a booking
    public static void cancelBooking(Scanner scanner) {
        System.out.print("Enter seat number to cancel (1 to " + MAX_SEATS + "): ");
        int seatNumber = scanner.nextInt() - 1; // Convert to 0-based index

        if (seatNumber >= 0 && seatNumber < MAX_SEATS) {
            if (seats[seatNumber]) {
                seats[seatNumber] = false;
                System.out.println("Booking for Seat " + (seatNumber + 1) + " has been canceled.");
            } else {
                System.out.println("No booking found for Seat " + (seatNumber + 1) + ".");
            }
        } else {
            System.out.println("Invalid seat number! Please choose a number between 1 and " + MAX_SEATS + ".");
        }
    }
}
