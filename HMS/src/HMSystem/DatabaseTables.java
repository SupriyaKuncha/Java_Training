package HMSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {
	
	public static void createTables() throws SQLException {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database Connection Failed");
			return;
		}
		try {
			Statement stmt = conn.createStatement();
			
			
			 String patientTable = "CREATE TABLE IF NOT EXISTS Patient (" +
		                "id INT AUTO_INCREMENT PRIMARY KEY, " +
		                "first_name VARCHAR(50), " +
		                "last_name VARCHAR(50), " +
		                "age INT, " +
		                "gender VARCHAR(10), " +
		                "contact_number VARCHAR(15)" +
		                ")";
			 
			 String doctorTable = "CREATE TABLE IF NOT EXISTS Doctor (" +
		                "id INT AUTO_INCREMENT PRIMARY KEY, " +
		                "name VARCHAR(100), " +
		                "speciality VARCHAR(100), " +
		                "contact VARCHAR(15)" +
		                ")";
			 
			 String appointmentTable = "CREATE TABLE IF NOT EXISTS Appointment (" +
		                "id INT AUTO_INCREMENT PRIMARY KEY, " +
		                "patient_id INT, " +
		                "doctor_id INT, " +
		                "appointment_date DATE, " +
		                "reason TEXT, " +
		                "FOREIGN KEY (patient_id) REFERENCES Patient(id), " +
		                "FOREIGN KEY (doctor_id) REFERENCES Doctor(id)" +
		                ")";
			 String staffTable = "CREATE TABLE IF NOT EXISTS Staff (" +
		                "id INT AUTO_INCREMENT PRIMARY KEY, " +
		                "name VARCHAR(100), " +
		                "role VARCHAR(50), " +
		                "contact_number VARCHAR(15)" +
		                ")";
			 
			 stmt.execute(patientTable);
	            stmt.execute(doctorTable);
	            stmt.execute(appointmentTable);
	            stmt.execute(staffTable);
	            System.out.println("Tables created successfully.");
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) throws SQLException {
		createTables();	
	}

}