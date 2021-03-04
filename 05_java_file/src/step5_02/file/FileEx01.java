package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileWriter fw = null;
		
		
		try {
			
			fw = new FileWriter("ex01.txt");
			
			
			
			fw.close();
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
		
		
		
		
	}

}
