package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//# 파일 로드하기 : 연습문제


public class FileEx05_정답예시 {

	public static void main(String[] args) {
		
		String[] names = new String[3];
		String[] pws   = new String[3];
		int[] moneys   = new int[3];
		
		String fileName = "fileTest02.txt";
		File file = new File(fileName);

		if (file.exists()) {
			
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				int i = 0;
				
				while (true) {
					
					String line = br.readLine();
					
					if (line == null) {
						break;
					}
					
					String[] info = line.split("/");
					names[i] = info[0];
					pws[i] = info[1];
					moneys[i] = Integer.parseInt(info[2]);
					
					i++;
					
				}
				
				for (int j=0; j<names.length; j++) {
					System.out.println(names[j] + ":" + pws[j] + ":" + moneys[j]);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
			
		}


	}

}
