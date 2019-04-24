package com.yr.control;

public class BankingMain {

	public static void main(String[] args) {
		BankingController bc = new BankingController();
		try {
			bc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
