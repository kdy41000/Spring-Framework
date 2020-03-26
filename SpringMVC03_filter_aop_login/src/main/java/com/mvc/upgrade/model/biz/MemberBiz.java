package com.mvc.upgrade.model.biz;

import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dto.MemberDto;

@Service
public interface MemberBiz {

	public MemberDto login(MemberDto dto);
	public int signup(MemberDto dto);
}
