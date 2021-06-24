package in.vignesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vignesh.exception.DBException;
import in.vignesh.model.Unit;
import in.vignesh.util.ConnectionUtil;

public class PriceListDAO {
	private PriceListDAO() {

	}

	public static List<Unit> getAllList() {
		List<Unit> numberOfList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from Pricing_List";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String type = rs.getString("type");
				double minUnit = rs.getDouble("min_unit");
				double maxUnit = rs.getDouble("max_unit");
				double price = rs.getDouble("price");
				Unit newUnit = new Unit(type, minUnit, maxUnit, price);
				numberOfList.add(newUnit);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch data");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

		return numberOfList;

	}
}
