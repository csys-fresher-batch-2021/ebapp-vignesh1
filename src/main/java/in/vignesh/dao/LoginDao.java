package in.vignesh.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.vignesh.exception.DBException;
import in.vignesh.util.ConnectionUtil;
public class LoginDao {
	
		public boolean loginDao(String customerId, String password) {

		boolean validLogin=false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection=ConnectionUtil.getConnection();
			String sql="select * from user_details where customer_Id=? AND user_password=?";
			pst=connection.prepareStatement(sql);
			pst.setString(1, customerId);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				validLogin=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch record from database");
		}
		 finally {
				ConnectionUtil.close(pst, connection);
		}

		return validLogin;
	}
}

