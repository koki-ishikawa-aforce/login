package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationDAO extends DAO {
	//入力されたIDが既に登録されていないか確認するメソッド
	public boolean isExistID(String userId) throws Exception{
		Connection con = getConnection();
		String sql = "SELECT COUNT(*) FROM login WHERE user_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userId);
		ResultSet rs = st.executeQuery();
		
		boolean exists = false;
		if(rs.next()) {
				exists = rs.getInt(1) > 0;
		}
		st.close();
		con.close();
		return exists;
	}
	//入力されたデータをデータベースに登録するメソッド
	public void register(String userId, String passwordHash, String salt) throws Exception{
		Connection con = getConnection();
		String sql = "INSERT INTO login (user_id, password_hash, salt) VALUES (?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userId);
		st.setString(2, passwordHash);
		st.setString(3, salt);
		st.executeUpdate();
		
		st.close();
		con.close();
		
	}
}
