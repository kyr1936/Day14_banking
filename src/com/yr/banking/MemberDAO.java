package com.yr.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.yr.util.DBConnector;

public class MemberDAO {

	public int join(MemberDTO memDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memDTO.getId());
		st.setString(2, memDTO.getPw());
		st.setString(3, memDTO.getUsername());
		st.setString(4, memDTO.getPhone());
		st.setString(5, memDTO.getEmail());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		return result;
	}
	
	public MemberDTO memberList(MemberDTO memDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from member where id=?";
		PreparedStatement st =con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("id를 입력하세요");
		st.setString(1, sc.next());
		
		ResultSet rs = st.executeQuery();
		memDTO = null;
		if(rs.next()) {
			memDTO = new MemberDTO();
			memDTO.setId(rs.getString("id"));
			memDTO.setPw(rs.getString("pw"));
			memDTO.setUsername(rs.getString("username"));
			memDTO.setPhone(rs.getString("phone"));
			memDTO.setEmail(rs.getString("email"));
			
		} return memDTO;
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
