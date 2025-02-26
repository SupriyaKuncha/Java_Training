package MovieTicketBooking;
 
import java.util.Scanner;
 
public class MovieTicketBookingApp {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	 
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
 
            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Register as admin? (yes/no): ");
                    String isAdminInput = scanner.nextLine();
                    boolean isAdmin = isAdminInput.equalsIgnoreCase("yes");
                    UserLogin.register(username, password, isAdmin);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    UserLogin.login(loginUsername, loginPassword);
                    break;
                case 3:
                    System.out.println("Welcome again");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    
            }
        }
    }
    
}