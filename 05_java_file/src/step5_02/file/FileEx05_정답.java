package step5_02.file;

import java.io.*;
import java.util.Arrays;

//# 파일 로드하기 : 연습문제

//2021.03.04 21:22 ~ 21:35
public class FileEx05_정답 {

	public static void main(String[] args) {
		
		String[] names = new String[3];
		String[] pws   = new String[3];
		int[] moneys   = new int[3];
		
		String fileName = "fileTest02.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		
		if ( file.exists() ) {
			
			try {
				
				fr = new FileReader (file);
				br = new BufferedReader(fr);
				
				
				int indexofLine = 0;
				String str = "";
				
				while ( ( str = br.readLine()) != null ) {
				
					String[] strArray = str.split( "/" );
					
					names[ indexofLine ] = strArray[0];
					pws[ indexofLine ] = strArray[1];
					moneys[ indexofLine ++ ] = Integer.parseInt(strArray[2]);
					
					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				try { br.close(); } catch (IOException e) { e.printStackTrace(); }
				try { fr.close(); } catch (IOException e) { e.printStackTrace(); }
					
			}
			
			
			System.out.println(Arrays.toString(names));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));
			
			
		}
		
		
		
	}

}
