package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;

public class ProductDb {

	public ProductDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<Product> getAll() {
		String selectAll = "SELECT * FROM product";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<Product> products = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int vendorId = rs.getInt("VendorID");
				String partNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				Product product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

				products.add(product);

			}

			return products;

		} catch (SQLException e) {
			System.err.println("Error retrieving product. " + e);
			return null;
		}

	}

	public Product getProductByID(int id) {

		String productSelect = "SELECT * FROM PRODUCT WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productSelect);) {

			ps.setInt(0, id);
			ResultSet products = ps.executeQuery();

			if (products.next()) {
				Product product = getProductFromResultSet(products);

				products.close();

				return product;
			} else {
				products.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);

			return null;
		}
	}

	public Product get(int id) {

		String productSelect = "SELECT * FROM PRODUCT WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productSelect);) {

			ps.setInt(0, id);
			ResultSet products = ps.executeQuery();

			if (products.next()) {
				Product product = getProductFromResultSet(products);

				products.close();

				return product;
			} else {
				products.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	private Product getProductFromResultSet(ResultSet products) throws SQLException {
		int id = products.getInt("ID");
		int vendorId = products.getInt("VendorId");
		String partNumber = products.getString("PartNumber");
		String name = products.getString("Name");
		double price = products.getDouble("Price");
		String unit = products.getString("Unit");
		String photoPath = products.getString("PhotoPath");

		Product product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

		return product;
	}

	public boolean add(Product product) {
		String productInsert = "INSERT INTO product(id, vendorId, partNumber, name, price, unit, photoPath) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productInsert)) {
			ps.setInt(1, product.getId());
			ps.setInt(2, product.getVendorId());
			ps.setString(3, product.getPartNumber());
			ps.setString(4, product.getName());
			ps.setDouble(5, product.getPrice());
			ps.setString(6, product.getUnit());
			ps.setString(7, product.getPhotoPath());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(int id) {
		String productDelete = "DELETE FROM product WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;

		}

	}

	public boolean update(Product product) {
		String productUpdate = "UPDATE product SET VendorId = ?, PartNumber = ?, Name = ?, Price = ?, Unit = ?, PhotoPath = ? WHERE ID =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productUpdate)) {
			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());
			ps.setInt(7, product.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

}
