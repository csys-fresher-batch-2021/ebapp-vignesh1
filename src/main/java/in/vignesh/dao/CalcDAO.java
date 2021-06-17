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

	public void calculateBill(CalcBill bill)  {

		    Connection connection=null;
			PreparedStatement preparedStatement = null;
		    String type=bill.getType();
		    double unit = bill.getUnitConsumed();
	 	    double dues = bill.getDues();
            double tamt=TotalBill.getTotalBill(type,unit)+dues;
            System.out.println(tamt);
            try {
			connection=ConnectionUtil.getConnection();
			String sql = "INSERT INTO E_CALBILL (USERID,NAME,CUSTOMERID,TYPE,UNIT,ZONE,MONTH,TAMT,YEAR,STATUS,DUES) VALUES (?,?,?,?,?,?,?,?,?,?,?)  ";
		    preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bill.getUserid());
			preparedStatement.setString(2, bill.getName());
			preparedStatement.setString(3, bill.getCustomerid());
			preparedStatement.setString(4 ,bill.getType());
			preparedStatement.setDouble(5, bill.getUnitConsumed());
			preparedStatement.setString(6, bill.getZoneName());
			preparedStatement.setString(7, bill.getMonth());
			preparedStatement.setDouble(8, tamt);
			preparedStatement.setString(9, bill.getYear());
			preparedStatement.setString(10, bill.getStatus());
			preparedStatement.setDouble(11, bill.getDues());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new DBException("unable to insert records into the E_CALBILL table");
    		} finally {
    			ConnectionUtil.close(preparedStatement, connection);
    		}
			
		}

	public CalcBill payAmount(CalcBill bill2) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
        try {
    	connection = ConnectionUtil.getConnection();
		String sql = "UPDATE E_CALBILL SET AMTPAID=?,STATUS=? WHERE ID=?";
	    preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDouble(1, bill2.getPayamt());
		preparedStatement.setString(2, bill2.getStatus());
		preparedStatement.setInt(3, bill2.getCid());
		int result = preparedStatement.executeUpdate();

		if (result != 0) {
			System.out.println("valid");
		}
	}catch (SQLException e)
    {
		e.printStackTrace();
		throw new DBException("unable to Update records into the E_CALBILL table");
	} finally 
    {
		ConnectionUtil.close(preparedStatement, connection);
	}
		return bill2;
	}

	public static CalcBill getRecordById(int id)  {
		CalcBill bean = new CalcBill();
		Connection connection=null;
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
