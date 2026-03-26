package dao;

import db.DBConnection;
import java.sql.*;

public class ComplaintDAO {

    // Add Complaint
    public void addComplaint(String name, String issue) {
        String query = "INSERT INTO complaints(name, issue) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setString(2, issue);
            ps.executeUpdate();
            System.out.println("Complaint registered successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Complaints
    public void viewComplaints() {
        String query = "SELECT * FROM complaints";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\n--- Complaints List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Issue: " + rs.getString("issue") +
                        " | Status: " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Status
    public void updateStatus(int id, String status) {
        String query = "UPDATE complaints SET status=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, status);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Status updated!");
            else
                System.out.println("Complaint not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Complaint
    public void deleteComplaint(int id) {
        String query = "DELETE FROM complaints WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Complaint deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}