package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		System.out.println("boardlist dao들어오니");
		try {
			list = sqlSession.selectList(NAMESPACE + "boardList");
		} catch (Exception e) {
			System.out.println("[ERROR]:select list");
		}
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = new BoardDto();
		System.out.println("boarddetail daoimpl들어오니");
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "boardDetail",myno);
		} catch (Exception e) {
			System.out.println("[ERROR]:select Detail");
		}
		
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		System.out.println("insert daoimpl 들어왔다.");
		System.out.println(dto.getMycontent()+"::daoimpl의 content");
		try {
			res = sqlSession.insert(NAMESPACE + "insertinfo",dto);
			
			if(res > 0) {
				sqlSession.commit();
			}
		} catch (Exception e) {
			System.out.println("[ERROR]:insert");
		}

		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		System.out.println("update daoimpl들어왔다.");
		try {
			res = sqlSession.update(NAMESPACE + "updateinfo",dto);
			
			if(res > 0) {
				sqlSession.commit();
			}
		} catch (Exception e) {
			System.out.println("[ERROR]:update");
		}
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		System.out.println(myno + "::delete daoimpl의 myno");
		try {
			res = sqlSession.delete(NAMESPACE + "deleteinfo",myno);
			
			if(res > 0) {
				System.out.println("삭제성공 (in daoimpl)*********");
				sqlSession.commit();
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR]: Delete");
		}
		
		return res;
	}

	@Override
	public int updatecnt(BoardDto dto) {
		int res = 0;
		
		try {
			sqlSession.update(NAMESPACE + "updatecnt",dto);
		} catch (Exception e) {
			System.out.println("[error]:updatecnt");
		}
		
		return res;
	}

}
