package com.biz.names.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.names.vo.FullNameVO;

// 파일 2개를 읽어서 조합을 해야하므로 기본적으로 2개의 파일을 읽어 값들을 보관할
// List 2개를 선언 및 초기화 하자
/*
 * ===========================
 * 1.화면출력   2. 파일저장     0.종료
 * ===========================
 * 
 * 업무선택 >>
 * 
 * 1 을 선택하면 화면에 보여주고
 * 2 를 선택하면 파일에 저장
 * 0 을 누르면 종료
 */
public class NameService {
	
	// 새로운 이름을 만들어서 저장할 fullnameList를 선언 및 초기화
	List<FullNameVO> fullnameList;

	// 파일 읽어서 저장할 List 2개
	List<String> firstList; //성씨 저장
	List<String> sndList; // 이름 저장
	
	Scanner sc;
	// 파일 2개를 읽기 위해서 service에서 직접 파일 이름을 지정해도 되지만
	// main()에서 파일 이름을 매개변수로 전달하도록 디자인 하자.
	
	String fstFile;
	String sndFile;
	String saveFile;
	public NameService(String fstFile, String sndFile) {
		// TODO Auto-generated method stub

		firstList = new ArrayList();
		sndList = new ArrayList();
		fullnameList = new ArrayList();
		sc = new Scanner(System.in);
		this.fstFile = fstFile;
		this.sndFile = sndFile;
		this.saveFile = saveFile;
	}
	
	// 한국성씨.txt파일에서 성씨리스트를 읽어서 firstList에 저장할 method를 만든다.
	
	public void readAFistFile() {
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(fstFile);
			buffer = new BufferedReader(fr);
			
			while(true) {
				String reader = buffer.readLine();
				if(reader == null)break;
				String[] names = reader.split(":");
				
				String fstName = names[1]; //한자포함
				
				// 일부 특수 문자는 단독으로 split이 안되는 것들이 있다.
				// 대표적으로 () ! 문자들은 split이 안되는데,
				// 이런 문자 앞에 슬래시(\)를 두개(\\)포함하면
				// split 분해가 가능하다.
				String[] hanNs = fstName.split("\\(");
				firstList.add(hanNs[0]);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 이름리스트.txt 파일에서 이름 리스트를 읽어서  sndList에 저장할 method를 만든다.
	
	public void readSndFile() {
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr = new FileReader(sndFile);
			buffer = new BufferedReader(fr);
			
			while(true) {
				String reader = buffer.readLine();
				if(reader == null)break;
				sndList.add(reader);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// 100개의 새로운 이름을 만드는데, service에서 개수를 정하지 않고
	// main에서 몇개를 만들지 정해주도록 디자인한다
	public void makeFullName(int nameSize) {
		
		//fNameList를 비우고 이름을 생성
		fullnameList.clear();
		int fSize = firstList.size(); // fsize에는 firstList의 개수가 들어잇을것이고
		int sSize = sndList.size();   // sSize에는 sndList의 개수가 들어있을것.
		
		for(int i = 1; i < nameSize+1 ; i++ ) {
			
			int fstPos = (int)(Math.random() * fSize);
			int sndPos = (int)(Math.random() * sSize);
			
			String fName = firstList.get(fstPos);
			String sName = sndList.get(sndPos);
			
		//	System.out.println(fName + sName);
			
			FullNameVO vo = new FullNameVO();
			vo.setStr1stName(fName);
			vo.setStr2ndName(sName);
			fullnameList.add(vo);
					
		}
		
	}

	public void writeFullName(String saveFile) {
		
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(saveFile);
			for(FullNameVO vo: fullnameList) {
				pw.println(vo.getStr1stName() + vo.getStr2ndName());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    public void viewFullName() {
			System.out.println("===================");
			System.out.println("한국인 이름들");
		
			System.out.println("-------------------");
			for(FullNameVO vo : fullnameList) {
				
				//1
				
				System.out.println(vo.getStr1stName()+vo.getStr2ndName());
				
				//2
				//System.out.print(vo.getStr1stName());
				//System.out.println(vo.getStr2ndName());
				
				//3
				//System.out.printf("%s%s\n",vo.getStr1stName(),vo.getStr2ndName());
				
				//4
				//String fName = vo.getStr1stName();
				//String sName = vo.getStr2ndName();
				
				
				//System.out.printf("%s%s\n", fName, sName);
				
			}
		
	}
  public void act() {
	  

	    String filePath = "src/com/biz/names/";
	    System.out.println("이름 생성 개수>>");
	    String strC = sc.nextLine();
	    int intC = Integer.valueOf(strC);
	    
		
  	  while(true) {
  		
  		  System.out.println("================================");
    	  System.out.println("1.화면출력  2. 파일저장  0.종료");
    	  System.out.println("================================");
    	  System.out.println("번호를 선택해주세요 >>");
    	
		 
  		  this.makeFullName(intC);
  		 
    	String st = sc.nextLine();
    	int intSelect = Integer.valueOf(st);
    	if(intSelect ==0) {
    		System.out.println("종료합니다");
    		return;
    	}
    	if(intSelect ==1) viewFullName();
    	if(intSelect ==2) {
    		System.out.println("파일이름");
    		String fileName = sc.nextLine();
    		writeFullName(filePath + fileName + ".txt");
    	}
	  }
  }

}
