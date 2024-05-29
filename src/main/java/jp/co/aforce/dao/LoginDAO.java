package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.User;
import jp.co.aforce.beans.UserCredentials;

public class LoginDAO extends DAO {

	// 入力されたIDとパスワードとデータベースを照合するメソッド
	public User loginTrial(String userId, String password) throws Exception {
		User user = null;
		Connection con = getConnection();
		String sql = "SELECT * FROM login WHERE user_id = ? AND password = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userId);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserNo(rs.getInt("user_no"));
			user.setUserId(rs.getString("user_id"));
			user.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return user;

	}
	//入力されたuserIDからパスワードのハッシュ値とソルトを検索するメソッド
	public UserCredentials getUserCredentials(String userId) throws Exception {
		UserCredentials credentials = null;
		Connection con = getConnection();
		String sql = "SELECT password_hash, salt FROM login WHERE user_id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userId);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			String passwordHash = rs.getString("password_hash");
			String salt = rs.getString("salt");
			credentials = new UserCredentials(passwordHash, salt);
		}

		return credentials;
	}
	//ログインした際に最終ログイン履歴を更新するメソッド
	public void recordLastLogin(String userId) throws Exception{
		Connection con = getConnection();
		String sql = "UPDATE login SET last_login_date = NOW() WHERE user_id = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, userId);
		st.executeUpdate();
		
		st.close();
		con.close();
	}

}
