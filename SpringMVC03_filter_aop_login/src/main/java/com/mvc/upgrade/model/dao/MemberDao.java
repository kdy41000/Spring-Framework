package com.mvc.upgrade.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
public interface MemberDao {

	String NAMESPACE = "mymember.";
	
	public MemberDto login(MemberDto dto);
	public int signup(MemberDto dto);
}
