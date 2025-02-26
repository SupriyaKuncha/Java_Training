package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcCancelTicket {
	public static void storedProcedureCancel() throws SQLException {
		
	    Connection conn = DatabaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database connection failed.");
	        return;
	    }

		
	}
		public static void main(String[] args) throws SQLException {
			
		}

}
