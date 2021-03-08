package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

//2021.03.08 21:26 ~ 
public class FileEx06_문제 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] vector = null;
		int elementCnt = 0;
		
		String fileName = "vector.txt";
		
		while (true) {
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				
				System.out.print("추가할 값 : ");
				int inputValue = scan.nextInt();
				elementCnt ++;
				
				int[] temp = vector;
				
				vector = new int[elementCnt];
				
				if (temp != null) {
					
					for (int i = 0; i < temp.length; i++) {	//이전값들 복사하기
						
						vector[i] = temp[i];
					}
					
				}
				
				vector[elementCnt - 1] = inputValue;		//마지막 값 저장
				
				System.out.println(Arrays.toString(vector));
				
			}
			else if (sel == 2) {
				
				int indexofVector = 0;
				
				if (vector == null) {
					
					System.out.println("벡터가 존재하지 않습니다.");
					System.out.println();
					continue;
				}
				System.out.print("삭제할 인덱스 : ");
				int inputIndex = scan.nextInt();
				
				if (inputIndex < 0 || inputIndex >= vector.length) {
					
					System.out.println("존재하지 않는 인덱스입니다.");
					System.out.println();
					continue;
				}
				
				int[] temp = vector;
				
				vector = new int[--elementCnt];
				
				for (int i = 0; i < temp.length; i++) {
					
					if ( i != inputIndex ) vector[indexofVector ++] = temp[i];
				}
				
				System.out.println(Arrays.toString(vector));
				
			}
			else if (sel == 3) {
				
				FileWriter fw = null;
				
				try {
					
					fw = new FileWriter(fileName);
					
					fw.write(Arrays.toString(vector) + "\n");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					try {fw.close();} catch (IOException e) {e.printStackTrace();}
				}
				
				
				
			}
			else if (sel == 4) {
				
				File file = new File(fileName);
				FileReader fw = null;
				BufferedReader br = null;
				
				try {
					fw= new FileReader(file);
					br = new BufferedReader(fw);
					
					String data = br.readLine();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.println();
			
		}
		
	}
}
