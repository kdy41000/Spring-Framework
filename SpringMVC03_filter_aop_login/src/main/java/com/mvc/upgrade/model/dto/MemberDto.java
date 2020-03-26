package com.mvc.upgrade.model.dto;

public class MemberDto {

	private String memberid;
	private String memberpw;
	private String membername;
	
	public MemberDto() {
		
	}

	public MemberDto(String memberid, String memberpw, String membername) {
		super();
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberpw() {
		return memberpw;
	}

	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}
	
}
