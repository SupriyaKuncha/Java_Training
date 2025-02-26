package MovieTicketBooking;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class DatabaseTables {
    public static void createTables() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
 
        try {
            Statement smt = conn.createStatement();
 
            String createMoviesTable = "CREATE TABLE IF NOT EXISTS Movies ("
                    + "movie_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "title VARCHAR(60) NOT NULL, "
                    + "genre VARCHAR(20), "
                    + "duration INT NOT NULL)";
 
            String createShowsTable = "CREATE TABLE IF NOT EXISTS Shows ("
                    + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "movie_id INT, "
                    + "show_time DATETIME NOT NULL, "
                    + "available_seats INT NOT NULL, "
                    + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id) ON DELETE CASCADE)";
 
            String createBookingsTable = "CREATE TABLE IF NOT EXISTS Bookings ("
                    + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "user_name VARCHAR(60) NOT NULL, "
                    + "show_id INT NOT NULL, "
                    + "seats_booked INT NOT NULL, "
                    + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (show_id) REFERENCES Shows(show_id) ON DELETE CASCADE)";
 
            String createUsersTable = "CREATE TABLE IF NOT EXISTS Users ("
                    + "user_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "username VARCHAR(60) NOT NULL, "
                    + "password VARCHAR(60) NOT NULL, "
                    + "is_admin BOOLEAN NOT NULL)";
 
            smt.executeUpdate(createMoviesTable);
            smt.executeUpdate(createShowsTable);
            smt.executeUpdate(createBookingsTable);
            smt.executeUpdate(createUsersTable);
 
            System.out.println("Tables created successfully.");
            smt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void deleteMovie(int movieId) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
 
        try {
            Statement stmt = conn.createStatement();
            String deleteMovieSQL = "DELETE FROM Movies WHERE movie_id = " + movieId;
            int rowsAffected = stmt.executeUpdate(deleteMovieSQL);
 
            if (rowsAffected > 0) {
                System.out.println("Movie deleted successfully.");
            } else {
                System.out.println("Movie ID not found.");
            }
 
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void deleteShow(int showId) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }
 
        try {
            Statement stmt = conn.createStatement();
            String deleteShowSQL = "DELETE FROM Shows WHERE show_id = " + showId;
            int rowsAffected = stmt.executeUpdate(deleteShowSQL);
 
            if (rowsAffected > 0) {
                System.out.println("Show deleted successfully.");
            } else {
                System.out.println("Show ID not found.");
            }
 
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        createTables();
    }
}
 