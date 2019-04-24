package com.yr.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yr.util.DBConnector;

public class InOutDAO {

	// 입금 거래 발생
	public int deposit(BankbookDTO bookDTO, InOutDTO ioDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "insert into inout(num, account, iodate, inMoney) values(num_seq.nextval,?, sysdate,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, bookDTO.getAccount());
		st.setInt(2, ioDTO.getInMoney());
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		
		return result;
	}
	// 출금 거래 발생
	public int withdrawInsert(BankbookDTO bookDTO, InOutDTO ioDTO) throws Exception {
		Connection con  = DBConnector.getConnect();
		String sql = "insert into inout(num, account, iodate, outmoney) values(num_seq.nextval,?, sysdate,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bookDTO.getAccount());
		st.setInt(2, ioDTO.getOutMoney());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		return result;
	}
	
	// 전체 내역 조회
	public ArrayList<InOutDTO> allselect() throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from inout";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		InOutDTO ioDTO = null;
		ArrayList<InOutDTO> ar = new ArrayList<InOutDTO>();
		
		while(rs.next()) {
			ioDTO = new InOutDTO();
			ioDTO.setNum(rs.getInt("num"));
			ioDTO.setAccount(rs.getString("account"));
			ioDTO.setIoDate(rs.getDate("ioDate"));
			ioDTO.setInMoney(rs.getInt("inMoney"));
			ioDTO.setOutMoney(rs.getInt("outMoney"));
			//
			ar.add(ioDTO);
		}
		DBConnector.disConnect(con, st, rs);
		return ar;
	}
/*	
	public InOutDTO ioList(MemberDTO memDTO, BankbookDTO bookDTO, InOutDTO ioDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from inout where account=?";
		PreparedStatement st =con.prepareStatement(sql);
		
		st.setString(1, bookDTO.getId());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			ioDTO = new InOutDTO();
			ioDTO.setNum(rs.getInt("num"));
			ioDTO.setAccount(rs.getString("account"));
			ioDTO.setIoDate(rs.getDate("ioDate"));
			ioDTO.setInMoney(rs.getInt("inMoney"));
			ioDTO.setOutMoney(rs.getInt("outMoney"));
			
		} return ioDTO;
	} 
	*/

	
	
	
	
}
