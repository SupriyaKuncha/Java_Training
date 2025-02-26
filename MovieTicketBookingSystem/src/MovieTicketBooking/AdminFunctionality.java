package MovieTicketBooking;
 
import java.util.Scanner;
 
public class AdminFunctionality {
    public static void showAdminMenu() {
Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("\n====== Admin Menu ======");
            System.out.println("1. Create Tables");
            System.out.println("2. Insert Movies");
            System.out.println("3. Insert Shows");
            System.out.println("4. Delete Movie");
            System.out.println("5. Delete Show");
            System.out.println("6. Exit from admin menu");
            System.out.print("Enter your choice: ");
 
            int choice = scanner.nextInt();
            scanner.nextLine();
 
            switch (choice) {
                case 1:
                    DatabaseTables.createTables();
                    break;
                case 2:
                    InsertData.insertMovies();
                    break;
                case 3:
                    InsertData.insertShows();
                    break;
                case 4:
                    System.out.print("Enter Movie ID to delete: ");
                    int movieId = scanner.nextInt();
                    scanner.nextLine(); 
                    DatabaseTables.deleteMovie(movieId);
                    break;
                case 5:
                    System.out.print("Enter Show ID to delete: ");
                    int showId = scanner.nextInt();
                    scanner.nextLine(); 
                    DatabaseTables.deleteShow(showId);
                    break;
                case 6:
                    System.out.println("exiting from admin menue");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 
    public static void main(String[] args) {
        showAdminMenu();
    }
}
