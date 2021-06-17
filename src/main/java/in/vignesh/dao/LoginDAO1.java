package in.vignesh.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.vignesh.exception.DBException;
import in.vignesh.model.UserBean;
import in.vignesh.util.ConnectionUtil;

public class LoginDAO1 {
	
	public String authenticateUser(UserBean bean) throws SQLException {
		String customerId=bean.getCustomerId();
		String password=bean.getPassword();
		System.out.println(customerId+password);
		Connection  con=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String custId="";
		String pass="";
		int role;
		try {
		 con=ConnectionUtil.getConnection();
		 statement=con.createStatement();
		 resultSet=statement.executeQuery("SELECT *FROM E_USER WHERE CUSTOMERID='"+customerId+"' AND PASSWORD='"+password+"'");
		while(resultSet.next())
		{
			custId=resultSet.getString("customerId");
			pass=resultSet.getString("password");
			role=resultSet.getInt("roleid");
			
			System.out.println(custId+pass+role);
			if(customerId.equals(custId) && password.equals(pass) && role==1)
			{
				return "ADMIN_ROLE";
			}	
			else if(customerId.equals(custId) && password.equals(pass) && role==2)
			{
				return "USER_ROLE";
			}
		}
		return "INVALID";

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch record from database");
		}
		 finally {
				ConnectionUtil.close(statement, con);
		}
	}
}
