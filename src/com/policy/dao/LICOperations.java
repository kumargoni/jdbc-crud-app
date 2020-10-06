package com.policy.dao;

import java.sql.*;
import com.policy.dbcon.DBConnection;
import com.policy.entity.Policy;

public class LICOperations {
	public static final String insertPolicySql = "INSERT INTO `tbl_policy` (`PolicyName`,`PolicyHolderName`, `PolicyStartDate`,`PremiumType`, `PremiumAmt`) VALUES (?,?,?,?,?)";
	public static final String readPolicySql = "SELECT * from tbl_policy WHERE PolicyNumber = ?";
	public static final String updatePolicySql = "UPDATE tbl_policy SET PolicyName = ?, PolicyHolderName = ?, PolicyStartDate = ?,PremiumType = ?, PremiumAmt = ? WHERE PolicyNumber = ?";
	public static final String deletePolicySql = "DELETE FROM tbl_policy WHERE PolicyNumber = ?";

	public int createPolicy(Policy p) {
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertPolicySql);
			ps.setString(1, p.getPolicyName());
			ps.setString(2, p.getPolicyHolderName());
			ps.setString(3, p.getPolicyStartDate());
			ps.setString(4, p.getPremiumType());
			ps.setFloat(5, p.getPremiumAmt());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != ps) {
				try {
					int r = ps.executeUpdate();
					ps.close();
					//con.close();
					return r;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public int displayPolicy(Policy p) {
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(readPolicySql);
			ps.setInt(1, p.getPolicyNumber());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Policy Number : " + rs.getInt("PolicyNumber") + "\nPolicy Name : "
						+ rs.getString("PolicyName") + "\nPolicy Holder : " + rs.getString("PolicyHolderName")
						+ "\nPolicyStartDate : " + rs.getString("PolicyStartDate") + "\nPremiumAmt : "
						+ rs.getInt("PremiumAmt") + "\nPremiumType : " + rs.getString("PremiumType"));
			} else {
				System.out.println("Policy not found");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ps.close();
				//con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updatePolicy(Policy p) {
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(updatePolicySql);
			ps.setInt(6, p.getPolicyNumber());
			ps.setString(1, p.getPolicyName());
			ps.setString(2, p.getPolicyHolderName());
			ps.setString(3, p.getPolicyStartDate());
			ps.setString(4, p.getPremiumType());
			ps.setFloat(5, p.getPremiumAmt());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != ps) {
				try {
					int r = ps.executeUpdate();
					ps.close();
					//con.close();
					return r;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public int deletePolicy(Policy p) {
		DBConnection dbCon = new DBConnection();
		Connection con = dbCon.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(deletePolicySql);
			ps.setInt(1, p.getPolicyNumber());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (null != ps) {
				try {
					int r = ps.executeUpdate();
					ps.close();
					con.close();
					return r;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
