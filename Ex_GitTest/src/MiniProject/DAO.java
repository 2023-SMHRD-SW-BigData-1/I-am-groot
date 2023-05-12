package MiniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

	// 포인트 테이블에 아이디 연동

	public int pointID(PlayerDTO pdt) {

		int low = 0;

		try {

			getConn();
			String sql = "INSERT INTO POINT_INFO VALUES(?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pdt.getID());
			psmt.setInt(2, pdt.getPOINT());
			low = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();
		}

		return low;

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

	// 랭킹조회

	public ArrayList<PlayerDTO> Ranking() {
		String sql = "SELECT * FROM POINT_INFO ORDER BY POINT DESC";
		PlayerDTO md = null;
		ArrayList<PlayerDTO> List = new ArrayList<>();
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String s_id = rs.getString(1);
				int s_point = rs.getInt(2);
				md = new PlayerDTO(s_id, s_point);
				List.add(md);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return List;

	}

	// 보너스 문제

	

	public int bonus(int point) {

		getConn();
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int ran = rn.nextInt(10) + 1;
		String sql = "select * from bonus where qsnumber = ? ";
		try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, ran);
            rs = psmt.executeQuery();
            
            rs.next();
            
            System.out.println("보너스 스테이지 도착 !!");
            System.out.println("승리시 배팅point의 2배를 획득 / 실패시 배팅point만큼 차감");

            System.out.print("배팅 point : ");
            int battpoint = sc.nextInt();

            // =========================

            System.out.println("문제를 읽고 답을 입력하시오");
            
            String question = rs.getString(1);
            String answer = rs.getString(2);
            
           
            // 랜덤으로 문제 출제 되면

            System.out.print(rs.getString(1));
            String useranswer = sc.next();
            
            if(useranswer.equals(answer)) {
               System.out.println("정답입니다!");
               System.out.println("당신은" + battpoint * 2 + "point를 획득하였습니다.");
               point += battpoint;
            }else {
               System.out.println("틀렸습니다. 정답은 " + answer + "입니다");
               System.out.println("당신은 " + battpoint + "point를 잃었습니다");
                point -= battpoint;
            
            }

            
         }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {getClose();}
         

         return point;
      }
   
      
   
}

