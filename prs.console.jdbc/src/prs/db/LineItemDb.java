package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.LineItem;

public class LineItemDb {

	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private LineItem getLineItemFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		int requestId = rs.getInt("RequestId");
		int productId = rs.getInt("ProductId");
		int quantity = rs.getInt("Quantity");

		LineItem lineItem = new LineItem(id, requestId, productId, quantity);

		return lineItem;
	}

	public List<LineItem> getAll() {
		List<LineItem> lineItemList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet lineItems = stmt.executeQuery("SELECT * FROM Actor");) {

			while (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);

				lineItemList.add(lineItem);
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

		return lineItemList;
	}

	public LineItem getLineItemByID(int id) {

		String lineItemSelect = "SELECT * FROM LINEITEM WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemSelect);) {

			ps.setInt(0, id);
			ResultSet lineItems = ps.executeQuery();

			if (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);

				lineItems.close();

				return lineItem;
			} else {
				lineItems.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);

			return null;
		}
	}

	public LineItem get(int id) {

		String lineItemSelect = "SELECT * FROM LINEITEM WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemSelect);) {

			ps.setInt(0, id);
			ResultSet lineItems = ps.executeQuery();

			if (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);

				lineItems.close();

				return lineItem;
			} else {
				lineItems.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public static boolean add(LineItem lineItem) {
		String lineItemInsert = "INSERT INTO lineItem(id, requestId, productId, quantity) VALUES (?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemInsert)) {
			ps.setInt(1, lineItem.getId());
			ps.setInt(2, lineItem.getRequestId());
			ps.setInt(3, lineItem.getProductId());
			ps.setInt(4, lineItem.getQuantity());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(int id) {
		String lineItemDelete = "DELETE FROM lineItem WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;

		}

	}

	public boolean update(LineItem lineItem) {
		String lineItemUpdate = "UPDATE lineItem SET RequestId = ?, ProductId = ?, Quantity = ? WHERE ID =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemUpdate)) {
			ps.setInt(1, lineItem.getRequestId());
			ps.setInt(2, lineItem.getProductId());
			ps.setInt(3, lineItem.getQuantity());
			ps.setInt(4, lineItem.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

}
