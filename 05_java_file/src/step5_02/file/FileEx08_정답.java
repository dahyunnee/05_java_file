package step5_02.file;

//2021.03.10 20:15 ~ 

import java.util.Scanner;

//# 파일 컨트롤러[3단계] : 장바구니

public class FileEx08_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",   "2222", "3333"};
		String[] items = {"사과", "바나나", "딸기"};
		
		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		String fileName = "jang.txt";
		
		int count = 0;
		int log = -1;
		
		while (true) {
			
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				
				System.out.print(" [ ID ] : ");
				String getId = scan.next();
				
				for (int i = 0; i < ids.length; i++) {
					
					if (ids[i].equals(getId)) {
						
						System.out.println(" [ PW ] : ");
						String getPw = scan.next();
						
						if ( pws[i].equals(getPw) ) {
							
							System.out.println("로그인 성공");
							log = i;
						}
						
						else {
							
							System.out.println("비밀번호 오류");
						}
						
						break;
						
					}
					
					if (i == ids.length - 1 ) {
						
						System.out.println("존재하지 않는 ID입니다.");
					}
					
				}
				
				
			}
			else if (sel == 2) {
				
				log = -1;
				System.out.println("로그아웃 성공");
				
			}
			else if (sel == 3) {
				
				
			}
			else if (sel == 4) {}
			else if (sel == 5) {}
			else if (sel == 6) {}
			else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.println();
			
		}
		
	}
}
