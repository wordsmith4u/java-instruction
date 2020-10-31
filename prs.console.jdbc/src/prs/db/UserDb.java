package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.User;

public class UserDb {

	public UserDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	public List<User> getAll() {
		String selectAll = "SELECT * FROM user";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(selectAll)) {
			List<User> users = new ArrayList<>();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("Lastname");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userName, password, firstName, lastName, phone, email, isReviewer, isAdmin);

				users.add(user);

			}

			return users;

		} catch (SQLException e) {
			System.err.println("Error retrieving users. " + e);
			return null;
		}

	}

	/**
	 * Authenticates a User
	 *
	 * @param userName The user's userName
	 * @param password The user's password
	 * @throws SQLException
	 * @throws Exception
	 * @returns The matching User or null if no matching User found
	 */
	public User authenticateUser(String userName, String password) throws SQLException {

		String selectByUserAndPass = "SELECT * FROM prs.user WHERE UserName = ? AND Password = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(selectByUserAndPass);) {
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("ID");
				String userNameFromDb = rs.getString("UserName");
				String passwordFromDb = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("Lastname");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("isReviewer");
				boolean isAdmin = rs.getBoolean("isAdmin");

				User user = new User(id, userNameFromDb, passwordFromDb, firstName, lastName, phone, email, isReviewer,
						isAdmin);

				return user;
			} else {
				return null;
			}
		}
	}

	public User getUserByID(int id) {

		String userSelect = "SELECT * FROM USER WHERE id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userSelect);) {

			ps.setInt(0, id);
			ResultSet users = ps.executeQuery();

			if (users.next()) {
				User user = getUserFromResultSet(users);

				users.close();

				return user;
			} else {
				users.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);

			return null;
		}
	}

	public User get(int id) {

		String userSelect = "SELECT * FROM USER WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userSelect);) {

			ps.setInt(0, id);
			ResultSet users = ps.executeQuery();

			if (users.next()) {
				User user = getUserFromResultSet(users);

				users.close();

				return user;
			} else {
				users.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	private User getUserFromResultSet(ResultSet users) throws SQLException {
		int id = users.getInt("ID");
		String userName = users.getString("UserName");
		String password = users.getString("Password");
		String firstName = users.getString("FirstName");
		String lastName = users.getString("LastName");
		String phoneNumber = users.getString("PhoneNumber");
		String email = users.getString("Email");
		boolean isReviewer = users.getBoolean("IsReviewer");
		boolean isAdmin = users.getBoolean("IsAdmin");

		User user = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);

		return user;
	}

	public boolean add(User user) {
		String userInsert = "INSERT INTO user(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userInsert)) {
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getEmail());
			ps.setBoolean(8, user.isReviewer());
			ps.setBoolean(9, user.isAdmin());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean delete(int id) {
		String userDelete = "DELETE FROM user WHERE ID = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;

		}

	}

	public boolean update(User user) {
		String userUpdate = "UPDATE user SET UserName = ?, Password = ?, FirstName = ?, LastName = ?, PhoneNumber = ?, Email = ?, IsReviewer = ?, IsAdmin = ? WHERE ID =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userUpdate)) {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setInt(9, user.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

}
