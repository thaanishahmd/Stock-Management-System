package com.product;

public class product {
	private int pid;
	private String pname;
	private String pdesc;
	private int pprice;
	private String categ;
	
	public product(int pid, String pname, String pdesc, int pprice, String categ) {
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pprice = pprice;
		this.categ = categ;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public int getPprice() {
		return pprice;
	}

	public String getCateg() {
		return categ;
	}
}
