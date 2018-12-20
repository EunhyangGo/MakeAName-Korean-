package com.biz.names.exec;

import java.util.Scanner;

import com.biz.names.service.NameService;

public class Exec02 {

	public static void main(String[] args) {
		String fstFile = "src/com/biz/names/한국인성씨.txt";
		String sndFile ="src/com/biz/names/이름리스트.txt";
		String saveFile ="src/com/biz/names/fullnameList.txt.";
		NameService ns = new NameService(fstFile, sndFile);
		Scanner sc = new Scanner(System.in);
		
	 
		ns.readAFistFile();
		ns.readSndFile();
		
			  
			while(true) {
				  
			 
				System.out.println("================================");
		    	System.out.println("1.화면출력  2. 파일저장  0.종료");
		    	System.out.println("================================");
		    	
		    	
		    	System.out.println("번호를 선택해주세요 >>");
		    	String st = sc.nextLine();
		    	int intSelect = Integer.valueOf(st);
		    	if(intSelect ==0) {
		    		System.out.println("종료합니다");
		    		break;
		    	}
		    	if(intSelect ==1) {
		    		System.out.println("화면 출력을 하겠습니다");
		    		ns.viewFullName();
		    	
		    	}if(intSelect ==2) {
		    		System.out.println("파일을 저장하겠습니다.");
		    		ns.writeFullName(saveFile);
		    	
			  }
		
	}

	}

			
		
	}

