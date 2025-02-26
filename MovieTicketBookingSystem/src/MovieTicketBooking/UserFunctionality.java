package MovieTicketBooking;

import java.util.Scanner;

public class UserFunctionality {
	public static void showUserMenu(String username){
	       Scanner scanner=new Scanner(System.in);
	 
	       while(true){
	           System.out.println("User Menu:");
	           System.out.println("1. Show available movies");
	           System.out.println("2. Book ticket");
	           System.out.println("3. Booking confirmation");
	           System.out.println("4. Ticket cancellation");
	           System.out.println("5. Logout");
	           int choice=scanner.nextInt();
	           scanner.nextLine(); 
	 
	           switch(choice){
	               case 1:
	                   ShowAvailableMovies.displayMovies();
	                   break;
	               case 2:
	            	   Booking.booking();
	                   break;
	               case 3:
	                   BookingConfirmation.Bookingconfirmation();
	                   break;
	               case 4:
	                   TicketCancellation.cancelTicket();
	                   break;
	               case 5:
	                   return;
	               default:
	                   System.out.println("Invalid choice. Please try again.");
	           }
	       }
	   }
}
