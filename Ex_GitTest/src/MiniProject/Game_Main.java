package MiniProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		int choiceGenre = 0;
		int choiceLevel = 0;

		int point = 0;
		// 게임시작 전 선택 페이지

		System.out.println(

				"\r\n" + ".___  ___.  __    __       _______. __    ______      _______      ___      .___  ___.  _______ \r\n"
						+ "|   \\/   | |  |  |  |     /       ||  |  /      |    /  _____|    /   \\     |   \\/   | |   ____|\r\n"
						+ "|  \\  /  | |  |  |  |    |   (----`|  | |  ,----'   |  |  __     /  ^  \\    |  \\  /  | |  |__   \r\n"
						+ "|  |\\/|  | |  |  |  |     \\   \\    |  | |  |        |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|  \r\n"
						+ "|  |  |  | |  `--'  | .----)   |   |  | |  `----.   |  |__| |  /  _____  \\  |  |  |  | |  |____ \r\n"
						+ "|__|  |__|  \\______/  |_______/    |__|  \\______|    \\______| /__/     \\__\\ |__|  |__| |_______|\r\n"
						+ "                                                                                                \r\n"
						+ "" + "⠄⠀⠀⠀⠀⢀⣤⣶⣾⣿⣷⣶⣶⣤⣀⠀⣀⣴⣶⣿⣿⣶⣦⣄⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⡀⠀⠀\r\n" + "⠀⣠⣿⣿⣿⠟⠉⠁⠈⠉⠉⠉⠙⠛⢻⣿⣿⣿⣿⣿⣿⠛⠛⠛⠛⠛⠋⠑⠀⠀\r\n"
						+ "⢸⣿⣿⣿⣿⣷⠶⠾⠷⠶⠶⠶⠒⠒⠛⢿⣿⣿⣿⣿⣿⠦⢠⠖⠲⠶⢶⣿⣶⡄\r\n" + "⣼⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⢰⠖⠀⠀⠀   ⣿⣿⣿⡟⠙⠸⡏⠀⠀⠰⠀⣈⣿⠇\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣶⣶⣴⣶⡿⣀⣤⣤⣾⣿⣿⣿⣿⣤⣤⣿⣶⣶⣿⣿⠿⠋⠀\r\n" + "⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⣿⡏⣴⣶⣶⣬⠻⣿⣿⣧⣾⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣆⠀⠀\r\n" + "⠻⣿⣿⣿⣿⠃⠘⢿⣿⣿⣷⠘⠿⣿⣯⣽⣾⣿⠿⠋⣉⣤⣴⣶⡆⢹⣿⣿⡆⠀\r\n"
						+ "⣀⠽⣿⣿⣿⣷⡆⢸⣿⣿⣿⡇⢀⣀⠀⠀⠈⣀⣴⣾⣿⣿⠿⠛⠁⣈⣉⠛⠁⠀\r\n" + "⣻⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⠁⣈⣀⣤⣾⣿⣿⠿⠟⠉⣀⣤⣶⣿⠿⠛⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⠏⠁⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣶⣶⡄⢹⡿⠟⠋⠁⠀⠀⠀⠀⠀\r\n" + "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⠸⣀⣀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀");

		System.out.println();

		while (true) {
			System.out.print("[1]회원가입 [2]로그인 [3]전체랭킹보기 [4]게임설명 >> ");
			int input = sc.nextInt();
			// 회원가입
			if (input == 1) {
				System.out.println("=====회원가입을 진행합니다=====");

				System.out.print("네 이름은 무엇이냐 : ");
				String id = sc.next();
				System.out.print("암호를 입력하거라 : ");
				String pw = sc.next();

				PlayerDTO pdto = new PlayerDTO(id, pw);
				int cnt = dao.join(pdto);

				if (cnt > 0) {
					System.out.println("회원가입 성공");
					PlayerDTO pdt = new PlayerDTO(id, point);
					int low = dao.pointID(pdt);
					if (low > 0) {
						System.out.println("저장완료");
					} else {
						System.out.println("저장실패");
					}
				} else {
					System.out.println("회원가입 실패");
				}
				// 로그인
			} else if (input == 2) {

				System.out.println("===== 로그인을 진행합니다 =====");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				PlayerDTO pdto = dao.login(id, pw);
				if (pdto != null) {
					System.out.println("로그인 성공");

					while (true) {
						System.out.println("======= 장르 선택 =======");
						System.out.println("[1]발라드 [2]댄스 [3]힙합");
						choiceGenre = sc.nextInt();

						if (choiceGenre == 1) {
							System.out.println("서서노래하는 아스키아트(예시)");
							break;
						} else if (choiceGenre == 2) {

							System.out.println("춤추는 아스키아트(예시)");
							break;
						} else if (choiceGenre == 3) {
							System.out.println("냅다 왕 금목걸이걸고있는 힙합 아스키아트(예시)");
							break;
						} else {

							System.out.println("번호를 잘못 입력하셨습니다. 장르를 선택해주세요.");

						}
					}

					while (true) {
						System.out.println("======= 난이도 선택 =======");
						System.out.println("난이도를 선택하세요");
						System.out.println("[1]easy [2]hard");
						choiceLevel = sc.nextInt();

						if (choiceLevel == 1) {
							System.out.println("easy모드가 선택되었습니다.");
							break;
						} else if (choiceLevel == 2) {

							System.out.println("hard모드가 선택되었습니다.");
							break;
						} else {

							System.out.println("번호를 잘못 입력하셨습니다. 난이도를 선택해주세요.");
						}

					}
					System.out.println("==== 게임을 시작하려면 아무 키나 입력 후 엔터를 눌러주세요 =====");
					String gameStart = sc.next();
					if (gameStart != null) {

						System.out.println("==== 게임규칙 ====");
						System.out.println("1.노래는 게임 시작 후 바로 재생됩니다.");
						System.out.println("2.답은 띄어쓰기 없이 작성해주세요.");
						System.out.println("3.답에 영어가 들어가 있다면 모두 한국어 발음으로 변경하여 작성해주세요.");
						System.out.println("게임을 즐겨주세요 !~");
						System.out.println("\r\n"
								+ " __       _______      ___      .___  ___.  _______         _______..___________.     ___      .______      .___________.    __  \r\n"
								+ "|  |     /  _____|    /   \\     |   \\/   | |   ____|       /       ||           |    /   \\     |   _  \\     |           |   |  | \r\n"
								+ "|  |    |  |  __     /  ^  \\    |  \\  /  | |  |__         |   (----``---|  |----`   /  ^  \\    |  |_)  |    `---|  |----`   |  | \r\n"
								+ "|  |    |  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|         \\   \\        |  |       /  /_\\  \\   |      /         |  |        |  | \r\n"
								+ "|__|    |  |__| |  /  _____  \\  |  |  |  | |  |____    .----)   |       |  |      /  _____  \\  |  |\\  \\----.    |  |        |__| \r\n"
								+ "(__)     \\______| /__/     \\__\\ |__|  |__| |_______|   |_______/        |__|     /__/     \\__\\ | _| `._____|    |__|        (__) \r\n"
								+ "                                                                                                                                 \r\n"
								+ "");

					}
					break;
				} else {
					System.out.println("로그인 실패");
				}
			} else if (input == 3) {

				System.out.println("==================== 전체 랭킹 ====================");
				ArrayList<PlayerDTO> List = dao.Ranking();
				for (int i = 0; i < List.size(); i++) {
					System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
				}

			} else if (input == 4) {

				System.out.println("======= 게임 설명 =======");
				System.out.println("이 게임은 짧게 나오는 노래를 듣고 제목을 맞추는 노래입니다. 아는 노래라면 정답 란에 답을 입력해보세여!");
			}

		}
		System.out.println("게임이시작되어야합니다요 여기서부터~~!~!");
		if (choiceGenre == 1 && choiceLevel == 1) {

			System.out.println("발라드 easy모드");

		} else if (choiceGenre == 1 && choiceLevel == 2) {

			System.out.println("발라드 hard모드");
		} else if (choiceGenre == 2 && choiceLevel == 1) {
			System.out.println("댄스 easy모드");

		} else if (choiceGenre == 2 && choiceLevel == 2) {
			System.out.println("댄스 hard모드");

		} else if (choiceGenre == 3 && choiceLevel == 1) {

			System.out.println("힙합easy모드");
		} else if (choiceGenre == 3 && choiceLevel == 2) {

			System.out.println("힙합easy모드");
		}

	}

}
