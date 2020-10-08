package com.policy.dao;

import java.sql.*;
import org.apache.log4j.Logger;
import com.policy.dbcon.DBConnection;
import com.policy.entity.Policy;

public class LICOperations {
	static Logger logger = Logger.getLogger(LICOperations.class);
	public static final String INSERT_SQL = "INSERT INTO `tbl_policy` (`PolicyName`,`PolicyHolderName`, `PolicyStartDate`,`PremiumType`, `PremiumAmt`) VALUES (?,?,?,?,?)";
	public static final String READ_SQL = "SELECT * from tbl_policy WHERE PolicyNumber = ?";
	public static final String UPDATE_SQL = "UPDATE tbl_policy SET PolicyName = ?, PolicyHolderName = ?, PolicyStartDate = ?,PremiumType = ?, PremiumAmt = ? WHERE PolicyNumber = ?";
	public static final String DELETE_SQL = "DELETE FROM tbl_policy WHERE PolicyNumber = ?";

	public int createPolicy(Policy p) {
		Connection connObj = null;
		PreparedStatement ps = null;
		try {
			connObj = DBConnection.getConnection();
			ps = connObj.prepareStatement(INSERT_SQL);
			ps.setString(1, p.getPolicyName());
			ps.setString(2, p.getPolicyHolderName());
			ps.setString(3, p.getPolicyStartDate());
			ps.setString(4, p.getPremiumType());
			ps.setFloat(5, p.getPremiumAmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			logger.info(e);
		} finally {
			if (null != ps) {
				try {
					ps.close();
					connObj.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public Policy displayPolicy(Policy p) throws SQLException {
		Connection connObj = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Policy dbPolicy = new Policy();
		try {
			connObj = DBConnection.getConnection();
			ps = connObj.prepareStatement(READ_SQL);
			ps.setInt(1, p.getPolicyNumber());
			rs = ps.executeQuery();
			if (rs.next()) {
				dbPolicy.setPolicyNumber(rs.getInt("PolicyNumber"));
				dbPolicy.setPolicyName(rs.getString("PolicyName"));
				dbPolicy.setPolicyHolderName(rs.getString("PolicyHolderName"));
				dbPolicy.setPolicyStartDate(rs.getString("PolicyStartDate"));
				dbPolicy.setPremiumType(rs.getString("PremiumType"));
				dbPolicy.setPremiumAmt(rs.getInt("PremiumAmt"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connObj != null) {
					connObj.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (ps != null) {
				ps.close();
			}
		}
		return dbPolicy;
	}

	public int updatePolicy(Policy p) {
		Connection connObj = null;
		PreparedStatement ps = null;
		try {
			connObj = DBConnection.getConnection();
			ps = connObj.prepareStatement(UPDATE_SQL);
			ps.setInt(6, p.getPolicyNumber());
			ps.setString(1, p.getPolicyName());
			ps.setString(2, p.getPolicyHolderName());
			ps.setString(3, p.getPolicyStartDate());
			ps.setString(4, p.getPremiumType());
			ps.setFloat(5, p.getPremiumAmt());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != ps) {
				try {
					ps.close();
					connObj.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public int deletePolicy(Policy p) {
		Connection connObj = null;
		PreparedStatement ps = null;
		try {
			connObj = DBConnection.getConnection();
			ps = connObj.prepareStatement(DELETE_SQL);
			ps.setInt(1, p.getPolicyNumber());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != ps) {
				try {
					ps.close();
					connObj.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
