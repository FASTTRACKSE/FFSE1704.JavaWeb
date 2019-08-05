package codemaster.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import codemaster.servlet.database.DatabaseUtil;
import codemaster.servlet.entity.SavingAccount;
import codemaster.servlet.entity.TransactionAccount;
import codemaster.servlet.log4jFile.Log4jFile;

public class AtmModel {

	/**
	 * 
	 * @resultsetType là 1 trong 3 kiểu:
	 * 
	 * @ResultSet.TYPE_FORWARD_ONLY, (chỉ đi tới, mặc định)
	 * 
	 * @ResultSet.TYPE_SCROLL_INSENSITIVE, (cho phép cuộn và không cập nhật thay
	 *                                     đổi)
	 * 
	 * @ResultSet.TYPE_SCROLL_SENSITIVE (cho phép cuộn và không cập nhật thay đổi
	 *                                  trên ngư�?i dùng khác)
	 * 
	 * 
	 * @resultSetConcurrency là 1 trong 2 kiểu:
	 * 
	 * @ResultSet.CONCUR_READ_ONLY (chỉ cho phép đ�?c)
	 * 
	 * @ResultSet.CONCUR_UPDATABLE (Cho phép cập nhật trên ResultSet)
	 * 
	 */
	PreparedStatement pstmt = null;
	DatabaseUtil db = new DatabaseUtil();
	Connection conn;

	/**
	 * hàm list danh sách account
	 * 
	 * @return
	 */
	public List<SavingAccount> getAllAccount() {
		conn = db.connect();
		String sql = "select * from Acount";
		ArrayList<SavingAccount> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String accNo = rs.getString("accountNo");
				String name = rs.getString("ownerName");
				double amount = rs.getDouble("amount");
				int accType = rs.getInt("accountType");
				double interest = rs.getDouble("interest");
				int term = rs.getInt("term");
				SavingAccount svac = new SavingAccount(accNo, name, amount, accType, interest, term);
				list.add(svac);
			}
			Log4jFile.writeInfor(sql);
		} catch (SQLException e) {
			Log4jFile.writeError(e.getMessage(), e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hàm add account Saving
	 * 
	 * @param sa
	 */
	public void addSaving(SavingAccount sa) {
		conn = db.connect();

		ResultSet rs = null;
		try {

			String sql = "select * from Acount";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();
			rs.moveToInsertRow();
			rs.updateString("accountNo", sa.getAccountNo());
			rs.updateString("ownerName", sa.getOwnerName());
			rs.updateDouble("amount", sa.getAmount());
			rs.updateInt("accountType", sa.getAccountType());
			rs.updateDouble("interest", sa.getInterest());
			rs.updateInt("term", sa.getTerm());
			rs.insertRow();

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}

	/**
	 * hàm add transaction
	 * 
	 * @param ta
	 */
	public void addTransaction(TransactionAccount ta) {
		conn = db.connect();
		PreparedStatement psttm = null;
		ResultSet rs = null;
		try {

			String sql = "select * from Acount";
			psttm = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = psttm.executeQuery();
			rs.moveToInsertRow();
			rs.updateString("accountNo", ta.getAccountNo());
			rs.updateString("ownerName", ta.getOwnerName());
			rs.updateDouble("amount", ta.getAmount());
			rs.updateInt("accountType", ta.getAccountType());
			rs.insertRow();

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}

	/**
	 * hàm nạp tiền
	 * 
	 * @param acc
	 * @param amount
	 */
	public void deposit(String ac, double amount1) {
		conn = db.connect();
		PreparedStatement psttm = null;
		ResultSet rs = null;
		try {

			String sql1 = "select * from Acount  where accountNo = '" + ac + "'";
			psttm = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = psttm.executeQuery();
			while (rs.next()) {

				rs.updateDouble("amount", amount1);
				rs.updateRow();
			}
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}

	/**
	 * hàm rút tiền
	 * 
	 * @param acc
	 * @param amount
	 */
	public void withdraw(String acc, double amount2) {
		conn = db.connect();
		PreparedStatement psttm = null;
		ResultSet rs = null;
		try {

			String sql2 = "select * from Acount  where accountNo = '" + acc + "'";
			psttm = conn.prepareStatement(sql2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = psttm.executeQuery();
			while (rs.next()) {

				rs.updateDouble("amount", amount2);
				rs.updateRow();
			}
		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}

	/**
	 * hàm kiểm tra account
	 * 
	 * @param maAC
	 * @return
	 */
	public SavingAccount checkId(String maAC) {
		conn = db.connect();
		SavingAccount sa = new SavingAccount();
		ResultSet rs = null;
		try {

			String sql = "select * from Acount where accountNo = '" + maAC + "'";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				sa.setAccountNo(rs.getString("accountNo"));
				sa.setOwnerName(rs.getString("ownerName"));
				sa.setAmount(rs.getDouble("amount"));
				sa.setAccountType(rs.getInt("accountType"));
				sa.setInterest(rs.getDouble("interest"));
				sa.setTerm(rs.getInt("term"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sa;
	}

}
