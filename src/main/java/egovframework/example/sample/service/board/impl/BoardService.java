package egovframework.example.sample.service.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.board.BoardVO;
import egovframework.example.sample.service.reply.impl.ReplyMapper;

@Service("boardService")
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	ReplyMapper replyMapper;
	
	public int WriteBoardContent(BoardVO boardVO) throws Exception {
		
		boardMapper.insertBoardContent(boardVO);
		
		System.out.println("board insert service : "+ boardVO.getBNO());
		System.out.println("board insert service : "+ boardVO.getTITLE());
		System.out.println("board insert service : "+ boardVO.getWRITER());
		
		String TITLE = boardVO.getTITLE();
		String WRITER = boardVO.getWRITER();
		
		int BNO = boardMapper.getBnoByTitleAndWriter(TITLE, WRITER);
		
		System.out.println("BoardService - INSERT_BOARD_CONTENT_SUCCESS");
		
		return BNO;
		
	}

	public List<BoardVO> getBoardList() throws Exception {
		
		List<BoardVO> list = boardMapper.getAllBoardContent();
		
		System.out.println("BoardService - GET_BOARD_LIST_SUCCESS");
		
		return list;
	}
	
	public List<BoardVO> searchContentByKeyword(String keyword) throws Exception {
		
		String keywordWithWildcard = "%" + keyword + "%";
		
		List<BoardVO> list = boardMapper.getBoardContentByKeyword(keywordWithWildcard);
		
		System.out.println("BoardService - SEARCH_CONTENT_BY_KEYWORD_SUCCESS");
		
		return list;
	}
	
	public BoardVO getBoardByBno(int BNO) throws Exception {
		
		BoardVO board = boardMapper.getBoardByBno(BNO);
		
		System.out.println("BoardService - GET_BOARD_BY_BNO_SUCCESS");
		
		return board;
		
	}

	public void deleteBoardContentByBno(int BNO) throws Exception {
		
		boardMapper.deleteBoardContentByBno(BNO);
		
		replyMapper.deleteReplyByBno(BNO);
		
		System.out.println("BoardService - DELETE_BOARD_CONTENT_SUCCESS");
		
	}
	
	public BoardVO updateBoardContent(BoardVO boardVO) throws Exception {
		
		boardMapper.updateBoardContent(boardVO);
		
		BoardVO updatedBoard = boardMapper.getBoardByBno(boardVO.getBNO());
		
		System.out.println("BoardService - UPDATE_BOARD_CONTENT_SUCCESS");
		
		return updatedBoard;
		
	}
	
}
