package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto memberdto = new MemberDto();
		
		try {
			memberdto = sqlSession.selectOne(NAMESPACE + "memberlogin",dto);
		} catch (Exception e) {
			System.out.println("[error]: memberlogin");
		}
		
		
		return memberdto;
	}

	@Override
	public int signup(MemberDto dto) {
		int res = 0;
		
		System.out.println("daoimpl회원가입");
		System.out.println(dto.getMemberid());
		System.out.println(dto.getMemberpw());
		System.out.println(dto.getMembername());
		
		try {
			res = sqlSession.insert(NAMESPACE + "membersignup",dto);
		} catch (Exception e) {
			System.out.println("[error]: membersignup");
		}
		
		return res;
	}

}
