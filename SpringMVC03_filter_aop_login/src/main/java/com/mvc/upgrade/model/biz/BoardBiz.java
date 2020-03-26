package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dto.BoardDto;

@Service
public interface BoardBiz {

	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);
	
	public int updatecnt(BoardDto dto);
}
