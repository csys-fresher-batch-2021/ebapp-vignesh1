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

	public void addList(Unit unit) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into price_list(type,min_unit,max_unit,price)values(?,?,?,?);";
			pst = connection.prepareStatement(sql);
			pst.setString(1, unit.getType());
			pst.setDouble(2, unit.getMinUnit());
			pst.setDouble(3, unit.getMaxUnit());
			pst.setDouble(4, unit.getPrice());


			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to add data to db");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public  List<Unit> getAllList()  {
		List<Unit> numberOfList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from price_list";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String type = rs.getString("type");
				double minUnit = rs.getDouble("min_unit");
				double maxUnit = rs.getDouble("max_unit");
				double price=rs.getDouble("price");
				Unit newUnit = new Unit(type,minUnit,maxUnit,price);
				numberOfList.add(newUnit);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch data");
		}finally {
			ConnectionUtil.close(pst, connection);
		}
		return numberOfList;
	}
	
}

