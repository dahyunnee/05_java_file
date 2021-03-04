package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileEx02 {

	public static void main(String[] args) {
	
		
		String fileName = "ex01.txt";
		
		
		File file = new File(fileName);	//파일 객체 생성
		FileReader fr = null;			//파일 읽어오기
		BufferedReader br = null;		//텍스트 읽어오기
		
		
		if ( file.exists() ) {			//exists() : 파일이 존재하면, 결과는 true or false 반환
			
			try {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);		// br = new BufferedReader ( new FileReader ( new File ( fileName ) ) );
				
				String data = br.readLine();		//readLine() : 한 줄을 읽어온다.
				System.out.println(data);
				
				data = br.readLine();
				System.out.println(data);
				
				
				//전체 텍스트를 읽어오는 예시
				while (true) {
					
					data = br.readLine();
					
					//읽어올 텍스트가 없으면 null을 반환
					if ( data == null ) break;
					
					System.out.println( data );
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				//가장 나중에 open한 객체를 먼저 close한다.
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
				
			}
			
		}
		
		
		

	}

}
