package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제1

//2021.03.04 20:24 ~ 20:29
public class FileEx03_정답 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[] ages     = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		
		String data = "";
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(fileName);
			
			for (int i = 0; i < names.length; i++) {
				
				if ( i != names.length - 1) data += names[i] + "/" + Integer.toString(ages[i])+ ",";
				else data += names[i] + "/" + Integer.toString(ages[i]) +"\n";
				
			}
			
			fw.write(data);
			
		} catch (IOException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		} finally {
			
			try { fw.close(); } catch (IOException e) {e.printStackTrace();};
			
		}

		
	}


}
