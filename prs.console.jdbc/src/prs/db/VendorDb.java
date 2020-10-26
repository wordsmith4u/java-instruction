package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Vendor;

public class VendorDb {

	public VendorDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<Vendor> getAll() {
		String selectAll = "SELECT * FROM vendor";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<Vendor> vendors = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String code = rs.getString("Code");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				String phoneNumber = rs.getString("PhoneNumber");
				String email = rs.getString("email");

				Vendor vendor = new Vendor(id, code, name, address, city, state, zip, phoneNumber, email);
				vendors.add(vendor);

			}

			return vendors;

		} catch (SQLException e) {
			System.err.println("Error retrieving vendor. " + e);
			return null;
		}

	}

	public Vendor getVendorByID(int id) {

		String vendorSelect = "SELECT * FROM VENDOR WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorSelect);) {

			ps.setInt(0, id);
			ResultSet vendors = ps.executeQuery();

			if (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);

				vendors.close();

				return vendor;
			} else {
				vendors.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);

			return null;
		}
	}

	public Vendor get(int id) {

		String vendorSelect = "SELECT * FROM VENDOR WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorSelect);) {

			ps.setInt(0, id);
			ResultSet vendors = ps.executeQuery();

			if (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);

				vendors.close();

				return vendor;
			} else {
				vendors.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	private Vendor getVendorFromResultSet(ResultSet vendors) throws SQLException {
		int id = vendors.getInt("ID");
		String code = vendors.getString("Code");
		String name = vendors.getString("Name");
		String address = vendors.getString("Address");
		String city = vendors.getString("City");
		String state = vendors.getString("State");
		String zip = vendors.getString("Zip");
		String phoneNumber = vendors.getString("PhoneNumber");
		String email = vendors.getString("Email");

		Vendor vendor = new Vendor(id, code, name, address, city, state, zip, phoneNumber, email);

		return vendor;
	}

	public boolean add(Vendor vendor) {
		String vendorInsert = "INSERT INTO vendor(id, code, name, address, city, state, zip, phoneNumber, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorInsert)) {
			ps.setInt(1, vendor.getId());
			ps.setString(2, vendor.getCode());
			ps.setString(3, vendor.getName());
			ps.setString(4, vendor.getAddress());
			ps.setString(5, vendor.getCity());
			ps.setString(6, vendor.getState());
			ps.setString(7, vendor.getZip());
			ps.setString(8, vendor.getPhoneNumber());
			ps.setString(9, vendor.getEmail());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(int id) {
		String vendorDelete = "DELETE FROM vendor WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;

		}

	}

	public boolean update(Vendor vendor) {
		String vendorUpdate = "UPDATE vendor SET Code = ?, Name = ?, Address = ?, City = ?, State = ?, Zip = ?, PhoneNumber = ?, Email = ? WHERE ID =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorUpdate)) {
			ps.setString(1, vendor.getCode());
			ps.setString(2, vendor.getName());
			ps.setString(3, vendor.getAddress());
			ps.setString(4, vendor.getCity());
			ps.setString(5, vendor.getState());
			ps.setString(6, vendor.getZip());
			ps.setString(7, vendor.getPhoneNumber());
			ps.setString(8, vendor.getEmail());
			ps.setInt(9, vendor.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

}
