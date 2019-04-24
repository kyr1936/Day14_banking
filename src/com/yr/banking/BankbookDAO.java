package com.yr.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.yr.util.DBConnector;

public class BankbookDAO {
	
	
	public void plusBal(BankbookDTO bookDTO, InOutDTO ioDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "update bankbook set balance=balnace+? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, ioDTO.getInMoney());
		st.setString(2, bookDTO.getId());
		
		st.executeUpdate();
		DBConnector.disConnect(con, st);
		
	}
	
	public int minusBal(BankbookDTO bookDTO, InOutDTO ioDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "update bankbook set balance=balance-? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, ioDTO.getOutMoney());
		st.setString(2, bookDTO.getId());
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		return result;
	}
	
	
	public int createBook(BankbookDTO bookDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into bankbook values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bookDTO.getId());
		st.setString(2, bookDTO.getBookpw());
		st.setString(3, bookDTO.getAccount());
		st.setString(4, bookDTO.getOdate());
		st.setString(5, bookDTO.getBookname());
		st.setInt(6, bookDTO.getBalance());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		
		return result;	
	}
	
	public BankbookDTO bookList(MemberDTO memDTO, BankbookDTO bookDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from bankbook where account=?";
		PreparedStatement st =con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌 입력");
		st.setString(1, sc.next());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bookDTO = new BankbookDTO();
			memDTO.setId(rs.getString("id"));
			bookDTO.setBookpw(rs.getString("bookpw"));
			bookDTO.setAccount(rs.getString("account"));
			bookDTO.setOdate(rs.getString("odate"));
			bookDTO.setBookname(rs.getString("bookname"));
			bookDTO.setBalance(rs.getInt("balance"));
		} return bookDTO;
	} 
	
	// 잔액 조회
	public BankbookDTO balanceView(int balance) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select balance from bankbook";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		BankbookDTO bookDTO = null;
		if(rs.next()) {
			bookDTO = new BankbookDTO();
			bookDTO.setBalance(rs.getInt("balance"));
		}
		DBConnector.disConnect(con, st, rs);
		
		return bookDTO;
	}
	
	
	
	
	
	
	
	

}
