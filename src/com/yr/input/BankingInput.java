package com.yr.input;

import java.util.ArrayList;
import java.util.Scanner;

import com.yr.banking.BankbookDTO;
import com.yr.banking.InOutDTO;
import com.yr.banking.MemberDTO;

public class BankingInput {

	public MemberDTO setMember() throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDTO memDTO = new MemberDTO();

		System.out.println("id 입력");
		memDTO.setId(sc.next());
		System.out.println("pw 입력");
		memDTO.setPw(sc.next());
		System.out.println("username 입력");
		memDTO.setUsername(sc.next());
		System.out.println("phone 입력");
		memDTO.setPhone(sc.next());
		System.out.println("email 입력");
		memDTO.setEmail(sc.next());


		return memDTO;
	}
	public BankbookDTO setBankbook() {
		BankbookDTO bookDTO = new BankbookDTO();
		Scanner sc = new Scanner(System.in);

		System.out.println("id 입력");
		bookDTO.setId(sc.next());
		System.out.println("bookpw 입력");
		bookDTO.setBookpw(sc.next());
		System.out.println("account 입력");
		bookDTO.setAccount(sc.next());
		System.out.println("개설 날짜 입력");
		bookDTO.setOdate(sc.next());
		System.out.println("통장 이름 입력");
		bookDTO.setBookname(sc.next());
		System.out.println("잔액 입력");
		bookDTO.setBalance(sc.nextInt());

		return bookDTO;

	}

	public InOutDTO withdraw() {
		InOutDTO ioDTO = new InOutDTO();

		Scanner sc = new Scanner(System.in);

		System.out.println("출금할 금액 입력");
		ioDTO.setOutMoney(sc.nextInt());

		return ioDTO;
	}
}
