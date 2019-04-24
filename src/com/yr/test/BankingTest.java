package com.yr.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.yr.banking.BankbookDAO;
import com.yr.banking.BankbookDTO;
import com.yr.banking.InOutDAO;
import com.yr.banking.InOutDTO;
import com.yr.banking.MemberDAO;
import com.yr.banking.MemberDTO;
import com.yr.util.DBConnector;

public class BankingTest {
	
	
	
	
	
	
	
	
	//@Test
	public void outInsert() throws Exception {
		InOutDAO ioDAO = new InOutDAO();
		InOutDTO ioDTO = new InOutDTO();
	//	ioDTO.setIoDate("2019-04-01");
		ioDTO.setOutMoney(3500);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
	public void createBookTest() throws Exception {
		BankbookDAO bookDAO = new BankbookDAO();
		BankbookDTO bookDTO = new BankbookDTO();
		bookDTO.setId("member1");
		bookDTO.setBookpw("book1");
		bookDTO.setAccount("123456");
		bookDTO.setOdate("2019-04-23");
		bookDTO.setBookname("돈줘");
	
		int result = bookDAO.createBook(bookDTO);
		
		assertNotEquals(0, result);
		
		
	}
	
//	@Test
	public void JoinTest() throws Exception {
		MemberDAO memDAO = new MemberDAO();
		MemberDTO memDTO = new MemberDTO();
		memDTO.setId("member1");
		memDTO.setPw("member1");
		memDTO.setUsername("me");
		memDTO.setPhone("010-1111-1234");
		memDTO.setEmail("member@co.kr");
		
		int result = memDAO.join(memDTO);
		assertNotEquals(0, result);
	}
	
	
//	@Test
	public void ConnectTest() {
		Connection con;
		try {
			con = DBConnector.getConnect();
			assertNotNull(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
