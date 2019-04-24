package com.yr.banking;

import java.sql.Date;

public class InOutDTO {
	private int num;
	private String account;
	private Date ioDate;
	private int inMoney;
	private int outMoney;

	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getIoDate() {
		return ioDate;
	}
	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}
	public int getInMoney() {
		return inMoney;
	}
	public void setInMoney(int inMoney) {
		this.inMoney = inMoney;
	}
	public int getOutMoney() {
		return outMoney;
	}
	public void setOutMoney(int outMoney) {
		this.outMoney = outMoney;
	}

	
	
}
