package com.yr.view;

import com.yr.banking.BankbookDTO;
import com.yr.banking.InOutDTO;

public class BankingView {
	
	public void depositView(InOutDTO ioDTO, BankbookDTO bookDTO) {
		System.out.println("num : " + ioDTO.getNum());
		System.out.println("account : " + ioDTO.getAccount());
		System.out.println("iodate : " + ioDTO.getIoDate());
		System.out.println("inMoney : " + ioDTO.getInMoney());
		System.out.println("balance : " + bookDTO.getBalance());

	}
	
	public void withdrawView(InOutDTO ioDTO, BankbookDTO bookDTO) {
		System.out.println("num : " + ioDTO.getNum());
		System.out.println("account : " + ioDTO.getAccount());
		System.out.println("iodate : " + ioDTO.getIoDate());
		System.out.println("outMoney : " + ioDTO.getOutMoney());
		System.out.println("balance : " + bookDTO.getBalance());
	}
	
	public void allView(InOutDTO ioDTO, BankbookDTO bookDTO) {
		System.out.println("num : " + ioDTO.getNum());
		System.out.println("account : " + ioDTO.getAccount());
		System.out.println("iodate : " + ioDTO.getIoDate());
		System.out.println("inMoney : " + ioDTO.getInMoney());
		System.out.println("outMoney : " + ioDTO.getOutMoney());
		System.out.println("balance : " + bookDTO.getBalance());
	}
	

	
	public void view(String str) {
		System.out.println(str);
	}
	
}
