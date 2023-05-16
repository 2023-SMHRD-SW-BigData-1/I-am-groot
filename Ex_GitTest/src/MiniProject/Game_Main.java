package MiniProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import javazoom.jl.player.MP3Player;

public class Game_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		DAO dao = new DAO();
		int choiceGenre = 0;
		int choiceLevel = 0;
		Music m = new Music();
		MP3Player mp3 = new MP3Player();
		int battpoint = 0;
		int[] ran = new int[10];
		for (int a = 0; a < 10; a++) {
			ran[a] = rd.nextInt(10);

			for (int j = 0; j < a; j++) {
				if (ran[a] == ran[j]) {
					a -= 1;
				}
			}
		}

		int point = 0;
		int hintCount = 1;

		// 게임시작 전 선택 페이지
		while(true) {
		m.STBGM();
		System.out.println(

		    	"##     ## ##     ##  ######  ####  ######      ######      ###    ##     ## ######## \r\n"
		    	+ "###   ### ##     ## ##    ##  ##  ##    ##    ##    ##    ## ##   ###   ### ##       \r\n"
		    	+ "#### #### ##     ## ##        ##  ##          ##         ##   ##  #### #### ##       \r\n"
		    	+ "## ### ## ##     ##  ######   ##  ##          ##   #### ##     ## ## ### ## ######   \r\n"
		    	+ "##     ## ##     ##       ##  ##  ##          ##    ##  ######### ##     ## ##       \r\n"
		    	+ "##     ## ##     ## ##    ##  ##  ##    ##    ##    ##  ##     ## ##     ## ##       \r\n"
		    	+ "##     ##  #######   ######  ####  ######      ######   ##     ## ##     ## ######## ");

		System.out.println();

		while (true) {

			System.out.println("=========== MUSIC GAME 이야기 =============");
			System.out.println("난생 처음 보는 코드들에 속수무책으로 죽어가는 세연쌤반 학생들! 스트레스에 못 이겨 의욕을 잃어간다!");
			System.out.println("쉬는시간을 조금이나마 더 즐기기 위해서는 위험을 감지하는 학성, 민준, 하신, 희주 말고도 좋은 귀를 가진 동료가 더 필요한 상황! ");
			System.out.println("잠깐의 소리로도 선생님이 오시는지 기척을 잡아채는 귀를 가진 동료를 얻기 위한 모험을 떠나는데 ..!");
			System.out.println("=========================================");
			System.out.println();
			System.out.println("계속 진행하려면 아무 키나 입력하고 엔터를 누르세요");
			String anyKey = sc.next();
			if (anyKey != null) {

				System.out.println();
				System.out.print("[1]너 내 동료가 돼라! [2]모험의 시작 [3]전체랭킹보기 [4]게임설명 >> ");
				int input = sc.nextInt();
				// 회원가입
				if (input == 1) {
					System.out.println("===== 동료 명부에 이름 올리기 =====");

					System.out.print("이름을 입력해줘 : ");
					String id = sc.next();
					System.out.print("우리끼리의 암호를 정해보자 : ");
					String pw = sc.next();

					PlayerDTO pdto = new PlayerDTO(id, pw);
					int cnt = dao.join(pdto);

					if (cnt > 0) {
						System.out.println();
						System.out.println("귀 활짝 열어놓으라구!");
						System.out.println();
						PlayerDTO pdt = new PlayerDTO(id, point);
						int low = dao.pointID(pdt);
						if (low > 0) {
							System.out.println("저장완료");
						} else {
							System.out.println("저장실패");
						}
					} else {
						System.out.println("동료가 되기 싫은거야? 다시 시도해보라구!");
					}
					// 로그인
				} else if (input == 2) {
					System.out.println();
					System.out.println();
					System.out.println("===== 동료가 맞는지 확인할게! =====");
					System.out.print("네 이름이 뭐지? : ");
					String id = sc.next();
					System.out.print("우리가 정한 암호가 뭐였지? : ");
					String pw = sc.next();
					PlayerDTO pdto = dao.login(id, pw);
					if (pdto != null) {
						System.out.println();
						System.out.println("떠나보자고!");
						System.out.println();

						while (true) {
							System.out.println("======= 장르 선택 =======");
							System.out.println("[1]발라드 [2]댄스 [3]힙합");
							choiceGenre = sc.nextInt();

							if (choiceGenre == 1) {
								System.out.println("######     #    #       #          #    ######  \r\n"
										+ "#     #   # #   #       #         # #   #     # \r\n"
										+ "#     #  #   #  #       #        #   #  #     # \r\n"
										+ "######  #     # #       #       #     # #     # \r\n"
										+ "#     # ####### #       #       ####### #     # \r\n"
										+ "#     # #     # #       #       #     # #     # \r\n"
										+ "######  #     # ####### ####### #     # ######  ");

								System.out.println();

								break;
							} else if (choiceGenre == 2) {

								System.out.println("######     #    #     #  #####  ####### \r\n"
										+ "#     #   # #   ##    # #     # #       \r\n"
										+ "#     #  #   #  # #   # #       #       \r\n"
										+ "#     # #     # #  #  # #       #####   \r\n"
										+ "#     # ####### #   # # #       #       \r\n"
										+ "#     # #     # #    ## #     # #       \r\n"
										+ "######  #     # #     #  #####  ####### ");
								break;
							} else if (choiceGenre == 3) {
								System.out.println("#     # ### ######  #     # ####### ######  \r\n"
										+ "#     #  #  #     # #     # #     # #     # \r\n"
										+ "#     #  #  #     # #     # #     # #     # \r\n"
										+ "#######  #  ######  ####### #     # ######  \r\n"
										+ "#     #  #  #       #     # #     # #       \r\n"
										+ "#     #  #  #       #     # #     # #       \r\n"
										+ "#     # ### #       #     # ####### #       ");
								break;
							} else {

								System.out.println("번호를 잘못 입력했잖아. 제대로 선택해보라구!");

							}
						}

						while (true) {
							System.out.println("======= 난이도 선택 =======");
							System.out.println("난이도를 선택하세요");
							System.out.println("[1]easy [2]hard");
							choiceLevel = sc.nextInt();

							if (choiceLevel == 1) {
								System.out.println("역시 게임은 쉽게쉽게 가는 맛이지!");
								System.out.println();
								System.out.println("==== 게임규칙 ====");
								System.out.println("1.노래는 게임 시작 후 아무 키나 입력 후 엔터키를 누르면 재생됩니다.");
								System.out.println("2.답은 띄어쓰기 없이 작성해주세요.");
								System.out.println("3.답에 영어가 들어가 있다면 모두 한국어 발음으로 변경하여 작성해주세요.");
								System.out.println("4.힌트는 단 한 번 주어집니다. 신중히 사용하세요.");
								System.out.println("게임을 즐겨주세요 !~");
								System.out.println();
								System.out.println();
								break;
							} else if (choiceLevel == 2) {

								System.out.println("어려운 모드도 자신 있는거야? 가보자고!");
								System.out.println();
								System.out.println("==== 게임규칙 ====");
								System.out.println("1.노래는 게임 시작 후 아무 키나 입력 후 엔터키를 누르면 재생됩니다.");
								System.out.println("2.답은 띄어쓰기 없이 작성해주세요.");
								System.out.println("3.답에 영어가 들어가 있다면 모두 한국어 발음으로 변경하여 작성해주세요.");
								System.out.println("4.힌트는 단 한 번 주어집니다. 신중히 사용하세요.");
								System.out.println("게임을 즐겨주세요 !~");
								System.out.println();
								System.out.println();
								break;
							} else {

								System.out.println("번호를 잘못 입력했잖아. 제대로 선택해보라구!");
							}

						}
						System.out.println("===== 게임을 시작하려면 아무 키나 입력 후 엔터를 눌러주세요 =====");
						String gameStart = sc.next();
						m.BGMend();
						if (gameStart != null) {

							System.out.println(" ######      ###    ##     ## ########     ######  ########    ###    ########  ######## \r\n"
									+ "##    ##    ## ##   ###   ### ##          ##    ##    ##      ## ##   ##     ##    ##    \r\n"
									+ "##         ##   ##  #### #### ##          ##          ##     ##   ##  ##     ##    ##    \r\n"
									+ "##   #### ##     ## ## ### ## ######       ######     ##    ##     ## ########     ##    \r\n"
									+ "##    ##  ######### ##     ## ##                ##    ##    ######### ##   ##      ##    \r\n"
									+ "##    ##  ##     ## ##     ## ##          ##    ##    ##    ##     ## ##    ##     ##    \r\n"
									+ " ######   ##     ## ##     ## ########     ######     ##    ##     ## ##     ##    ##    ");

							// Easy_Ballad 문제 시작
							// ==============================================================================================
							if (choiceGenre == 1 && choiceLevel == 1) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Ballad(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Ballad.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Ballad.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Ballad.get(ran[j]).getTitle())) {
													System.out.println();
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													point += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 15;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 15;
												} else {
													point -= 15;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();

								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Ballad(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Ballad.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Ballad.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Ballad.get(ran[j]).getTitle())) {
													System.out.println();
													System.out.println("정답입니다!! ");
													battpoint += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													battpoint -= 15;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												battpoint -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													battpoint -= 15;
												} else {
													battpoint -= 15;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########     #######     ###    ######## ##     ## ");

								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();

								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();

								break;

								// Hard_Ballad
								// ================================================================================================
							} else if (choiceGenre == 1 && choiceLevel == 2) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Ballad(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Ballad.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Ballad.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Ballad.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													point += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 30;
												} else {
													point -= 30;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();
								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Ballad(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Ballad.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Ballad.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Ballad.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													battpoint += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													battpoint -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												battpoint -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													battpoint -= 30;
												} else {
													battpoint -= 30;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########     #######     ###    ######## ##     ## ");

								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println();
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();
								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();
								break;
							}
							// Easy_dance
							// 시작==============================================================================================================
							else if (choiceGenre == 2 && choiceLevel == 1) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Dance(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Dance.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Dance.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Dance.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													point += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 15;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 15;
												} else {
													point -= 15;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();

								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Dance(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Dance.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Dance.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Dance.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													battpoint += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 15;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 15;
												} else {
													point -= 15;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########     #######     ###    ######## ##     ## ");
								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();
								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();
								break;

								// Hard_Dance
								// ==================================================================================================
							} else if (choiceGenre == 2 && choiceLevel == 2) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Dance(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Dance.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Dance.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Dance.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													point += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 30;
												} else {
													point -= 30;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();
								
								

								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Dance(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Dance.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Dance.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Dance.get(ran[j]).getTitle())) {
													System.out.println();
													System.out.println("정답입니다!! ");
													battpoint += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													battpoint -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												battpoint -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													battpoint -= 30;
												} else {
													battpoint -= 30;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########     #######     ###    ######## ##     ## ");
								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println("동료를 모으는 게임이 끝났습니다.");
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();
								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();
								break;
								// Easy_Hiphop
								// =================================================================================================
							} else if (choiceGenre == 3 && choiceLevel == 1) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");
									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Hiphop(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Hiphop.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Hiphop.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Hiphop.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													point += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 15;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 15;
												} else {
													point -= 15;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();

								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Easy_Hiphop(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Easy_Hiphop.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 30;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Easy_Hiphop.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Easy_Hiphop.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													battpoint += 30;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													battpoint -= 15;

												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												battpoint -= 15;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													battpoint -= 15;
												} else {
													battpoint -= 15;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########     #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########     #######     ###    ######## ##     ## ");
								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();
								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();
								break;
								// Hard_Hiphop
								// ============================================================================================
							} else if (choiceGenre == 3 && choiceLevel == 2) {
								for (int j = 0; j < 3; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Hiphop(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Hiphop.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											point += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Hiphop.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Hiphop.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													point += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													point -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												point -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													point -= 30;
												} else {
													point -= 30;
												}
											}
										}
									}
								}
								// 3문제 끝나고 보너스 스테이지
								m.CBGM();
								battpoint += dao.bonus(point);
								m.BGMend();

								// 다시 3문제 시작
								// ============================================================================================
								for (int j = 4; j < 7; j++) {
									System.out.println("노래를 재생하시려면 아무 키나 입력 후 엔터를 눌러주세요.");

									String star = sc.next();
									System.out.println();
									System.out.println();
									System.out.println();
									if (star != null) {
										mp3.play(dao.Hard_Hiphop(ran[j]));
										System.out.println("\r\n"
												+ "########  ##          ###    ##    ##     ######   #######  ##    ##  ######   \r\n"
												+ "##     ## ##         ## ##    ##  ##     ##    ## ##     ## ###   ## ##    ##  \r\n"
												+ "##     ## ##        ##   ##    ####      ##       ##     ## ####  ## ##        \r\n"
												+ "########  ##       ##     ##    ##        ######  ##     ## ## ## ## ##   #### \r\n"
												+ "##        ##       #########    ##             ## ##     ## ##  #### ##    ##  \r\n"
												+ "##        ##       ##     ##    ##       ##    ## ##     ## ##   ### ##    ##  \r\n"
												+ "##        ######## ##     ##    ##        ######   #######  ##    ##  ######   \r\n"
												+ "");
										System.out.println("\r\n"
												+ "\r\n"
												+ "           .   .    .       .           \r\n"
												+ "           .    -****!*-.  .. .         \r\n"
												+ "    . .  ..  ..##########,.  .     .    \r\n"
												+ "         .   ;############!             \r\n"
												+ "  .     .  .!####$#########!. .  .   .  \r\n"
												+ "          .,####;.!#########-           \r\n"
												+ "  .     .  $####;  .########$ .  .   .  \r\n"
												+ "          -#####;   .;#######:          \r\n"
												+ "    . .   *#####;.    -=#####*     .    \r\n"
												+ "          *#####;   .   !$###*.         \r\n"
												+ "         .=#####;       .,$##$-         \r\n"
												+ "         .*#####;.       -$##$,         \r\n"
												+ "          *#####;.      *####*          \r\n"
												+ "  .       *#####;     ,######*.  .   .  \r\n"
												+ "          -#####;   ,;#######-          \r\n"
												+ "          .$####;. .########$           \r\n"
												+ "           ,####; !#########,           \r\n"
												+ "    . .  .  !####$#########! . .   .    \r\n"
												+ "           . !############! .           \r\n"
												+ "  .          .,##########, .  .  .   .  \r\n"
												+ "         .      ~!!!*!!-  .  .          \r\n"
												+ "                      .                 \r\n"
												+ "");
										System.out.print("정답을 입력해 주세요 : ");
										String userAnswer = sc.next();
										if (userAnswer.equals(dao.Hard_Hiphop.get(ran[j]).getTitle())) {
											System.out.println("정답이야!!");
											System.out.println("다음 곡도 맞힐 수 있지?");
											System.out.println();
											battpoint += 60;
										} else {
											System.out.println("틀렸어..");
											System.out.println(
													"학성의 속삭임 : 힌트를 사용하고 싶으면 키보드로 hint를 입력 후 엔터를 눌러봐! 싫다면 다른 걸 입력하고.");
											String hi = sc.next();
											if (hi.equals("hint") && hintCount > 0) {
												hintCount -= 1;
												System.out
														.println(":::    ::: ::::::::::: ::::    ::: :::::::::::  \r\n"
																+ ":+:    :+:     :+:     :+:+:   :+:     :+:      \r\n"
																+ "+:+    +:+     +:+     :+:+:+  +:+     +:+      \r\n"
																+ "+#++:++#++     +#+     +#+ +:+ +#+     +#+      \r\n"
																+ "+#+    +#+     +#+     +#+  +#+#+#     +#+      \r\n"
																+ "#+#    #+#     #+#     #+#   #+#+#     #+#      \r\n"
																+ "###    ### ########### ###    ####     ###  ");

												System.out.println();
												System.out.println();
												System.out.println("초성힌트 : " + dao.Hard_Hiphop.get(ran[j]).getSpell());
												System.out.println("정답을 입력해주세요 :  ");
												String hint_an = sc.next();
												if (hint_an.equals(dao.Hard_Hiphop.get(ran[j]).getTitle())) {
													System.out.println("정답이야!!");
													System.out.println("다음 곡도 맞힐 수 있지?");
													System.out.println();
													battpoint += 60;
												} else {
													System.out.println("실망한 민준 : 힌트는 한 번밖에 없는데 이걸 틀리다니.. 유감이야.. ");
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");
													System.out.println();
													System.out.println();
													System.out.println();
													battpoint -= 30;
												}

											} else if (hi.equals("hint") && hintCount == 0) {
												System.out.println("위로하는 하신 : 남아있는 힌트가 없어...");
												System.out.println();
												System.out.println();
												battpoint -= 30;
											} else {
												if (j < 3) {
													System.out.println("#     # ####### #     # ####### \r\n"
															+ "##    # #        #   #     #    \r\n"
															+ "# #   # #         # #      #    \r\n"
															+ "#  #  # #####      #       #    \r\n"
															+ "#   # # #         # #      #    \r\n"
															+ "#    ## #        #   #     #    \r\n"
															+ "#     # ####### #     #    #    \r\n"
															+ "                                ");

													battpoint -= 30;
												} else {
													battpoint -= 30;
												}
											}
										}
									}
								}

								System.out.println(" ######      ###    ##     ## ########  #######  ##     ## ######## ########  \r\n"
										+ "##    ##    ## ##   ###   ### ##       ##     ## ##     ## ##       ##     ## \r\n"
										+ "##         ##   ##  #### #### ##       ##     ## ##     ## ##       ##     ## \r\n"
										+ "##   #### ##     ## ## ### ## ######   ##     ## ##     ## ######   ########  \r\n"
										+ "##    ##  ######### ##     ## ##       ##     ##  ##   ##  ##       ##   ##   \r\n"
										+ "##    ##  ##     ## ##     ## ##       ##     ##   ## ##   ##       ##    ##  \r\n"
										+ " ######   ##     ## ##     ## ########  #######     ###    ######## ##     ## ");
								System.out.println("신난 희주 : 안녕 플레이어! 제목은 많이 맞혔어?");
								System.out.println("고생한 학성 : 내 주말을 갈아넣은 게임이 재밌었길 바라!");
								System.out.println("능력자 하신 : 노래들은 마음에 들었어? 내가 골라봤는데 높은 포인트를 얻었을거라 믿어!");
								System.out.println("잠 못 잔 민준 : ..머리 빠지는 줄 알았어요.");
								System.out.println("당신의 점수는 : " + battpoint + "입니다.");
								System.out.println();
								dao.End(id, battpoint);
								System.out.println();
								System.out.println("==================== 전체 랭킹 ====================");
								ArrayList<PlayerDTO> List = dao.Ranking();
								for (int i = 0; i < List.size(); i++) {
									System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
								}
								System.out.println();
								break;
							}

						}
					} else {
						System.out.println();
						System.out.println("넌 누구길래 동료인 척 하는거지? 모험을 떠나고 싶다면 동료 명부에 이름을 올리고 오라고.");
						System.out.println();
					}

				} else if (input == 3) {

					System.out.println("==================== 전체 랭킹 ====================");
					ArrayList<PlayerDTO> List = dao.Ranking();
					for (int i = 0; i < List.size(); i++) {
						System.out.println(List.get(i).getID() + " / " + List.get(i).getPOINT());
					}

				} else if (input == 4) {
					System.out.println();
					System.out.println();
					System.out.println("==================== 게임 설명 ====================");
					System.out.println("짧게 나오는 노래를 듣고 제목을 맞추는 게임입니다. 아는 노래라면 정답을 입력해보세요!");
					System.out.println();
					System.out.println();

				}

			}
		}
	}
	}
}
	