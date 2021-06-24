package in.vignesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.vignesh.exception.DBException;
import in.vignesh.model.UserBean;
import in.vignesh.util.ConnectionUtil;

public class LoginDAO {
	private LoginDAO() {

	}

	public String authenticateUser(UserBean bean) throws SQLException {
		String customerId = bean.getCustomerId();
		String password = bean.getPassword();
		System.out.println(customerId + password);
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT*FROM E_USER  E_USER WHERE CUSTOMERID='" + customerId + "' AND PASSWORD='" + password
					+ "'";
			statement = con.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String custId = resultSet.getString("customerId");
				String pass = resultSet.getString("password");
				int role = resultSet.getInt("roleid");

				System.out.println(custId + pass + role);
				if (customerId.equals(custId) && password.equals(pass) && role == 1) {
					return "ADMIN_ROLE";
				} else if (customerId.equals(custId) && password.equals(pass) && role == 2) {
					return "USER_ROLE";
				}
			}
			return "INVALID";

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch record from database");
		} finally {
			ConnectionUtil.close(statement, con);
		}
	}
}