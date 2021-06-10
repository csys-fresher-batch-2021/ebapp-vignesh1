package in.vignesh.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vignesh.exception.DBException;
import in.vignesh.model.UserDetails;
import in.vignesh.util.ConnectionUtil;

public class RegistrationDao {
	/**
	 * This method is used to add user detail into the database
	 * 
	 * @param userDetail
	 */
	public void addUserDetail(UserDetails userDetail) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into user_details(name,mobile_No,consumer_No,customer_Id,user_password,confirm_password)values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, userDetail.getName());
			pst.setString(2, userDetail.getMobileNo());
			pst.setString(3, userDetail.getConsumerNumber());
			pst.setString(4, userDetail.getCustomerId());
			pst.setString(5, userDetail.getPassword());
			pst.setString(6, userDetail.getConfirmPassword());
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to add records into the database");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * This method is used to fetch all the records from the database
	 * 
	 * @return
	 */
	public List<UserDetails> getAllUser() {
		List<UserDetails> user = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from user_details";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String mobileNo = rs.getString("mobile_No");
				String consumerNo = rs.getString("consumer_No");
				String customerId = rs.getString("customer_Id");
				String password = rs.getString("user_password");
				String confirmPassword = rs.getString("confirm_password");
				UserDetails userDetails = new UserDetails(name, mobileNo, consumerNo, customerId, password,
						confirmPassword);
				user.add(userDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch all records from database");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return user;
	}

}
