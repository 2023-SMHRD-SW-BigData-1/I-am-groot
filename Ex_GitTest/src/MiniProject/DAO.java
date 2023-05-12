package MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String db_id = "INFO";
			String db_pw = "12345";

			conn = DriverManager.getConnection(url, db_id, db_pw);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void getClose() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원가입

	public int join(PlayerDTO pdto) {

		int row = 0;

		try {

			getConn();
			String sql = "INSERT INTO PLAYER_INFO VALUES(?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pdto.getID());
			psmt.setString(2, pdto.getPW());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();
		}

		return row; 

	}

	// --------------------------회원가입 끝

	// 로그인 
	public PlayerDTO login(String id, String pw) {
		getConn();
		String sql = "SELECT * FROM PLAYER_INFO WHERE ID = ? AND PW = ?";
		PlayerDTO pdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery(); 
			if (rs.next()) { 
				String s_id = rs.getString(1);
				String s_pw = rs.getString(2);
				pdto = new PlayerDTO(s_id, s_pw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return pdto;

	}
	
	
}
