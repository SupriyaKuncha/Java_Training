package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcCallable {
	public static void storedProcedure() throws SQLException {
	
    Connection conn = DatabaseConnection.getConnection();
    if (conn == null) {
        System.out.println("Database connection failed.");
        return;
    }


    String procedure = "CREATE PROCEDURE test(IN movieId INT, OUT movie_title VARCHAR(25)) " +
            "BEGIN " +
            "SELECT title INTO movie_title FROM movies WHERE movie_id = movieId; " +
            "END";

    Statement stmt = conn.createStatement();
    stmt.execute(procedure);
    System.out.println("Stored procedure created");
			
}
	public static void main(String[] args) throws SQLException {
		storedProcedure();
	}
		
}