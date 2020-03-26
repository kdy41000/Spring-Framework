package com.mvc.upgrade.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public interface BoardDao {

	String NAMESPACE = "myboard.";
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	public int updatecnt(BoardDto dto);
}
