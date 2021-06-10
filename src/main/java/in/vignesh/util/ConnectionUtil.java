 package in.vignesh.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
public class ConnectionUtil {
	private ConnectionUtil() {

	}
   static final Logger LOGGER = Logger.getLogger(ConnectionUtil.class);

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/eb_db";
		String username = "postgres";
		String password = "viki75300";
	
     	Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
		LOGGER.info("Connection Created");
		return connection;
	}

	public static void close(Statement st, Connection con) {
		try {
			if (con != null && st != null) {
				con.close();
				st.close();
				LOGGER.info("Connection Released");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	