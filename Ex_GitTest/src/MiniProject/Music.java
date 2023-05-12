package MiniProject;

import java.util.ArrayList;
import java.util.Random;

import javazoom.jl.player.MP3Player;

// 뮤직 관련 메소드를 저장해두는 클래스 입니다.
public class Music { 
	String conPath = "C:\\\\Users\\\\smhrd\\\\Desktop\\\\workspace\\\\GitTest2\\\\src\\\\"; // 여기도 플레이하는 컴퓨터 경로 보고 수동적으로 수정
    ArrayList<String> MusicList = new ArrayList<>();
    public void balladeS() { // 메소드 이름 파일명에 맞게 수동적으로 수정
       int[] num = new int [6];
       int[] num2 = new int[6];
       
       Random rn = new Random();
       MP3Player mp3 = new MP3Player();
       int ran = rn.nextInt(6) ; // 6문제 이므로 6개까지 출력 
       
    MusicList.add((conPath+"balladeS\\ANTIFRAGILE.mp3"));  // 파일명과 음악 명칭 맞게 수동적으로 수정
    MusicList.add((conPath+"balladeS\\Cupid.mp3"));  
    MusicList.add((conPath+"balladeS\\HypeBoy.mp3"));
    MusicList.add((conPath+"balladeS\\I AM.mp3"));
    
       for(int i = 0; i < MusicList.size();i++) {
          num[i] = rn.nextInt(4);
           
          for(int j = 0; j < i;j++) {
             if (num[i] == num[j]) {
               i -= 1;
             }
             
          }
         
       }
    
    mp3.play(MusicList.get(num[3]));
    
    for(int i =0;i<num.length;i++) {
   	 System.out.println(num[i]);
    }
    }
}
