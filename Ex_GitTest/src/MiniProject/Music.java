package MiniProject;

import java.util.ArrayList;
import java.util.Random;

import javazoom.jl.player.MP3Player;

// 뮤직 관련 메소드를 저장해두는 클래스 입니다.
public class Music { 
	
	 ArrayList<String> MusicList = new ArrayList<>();
	 DAO dao = new DAO();
	 Random rn = new Random();
   
    MP3Player mp3 = new MP3Player();
    int h = 0;
    
   
    String conpath = "C:\\Users\\smhrd\\Desktop\\Sing\\BGM\\";
    public void balladeS() {
    }// 메소드 이름 파일명에 맞게 수동적으로 수정
       int[] num = new int [6];
       int[] num2 = new int[6];
       
       int ran = rn.nextInt(6) ; // 6문제 이므로 6개까지 출력 

       
       //BGM
      
       public void STBGM() { // 메소드 이름 파일명에 맞게 수동적으로 수정
       	
       	String s_bgm = conpath + "버블.mp3";
       	
       	mp3.play(s_bgm);
       	
       }
      
       public void BGMend() { // 메소드 이름 파일명에 맞게 수동적으로 수정
       	
       	
       	
       	mp3.stop();
       	
       }
       
     
       
       
    public void CBGM() { // 메소드 이름 파일명에 맞게 수동적으로 수정
   	 String s_bgm = conpath + "서든.mp3";
    	
    	mp3.play(s_bgm);
       	
       	
       }
    
       
       
       
       
       
       
     
    
    
}