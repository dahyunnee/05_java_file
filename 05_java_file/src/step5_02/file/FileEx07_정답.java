package step5_02.file;


import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

//2021.03.09 21:28 ~ 
public class FileEx07_정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				
				boolean isOverlappaed = false;
				
				System.out.print(" [ ID ] : ");
				String getId = scan.next();
				
				for (int i = 0; i < accs.length; i++) {
					
					if ( accs[i].equals(getId)) {
						
						System.out.println("중복 아이디 존재");
						
						isOverlappaed = true;
						break;
					}
				}
				
				if (isOverlappaed == true) {
					
					continue;
				}
				
				
				System.out.print(" [ PW ] : ");
				String getPw = scan.next();
				
				accs[accsCnt] = getId;
				pws[accsCnt] = getPw;
				moneys[accsCnt] += 1000;
				
				accsCnt ++;
				
			}
			else if (sel == 2) {
				
				if (identifier == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
				accs[identifier] = "";
				pws[identifier] = "";
				identifier = -1;
				
				
			}
			else if (sel == 3) {
				
				System.out.print("ID 입력 : ");
				String getId = scan.next();
				
				System.out.println("PW 입력 : ");
				String getPw = scan.next();
				
				for (int i = 0; i < accs.length; i++) {
					
					if ( accs[i].equals(getId) && pws[i].contentEquals(getPw)) {
						
						System.out.println("로그인 성공");
						identifier = i;
						
						break;
					}
					
					if ( i == accs.length - 1) {
						
						System.out.println("로그인 실패");
					}
				}
				
			}
			else if (sel == 4) {
				
				if (identifier == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
				System.out.println("로그아웃 성공");
				identifier = -1;
				
			}
			else if (sel == 5) {
				
				if (identifier == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
				System.out.print("입금하실 금액 : ");
				int getMoney = scan.nextInt();
				
				moneys[identifier] += getMoney;
				
				
			}
			else if (sel == 7) {
				
				
				if (identifier == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
				System.out.print("이체하실 계좌 : ");
				String getAccs = scan.next();
				
				for (int j = 0; j < accs.length; j++) {
					
					if ( accs[j].equals(getAccs)) {
						
						System.out.print("이체할 금액 : ");
						int getMoney = scan.nextInt();
						
						if (getMoney > moneys[identifier]) {
							
							System.out.println("잔액 부족");
							break;
							
						}
						
						System.out.println("이체 성공");
						
						moneys[identifier] -= getMoney;
						moneys[j] += getMoney;
						
						
						break;
					}
					
					if (j == accs.length - 1) {
						
						System.out.println("존재하지 않는 계좌입니다. ");
					}
				}
				
			}
			else if (sel == 6) {
				
				
			}
			else if (sel == 8) {}
			else if (sel == 9) {}
			else if (sel == 10) {}
			else if (sel == 0) {
				break;
			}
			
			System.out.println();
		}
		
	}
}
