package MovieTicketBooking;


import java.sql.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }
 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter movie Id: ");
            int movieId = scanner.nextInt();
 
            CallableStatement csmt = conn.prepareCall("{call test(?, ?)}");
            csmt.setInt(1, movieId);
            csmt.registerOutParameter(2, Types.VARCHAR);
 
            csmt.execute();
 
            String title = csmt.getString(2);
            System.out.println("Movie title: " + title);
            
          
            csmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
