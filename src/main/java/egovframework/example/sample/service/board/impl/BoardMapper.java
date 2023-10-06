package egovframework.example.sample.service.board.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.sample.service.board.BoardVO;

@Mapper("boardMapper")
public interface BoardMapper {

	// insert content
	void insertBoardContent(BoardVO boardVO);
	
	// search all content
	List<BoardVO> getAllBoardContent();
	
	// search content by title or content word
	List<BoardVO> getBoardContentByKeyword(String keywordWithWildcard);
	
	// search content by bno
	BoardVO getBoardByBno(int BNO);
	
	// search bno by title and writer
	int getBnoByTitleAndWriter(String TITLE, String WRITER);
	
	// update content
	void updateBoardContent(BoardVO boardVO);
	
	// delete content
	void deleteBoardContentByBno(int BNO);
	
}
