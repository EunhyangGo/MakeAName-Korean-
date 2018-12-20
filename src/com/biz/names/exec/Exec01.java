package com.biz.names.exec;

import java.util.Scanner;

import com.biz.names.service.NameService;

public class Exec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fstFile = "src/com/biz/names/한국인성씨.txt";
		String sndFile ="src/com/biz/names/이름리스트.txt";
		String saveFile ="src/com/biz/names/fullnameList.txt.";
		NameService ns = new NameService(fstFile, sndFile);
		Scanner sc = new Scanner(System.in);
		
		
		ns.readSndFile();
		ns.readAFistFile();
		ns.makeFullName(10);
		
		ns.viewFullName();
	
		ns.writeFullName(saveFile);
		
		
			
}
}