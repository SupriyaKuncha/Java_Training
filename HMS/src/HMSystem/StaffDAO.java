package HMSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public  void addStaff(Staff staff) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }

        String sql = "INSERT INTO Staff (name, role, contact_number) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getRole());
            pstmt.setString(3, staff.getContactNumber());
            pstmt.executeUpdate();
            System.out.println("Staff added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public List<Staff> getAllStaff() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return new ArrayList<>();
        }

        List<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Staff staff = new Staff(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("contact_number")
                );
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return staffList;
    }

    public void updateStaff(Staff staff) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }

        String sql = "UPDATE Staff SET name = ?, role = ?, contact_number = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getRole());
            pstmt.setString(3, staff.getContactNumber());
            pstmt.setInt(4, staff.getId());
            pstmt.executeUpdate();
            System.out.println("Staff updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void deleteStaff(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }

        String sql = "DELETE FROM Staff WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Staff deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
