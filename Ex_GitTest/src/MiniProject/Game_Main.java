package MiniProject;

import java.util.Scanner;

public class Game_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      DAO dao = new DAO();
	      // 게임시작 전 선택 페이지
	      
	      System.out.println("======음악맞추기 게임======");
	     
	      
	      while (true) {
	      System.out.print("[1]회원가입 [2]로그인 [3]전체랭킹보기 [4]게임설명>> ");
	      int input = sc.nextInt();
	      //회원가입
	      if(input ==1) {
	      System.out.println("=====회원가입을 진행합니다=====");
	      
	      System.out.print("ID 입력 : ");
	      String id = sc.next();
	      System.out.print("PW 입력 : ");
	      String pw = sc.next();
	      
	      PlayerDTO pdto = new PlayerDTO(id, pw);
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
	  	        System.out.println("======= 장르 선택 =======");
	  	        System.out.println("[1]발라드 [2]댄스 [3]힙합");
	  	        int choiceGenre = sc.nextInt();
	  	        System.out.println("======= 난이도 선택 =======");
	  	        System.out.println("난이도를 선택하세요");
	  	        System.out.println("[1]easy [2]hard");
	  	        int choiceLevel = sc.nextInt();
	  	        System.out.println("==== 게임을 시작하려면 아무 키나 입력하세요 =====");
	  	        String gameStart = sc.next();
	  	        if(gameStart != null) {
	  	        	
	  	        	System.out.println("GAME START");
	  	        }
	            break;
	         }else{
	            System.out.println("로그인 실패");
	         }
	      }else if (input == 4) {
	    	  
	    	  System.out.println("======= 게임 설명 =======");
	          System.out.println("이 게임은 짧게 나오는 노래를 듣고 제목을 맞추는 노래입니다. 아는 노래라면 정답 란에 답을 입력해보세여!");
	          
	      }
	      
	   }
	      

	
	}
	
}
