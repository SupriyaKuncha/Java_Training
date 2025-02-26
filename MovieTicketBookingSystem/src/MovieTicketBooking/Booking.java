package MovieTicketBooking;
 
import java.sql.*;
import java.util.Scanner;
 
public class Booking {

 public static void booking() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
 
        try {
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
 
            System.out.println("Available Movies:");
            String movieQuery = "SELECT movie_id, title FROM movies";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(movieQuery);
 
            while (rs.next()) {
                System.out.println(rs.getInt("movie_id") + ". " + rs.getString("title"));
            }
 
           
            System.out.print("Enter Movie ID to book: ");
            int movieId = scanner.nextInt();
 
         
            System.out.println("Available Shows:");
            String showQuery = "SELECT show_id, show_time, available_seats FROM shows WHERE movie_id = ?";
            PreparedStatement psShow = conn.prepareStatement(showQuery);
            psShow.setInt(1, movieId);
            ResultSet rsShows = psShow.executeQuery();
 
            boolean hasShows = false;
            while (rsShows.next()) {
                hasShows = true;
                System.out.println(rsShows.getInt("show_id") + ". Show Time: " + rsShows.getTimestamp("show_time") +
                        " [ Available Seats: " + rsShows.getInt("available_seats")+ " ]");
            }
 
            if (!hasShows) {
                System.out.println("No shows available for this movie.");
                return;
            }
 
          
            System.out.print("Enter Show ID to book: ");
            int showId = scanner.nextInt();
 
            String checkSeatsQuery = "SELECT available_seats FROM shows WHERE show_id = ?";
            PreparedStatement psCheckSeats = conn.prepareStatement(checkSeatsQuery);
            psCheckSeats.setInt(1, showId);
            ResultSet rsSeats = psCheckSeats.executeQuery();
 
            int Seatsavailable = 0;
            if (rsSeats.next()) {
                Seatsavailable = rsSeats.getInt("available_seats");
            }
 
            if (Seatsavailable <= 0) {
                
                return;
            }
 

            System.out.print("Enter number of seats to book: ");
            int numSeats = scanner.nextInt();
 
            if (numSeats > Seatsavailable) {
                System.out.println("Sorry, only " + Seatsavailable + " seats are available.");
                return;
            }
 
 
            String bookQuery = "INSERT INTO bookings (user_name, show_id, seats_booked) VALUES (?, ?, ?)";
            PreparedStatement psBook = conn.prepareStatement(bookQuery);
            psBook.setString(1, userName);
            psBook.setInt(2, showId);
            psBook.setInt(3, numSeats);
            psBook.executeUpdate();
 

            String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats - ? WHERE show_id = ?";
            PreparedStatement psUpdateSeats = conn.prepareStatement(updateSeatsQuery);
            psUpdateSeats.setInt(1, numSeats);
            psUpdateSeats.setInt(2, showId);
            psUpdateSeats.executeUpdate();
 
            System.out.println("Ticket booked successfully for " + userName + "!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
    public static void main(String[] args) {
    	booking();

    }
}