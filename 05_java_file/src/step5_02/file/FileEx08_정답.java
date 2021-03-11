package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//2021.03.10 20:15 ~ 20:53

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
		
		String str = "";
		
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
						
						System.out.print(" [ PW ] : ");
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
				
				str = "";
				log = -1;
				System.out.println("로그아웃 성공");
				
			}
			else if (sel == 3) {
				
				if (log == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
			
				
				for (int i = 0; i < ids.length; i++) {
					
					if ( i == log) System.out.println(ids[i] + " 님 : " + str);
					else System.out.println(ids[i] + "님 ");
				}
				
				System.out.println("===== 품목 =====");
				for (int i = 0; i < items.length; i++) {
					
					System.out.println((i+1) + " : " + items[i] );
				}
				
				System.out.println();
				System.out.print("상품 선택 : ");
				int getitemNumber = scan.nextInt();
				
				if ( getitemNumber <= 0 || getitemNumber > items.length) {
					
					System.out.println("존재하지 않는 품목입니다.");
					System.out.println();
					
					continue;
				}
				
				
				if (count < MAX_SIZE) {
					
					str += items[getitemNumber - 1] + " / ";
					
				}
				
				jang[count][0] = Integer.parseInt(pws[log]);
				jang[count][1] = getitemNumber - 1;
						
				count ++;
				
			}
			else if (sel == 4) {
				
				int sumofItems = 0;
				
				if (log == -1) {
					
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				
				for (int i = 0; i < jang.length; i++) {
					
					if (jang[i][0] == Integer.parseInt(pws[log])) {
						
						int num = jang[i][1];
						
						System.out.println((sumofItems++) + ". " + items[num]);
					}
				}
				
				
			}
			else if (sel == 5) {
				
				FileWriter fw = null;
				
				
				try {
					
					fw = new FileWriter(fileName);
					
					String string = "";
					
					for (int i = 0; i < jang.length; i++) {
						
						string += jang[i][0] + " / " + jang[i][1] + "\n";
						
						
					}
					
					fw.write(string);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else if (sel == 6) {
				
				
				File file = new File(fileName);
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					while(true) {
						
						String s = "";
						
						s = br.readLine();
						
						if ( s == null) break;
						System.out.println(s);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.println();
			
		}
		
	}
}
