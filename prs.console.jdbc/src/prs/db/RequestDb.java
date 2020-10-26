package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Request;

public class RequestDb {

	public RequestDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<Request> getAll() {
		String selectAll = "SELECT * FROM request";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<Request> requests = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int userId = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				String dateNeeded = rs.getString("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				String submittedDate = rs.getString("SubmittedDate");
				String reasonForRejection = rs.getString("ReasonForRejection");

				Request request = new Request(id, userId, description, justification, dateNeeded, deliveryMode, status,
						total, submittedDate, reasonForRejection);

				requests.add(request);

			}

			return requests;

		} catch (SQLException e) {
			System.err.println("Error retrieving users. " + e);
			return null;
		}

	}

	public Request getRequestByID(int id) {

		String requestSelect = "SELECT * FROM REQUEST WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestSelect);) {

			ps.setInt(0, id);
			ResultSet requests = ps.executeQuery();

			if (requests.next()) {
				Request request = getRequestFromResultSet(requests);

				requests.close();

				return request;
			} else {
				requests.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);

			return null;
		}
	}

	public Request get(int id) {

		String requestSelect = "SELECT * FROM REQUEST WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestSelect);) {

			ps.setInt(0, id);
			ResultSet requests = ps.executeQuery();

			if (requests.next()) {
				Request request = getRequestFromResultSet(requests);

				requests.close();

				return request;
			} else {
				requests.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	private Request getRequestFromResultSet(ResultSet requests) throws SQLException {
		int id = requests.getInt("ID");
		int userId = requests.getInt("UserID");
		String description = requests.getString("Description");
		String justification = requests.getString("Justification");
		String dateNeeded = requests.getString("DateNeeded");
		String deliveryMode = requests.getString("DeliveryMode");
		String status = requests.getString("Status");
		double total = requests.getDouble("Total");
		String submittedDate = requests.getString("SubmittedDate");
		String reasonForRejection = requests.getString("ReasonForRejection");

		Request request = new Request(id, userId, description, justification, dateNeeded, deliveryMode, status, total,
				submittedDate, reasonForRejection);

		return request;
	}

	public boolean add(Request request) {
		String requestInsert = "INSERT INTO request(id, userId, description, jsutification, dateNeeded, deliveryMode, status, total, submittedDate, reasonForRejection) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestInsert)) {
			ps.setInt(1, request.getId());
			ps.setInt(2, request.getUserId());
			ps.setString(3, request.getDescription());
			ps.setString(4, request.getJustification());
			ps.setString(5, request.getDateNeeded());
			ps.setString(6, request.getDeliveryMode());
			ps.setString(7, request.getStatus());
			ps.setDouble(8, request.getTotal());
			ps.setString(9, request.getSubmittedDate());
			ps.setString(10, request.getReasonForRejection());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(int id) {
		String requestDelete = "DELETE FROM request WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;

		}

	}

	public boolean update(Request request) {
		String requestUpdate = "UPDATE request SET UserId = ?, Description = ?, Justification = ?, DateNeeded = ?, DeliveryMode = ?, Status = ?, Total = ?, SubmittedDate = ?, ReasonForRejection = ? WHERE ID =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestUpdate)) {
			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getDescription());
			ps.setString(3, request.getJustification());
			ps.setString(4, request.getDateNeeded());
			ps.setString(5, request.getDeliveryMode());
			ps.setString(6, request.getStatus());
			ps.setDouble(7, request.getTotal());
			ps.setString(8, request.getSubmittedDate());
			ps.setString(9, request.getReasonForRejection());
			ps.setInt(10, request.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

}
