package step5_02.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 파일이 생성되는 기본적인 위치는 현재 자바파일과 같은 프로젝트 폴더이다.(위치변경가능)
		// 소스를 실행한 후 프로젝트를 선택 한 뒤 F5(Refresh)를 누르면 생성된 파일을 확인할 수 있다.
		
		String fileName = "ex01.txt";
		
		FileWriter fw = null;
		
		
		try {	//파일 입출력은 try-catch 구문 없이 사용하지 못하도록 강제성을 부여해 놓았다.
			
			fw = new FileWriter(fileName);		// FileWrier : 파일을 생성하는 기능
			
													// writer() 메소드를 통해서 파일에 입력이 가능함
			fw.write("파일 저장하기 연습문제1\n");	// 1) 문자열 데이터 형식만 가능
			fw.write("파일 저장하기 연습문제2\n"); 	// 2) 개행기능이 없음 -> \n 의도적으로 작성
			

			
			String data = "파일 저장하기 연습문제3\n";
			data +=  "파일 저장하기 연습문제4\n";
			data +=  "파일 저장하기 연습문제5\n";
			
			fw.write(data);							// 3) write() 메소드를 여러 번 사용하지 않고
													// 	  데이터를 미리 '+=' 이용해 만든 후 한 번만 write() 메소드를 사용하는 것 권장.
		
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
			
		} finally {
			
			
			// fw = new FileWriter(fileName)에서 오류난 경우 fw = null이고 null을 close할 경우 오류나는 것 catch
			try { fw.close(); } catch (IOException e) { e.printStackTrace(); }
			// close() 메소드를 통해 파일객체를 종료한다. ( 잊어버리지 않게 항상 주의! )
			
		}
		
		
		
		
	}

}
