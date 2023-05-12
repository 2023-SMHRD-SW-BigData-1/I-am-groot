package MiniProject;

import java.util.Scanner;

public class Game_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      DAO dao = new DAO();
	      // 게임시작 전 선택 페이지
	      
	      System.out.println("======음악맞추기 게임======");
	      

	      while (true) {
	      System.out.print("[1]회원가입 [2]로그인 [3]전체랭킹보기 >> ");
	      int input = sc.nextInt();
	      //회원가입
	      if(input ==1) {
	      System.out.println("=====회원가입을 진행합니다=====");
	      
	      System.out.print("ID 입력 : ");
	      String id = sc.next();
	      System.out.print("PW 입력 : ");
	      String pw = sc.next();
	      System.out.print("NICKNAME 입력 : ");
	      String nick = sc.next();
	      
	      PlayerDTO pdto = new PlayerDTO(id, pw, nick);
	      int cnt = dao.join(pdto);
	      
	      if (cnt > 0) { 
	         System.out.println("회원가입 성공");
	      } else {
	         System.out.println("회원가입 실패");
	      }
	      // 로그인
	      }else if (input == 2) {
	         
	         System.out.println("===== 로그인을 진행합니다 =====");
	         System.out.print("ID 입력 : ");
	         String id = sc.next();
	         System.out.print("PW 입력 : ");
	         String pw = sc.next();
	         PlayerDTO pdto = dao.login(id, pw);
	         if(pdto != null) {
	            System.out.println("로그인 성공");
	         }else {
	            System.out.println("로그인 실패");
	         }
	      }
	   }
	      

	
	}
	
}
