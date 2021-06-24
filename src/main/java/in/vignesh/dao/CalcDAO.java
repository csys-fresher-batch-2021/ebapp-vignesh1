package in.vignesh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.vignesh.exception.DBException;
import in.vignesh.model.CalcBill;
import in.vignesh.service.TotalBill;
import in.vignesh.util.ConnectionUtil;

public class CalcDAO {

	public void calculateBill(CalcBill bill) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String type = bill.getType();
		double unit = bill.getUnitConsumed();
		double dues = bill.getDues();
		double tamt = TotalBill.getTotalBill(type, unit) + dues;
		System.out.println(tamt);
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO E_CALBILL (USERID,NAME,CUSTOMERID,TYPE,UNIT,ZONE,MONTH,TAMT,YEAR,STATUS,DUES,CONSUMERNO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)  ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bill.getUserid());
			preparedStatement.setString(2, bill.getName());
			preparedStatement.setString(3, bill.getCustomerid());
			preparedStatement.setString(4, bill.getType());
			preparedStatement.setDouble(5, bill.getUnitConsumed());
			preparedStatement.setString(6, bill.getZoneName());
			preparedStatement.setString(7, bill.getMonth());
			preparedStatement.setDouble(8, tamt);
			preparedStatement.setString(9, bill.getYear());
			preparedStatement.setString(10, bill.getStatus());
			preparedStatement.setDouble(11, bill.getDues());
			preparedStatement.setString(12, bill.getConsumernumber());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to insert records into the E_CALBILL table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}

	}

	public boolean billExists(CalcBill exbill) {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isExists = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT USERID FROM E_CALBILL WHERE USERID=? AND MONTH=? AND YEAR=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, exbill.getUserid());
			pst.setString(2, exbill.getMonth());
			pst.setString(3, exbill.getYear());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				isExists = true;
			}
		} catch (SQLException e) {
			throw new DBException("unable to find the bill");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

		return isExists;
	}

	public CalcBill payAmount(CalcBill paybill) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE E_CALBILL SET AMTPAID=?,STATUS=? WHERE ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, paybill.getPayamt());
			preparedStatement.setString(2, paybill.getStatus());
			preparedStatement.setInt(3, paybill.getCid());
			int result = preparedStatement.executeUpdate();

			if (result != 0) {
				System.out.println("valid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to Update records into the E_CALBILL table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return paybill;
	}

	public static CalcBill getRecordById(int id) {
		CalcBill bean = new CalcBill();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM E_CALBILL where ID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				bean.setCid(rs.getInt(1));
				bean.setUserid(rs.getInt(2));
				bean.setUnitConsumed(rs.getInt(3));
				bean.setType(rs.getString(4));
				bean.setZoneName(rs.getString(5));
				bean.setMonth(rs.getString(6));
				bean.setPayamt(rs.getInt(7));
				bean.setName(rs.getString(8));
				bean.setCustomerid(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setYear(rs.getString(11));
				bean.setDues(rs.getDouble(12));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to fetch all records from E_CALBILL table");
		} finally {
			ConnectionUtil.close(preparedStatement, connection);
		}
		return bean;

	}

}