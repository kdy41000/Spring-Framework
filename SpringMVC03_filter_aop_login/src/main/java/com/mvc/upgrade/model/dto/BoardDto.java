package com.mvc.upgrade.model.dto;

import java.util.Date;

public class BoardDto {

	private int myno;
	private String myid;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	private int mycnt;
	
	public BoardDto() {

	}

	public BoardDto(int myno, String myid, String mytitle, String mycontent, Date mydate, int mycnt) {
		super();
		this.myno = myno;
		this.myid = myid;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
		this.mycnt = mycnt;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}

	public int getMycnt() {
		return mycnt;
	}

	public void setMycnt(int mycnt) {
		this.mycnt = mycnt;
	}

	
}
