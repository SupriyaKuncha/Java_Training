package MovieTicketBooking;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
 
public class InsertData {
    public static void insertMovies() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
 
Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of movies to insert: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); 
 
        String insertMoviesSQL = "INSERT INTO Movies(title, genre, duration) VALUES (?, ?, ?)";
 
        try (PreparedStatement psmt = conn.prepareStatement(insertMoviesSQL)) {
            for (int i = 0; i < numMovies; i++) {
                System.out.println("Enter details for movie " + (i + 1) + ":");
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Genre: ");
                String genre = scanner.nextLine();
                System.out.print("Duration (in minutes): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); 
 
                psmt.setString(1, title);
                psmt.setString(2, genre);
                psmt.setInt(3, duration);
                psmt.executeUpdate();
            }
            System.out.println("Movies inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void insertShows() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed.");
            return;
        }
 
Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of shows to insert: ");
        int numShows = scanner.nextInt();
        scanner.nextLine();
 
        String insertShowsSQL = "INSERT INTO Shows (movie_id, show_time, available_seats) VALUES (?, ?, ?)";
 
        try (PreparedStatement psmt = conn.prepareStatement(insertShowsSQL)) {
            for (int i = 0; i < numShows; i++) {
                System.out.println("Enter details for show " + (i + 1) + ":");
                System.out.print("Movie ID: ");
                int movieId = scanner.nextInt();
                System.out.print("Show Time : ");
                scanner.nextLine();
                String showTimeStr = scanner.nextLine();
                LocalDateTime showTime = LocalDateTime.parse(showTimeStr.replace(" ", "T"));
                System.out.print("Available Seats: ");
                int seats = scanner.nextInt();
                scanner.nextLine(); 
 
                psmt.setInt(1, movieId);
                psmt.setTimestamp(2, Timestamp.valueOf(showTime));
                psmt.setInt(3, seats);
                psmt.executeUpdate();
            }
            System.out.println("Shows inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        insertMovies();
        insertShows();
    }
}
