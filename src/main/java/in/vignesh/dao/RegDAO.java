package in.vignesh.dao;

import java.sql.*;

import in.vignesh.exception.DBException;
import in.vignesh.model.UserBean;
import in.vignesh.util.ConnectionUtil;

public class RegDAO {

	/* Add User By Admin */
	public int addUser(UserBean bean) {
		Connection con=null;
		PreparedStatement preparedStatement = null;
		try {
		con = ConnectionUtil.getConnection();
		String sql = "INSERT INTO E_USER (NAME,USEREMAIL,USERPHONE,CONSUMERNO,USERADDRESS,CUSTOMERID,PASSWORD,CONFIRMPASSWORD,ROLEID) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
	    preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, bean.getName());
		preparedStatement.setString(2, bean.getUseremail());
		preparedStatement.setString(3, bean.getUserphone());
		preparedStatement.setString(4, bean.getConsumernumber());
		preparedStatement.setString(5, bean.getUseraddress());
		preparedStatement.setString(6, bean.getCustomerId());
		preparedStatement.setString(7, bean.getConfirmpassword());
		preparedStatement.setString(8, bean.getPassword());
		preparedStatement.setInt(9, bean.getRoleid());
		int i = preparedStatement.executeUpdate();
		if (i == 0) {
			System.out.println("not inserted");
		} else {
			System.out.println("inserted");
		}
		int id = 0;

		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		System.out.println("Last inserted id" + id);

		return id;
		
		}catch (SQLException e)
        {
			e.printStackTrace();
			throw new DBException("unable to add records into the E_USER table");
		} finally 
        {
			ConnectionUtil.close(preparedStatement, con);
		}

	}

	public static UserBean getRecordById(int id)  {
		UserBean bean = new UserBean();
		Connection con=null;
		PreparedStatement preparedStatement = null;
		try {
		 con = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM E_USER where USERID=?";
		 preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			bean.setUserid(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setUseremail(rs.getString(3));
			bean.setUserphone(rs.getString(4));
			bean.setConsumernumber(rs.getString(5));
			bean.setUseraddress(rs.getString(6));
			bean.setCustomerId(rs.getString(7));
			bean.setConfirmpassword(rs.getString(8));
			bean.setPassword(rs.getString(9));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("unable to fetch all records from E_USER tables");
	} finally {
		ConnectionUtil.close(preparedStatement, con);
	}
	
		return bean;

	}

	

	
}
