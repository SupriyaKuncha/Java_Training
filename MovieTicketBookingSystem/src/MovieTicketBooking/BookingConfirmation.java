package MovieTicketBooking;
 
import java.sql.*;
import java.util.Scanner;
 
public class BookingConfirmation {
    public static void Bookingconfirmation() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
    Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
 
        String query = "SELECT Bookings.booking_id, Movies.title, Shows.show_time, Bookings.seats_booked " +
                       "FROM Bookings " +
                       "INNER JOIN Shows  ON Bookings.show_id = Shows.show_id " +
                       "INNER JOIN Movies ON shows.movie_id = Movies.movie_id " +
                       "WHERE Bookings.user_name = ?;";
 
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Booking Details:");
            System.out.println("---------------------------------------");
            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("booking_id"));
                System.out.println("Movie Name: " + rs.getString("title"));
                System.out.println("Show Time: " + rs.getString("show_time"));
                System.out.println("Seats Booked: " + rs.getInt("seats_booked"));
                System.out.println("---------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    	Bookingconfirmation();

    }
}
