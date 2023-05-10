package MiniProject;

import java.util.Scanner;

public class Bonus_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int point = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("보너스 스테이지 도착 !!");
		System.out.println("승리시 배팅point의 2배를 획득 / 실패시 배팅point만큼 차감");

		System.out.print("배팅 point : ");
		int battpoint = sc.nextInt();

		// =========================

		System.out.println("문제를 읽고 답을 입력하시오");

		String answer = "모짜렐라";

		// 랜덤으로 문제 출제 되면

		System.out.print("신데렐라가 잠을 못자면? ");
		String useranswer = sc.next();
		
		if(useranswer.equals(answer)) {
			System.out.println("정답입니다!");
			System.out.println("당신은" + battpoint * 2 + "point를 획득하였습니다.");
		}else {
			System.out.println("틀렸습니다. 정답은 " + answer + "입니다");
			System.out.println("당신은 " + battpoint + "point를 잃었습니다");
		}

	}

}
