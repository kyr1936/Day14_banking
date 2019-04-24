package com.yr.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.yr.banking.BankbookDAO;
import com.yr.banking.BankbookDTO;
import com.yr.banking.InOutDAO;
import com.yr.banking.InOutDTO;
import com.yr.banking.MemberDAO;
import com.yr.banking.MemberDTO;

import com.yr.input.BankingInput;
import com.yr.view.BankingView;

public class BankingController {

	public void start() throws Exception {
		MemberDAO memDAO = new MemberDAO();
		MemberDTO memDTO = new MemberDTO();
		InOutDAO ioDAO = new InOutDAO();
		InOutDTO ioDTO = new InOutDTO();
		BankbookDTO bookDTO = new BankbookDTO();
		BankbookDAO bookDAO = new BankbookDAO();
		BankingView bv = new BankingView();
		BankingInput bi = new BankingInput();
		Scanner sc = new Scanner(System.in);
		
		
		boolean check = true;
		int result = 0;
		while(check) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 통장 개설");
			System.out.println("3. 입금하기");
			System.out.println("4. 출금하기");
			System.out.println("5. 전체 내역 조회");
			System.out.println("6. 기간별 내역 조회");
			System.out.println("7. 입금 내역 조회");
			System.out.println("8. 출금 내역 조회");
			System.out.println("9. 종료");
			int select = sc.nextInt();
		switch (select) {
		case 1: 
			memDTO = bi.setMember();
			result = memDAO.join(memDTO);
			String str = "가입 실패";
			if(result>0) {
				str = "등록 성공";
			}
			bv.view(str);
			break;
		case 2: 
			bookDTO = bi.setBankbook();
			result = bookDAO.createBook(bookDTO);
			str = "계좌 개설 실패";
			if(result>0) {
				str = "계좌 개설 성공";
			}
			bv.view(str);
			break;
		case 3:
			break;
		case 4:
			bookDTO = bookDAO.bookList(memDTO, bookDTO);
			if(bookDTO!=null) {
				ioDTO = bi.withdraw();
				result = ioDAO.withdrawInsert(bookDTO, ioDTO);
				str = "출금 실패";
				if(result>0) {
					str = "출금 성공";
					bookDAO.minusBal(bookDTO, ioDTO);
					bv.withdrawView(ioDTO, bookDTO);
				}
				bv.view(str);
			}
			
			break;
		case 5:
			ArrayList<InOutDTO> ar =ioDAO.allselect();
			bv.allView(ioDTO, bookDTO);
			
			break;
		case 6:
			break;
		case 7:
			 break;
		case 8: 
			break;
		default : 
			check=!check;
			break;
		}
			
			
			
			
			
			
			
			
			
			
		}
		
	}
}
