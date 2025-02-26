package MovieTicketBooking;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class ShowAvailableMovies {
    public static void displayMovies() {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
        }
 
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT movies.movie_id, movies.title, shows.show_id, shows.show_time, shows.available_seats " 
                    + "FROM movies JOIN shows ON movies.movie_id = shows.movie_id";
            ResultSet rs = stmt.executeQuery(query);
 
            System.out.println("Available Movies and Shows:");
            System.out.println("----------------------------------------");
 
            while (rs.next()) {
                System.out.println("Movie ID: " + rs.getInt("movie_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Show ID: " + rs.getInt("show_id"));
                System.out.println("Show Time: " + rs.getTimestamp("show_time"));
                System.out.println("Available Seats: " + rs.getInt("available_seats"));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        displayMovies();
    }
}

