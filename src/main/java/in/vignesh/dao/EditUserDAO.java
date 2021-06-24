package in.vignesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.vignesh.exception.DBException;
import in.vignesh.model.UserBean;
import in.vignesh.util.ConnectionUtil;

public class EditUserDAO {

	public int editUser(UserBean userBean) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			int status = 0;
			String sql = "UPDATE E_USER SET NAME=?,USEREMAIL=?,USERADDRESS=?,USERPHONE=? WHERE USERID=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userBean.getName());
			preparedStatement.setString(2, userBean.getUseremail());
			preparedStatement.setString(3, userBean.getUseraddress());
			preparedStatement.setString(4, userBean.getUserphone());
			preparedStatement.setInt(5, userBean.getUserid());
			status = preparedStatement.executeUpdate();
			System.out.println(status);
			if (status != 0) {
				System.out.println(status);
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to Update records into the E_USER table");
		} finally {
			ConnectionUtil.close(preparedStatement, con);
		}
	}

	public int editMyProfile(UserBean userBean) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = ConnectionUtil.getConnection();
			int status = 0;
			String sql = "UPDATE E_USER SET NAME,USEREMAIL=?,USERADDRESS=?,USERPHONE=? WHERE USERID=?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userBean.getName());
			preparedStatement.setString(2, userBean.getUseremail());
			preparedStatement.setString(3, userBean.getUseraddress());
			preparedStatement.setString(4, userBean.getUserphone());
			preparedStatement.setInt(5, userBean.getUserid());
			status = preparedStatement.executeUpdate();
			System.out.println(status);
			if (status != 0) {
				System.out.println(status);
				return 1;
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to Update records into the E_USER table");
		} finally {
			ConnectionUtil.close(preparedStatement, con);
		}

	}

}