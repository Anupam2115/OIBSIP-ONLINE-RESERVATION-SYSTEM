import java.util.Scanner;

public class TrainReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] seats = new int[10][5];
        int choice, seatCount = 0;
        boolean isAvailable = false;

        while (true) {
            System.out.println("Welcome to train reservation system ");
            System.out.println("Press 1 to book a ticket");
            System.out.println("Press 2 to cancel a ticket");
            System.out.println("Press 3 to view available seats");
            System.out.println("Press 4 to exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your login credentials:");
                    String username = sc.next();
                    String password = sc.next();

                    if (!isValidUser(username, password)) {
                        System.out.println("Invalid username or password. Please try again.");
                        break;
                    }

                    System.out.println("(Indian Railways)Enter the number of seats you want to book:");
                    seatCount = sc.nextInt();

                    if (seatCount > 50) {
                        System.out.println("(Indian Railways)Sorry, you can only book up to 50 seats at a time.");
                        break;
                    }

                    isAvailable = checkAvailability(seats, seatCount);

                    if (isAvailable) {
                        bookSeats(seats, seatCount);
                        System.out.println("(Indian Railways)Your seats have been booked successfully!");
                        System.out.println("(Indian Railways)Your PNR number is: " + generatePNR());
                        System.out.println("Train name: SuperFast Express");
                        System.out.println("Train number: 12534");
                    } else {
                        System.out.println("(Indian Railways)Sorry, there are not enough seats available.");
                    }

                    break;

                case 2:
                    System.out.println("(Indian Railways)Enter your login credentials:");
                    username = sc.next();
                    password = sc.next();

                    if (!isValidUser(username, password)) {
                        System.out.println("Invalid username or password. Please try again.");
                        break;
                    }

                    System.out.println("Enter the PNR number of the ticket you want to cancel:");
                    String pnr = sc.next();

                    if (!isValidPNR(pnr)) {
                        System.out.println("(Indian Railways)Invalid PNR number. Please try again.");
                        break;
                    }

                    cancelTicket(pnr);
                    System.out.println("(Indian Railways)Your ticket has been cancelled successfully!");

                    break;

                case 3:
                    displayAvailability(seats);
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("(Indian Railways)Invalid choice. Please try again.");
            }
        }
    }

    public static boolean isValidUser(String username, String password) {
        // Check if the username and password are valid
        return true;
    }

    public static boolean checkAvailability(int[][] seats, int seatCount) {
        int availableSeats = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    availableSeats++;
                }
            }
        }

        return availableSeats >= seatCount;
    }

    public static void bookSeats(int[][] seats, int seatCount) {
        int bookedSeats = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    seats[i][j] = 1;
                    bookedSeats++;

                    if (bookedSeats == seatCount) {
                        return;
                    }
                }
            }
        }
    }

    public static String generatePNR() {
        // Generate a unique PNR number
        return "ABC123";
    }

    public static boolean isValidPNR(String pnr) {
        // Check if the PNR number is valid
        return true;
    }

    public static void cancelTicket(String pnr) {
        // Cancel the ticket with the given PNR number
    }

    public static void displayAvailability(int[][] seats) {
        System.out.println("Available seats:");

        for (int[] seat : seats) {
            for (int i : seat) {
                if (i == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }

            System.out.println();
        }
    }
}
