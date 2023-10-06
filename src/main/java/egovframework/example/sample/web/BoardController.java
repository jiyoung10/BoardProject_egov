package egovframework.example.sample.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.sample.service.board.BoardVO;
import egovframework.example.sample.service.board.impl.BoardService;
import egovframework.example.sample.service.file.FileVO;
import egovframework.example.sample.service.file.impl.FileService;
import egovframework.example.sample.service.reply.ReplyVO;
import egovframework.example.sample.service.reply.impl.ReplyService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="/boardList.do", method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		
		List<BoardVO> list = boardService.getBoardList();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/searchContentByKeyword", method=RequestMethod.GET)
	public String searchContentByKeyword(@RequestParam("keyword") String keyword, Model model) throws Exception {
		
		System.out.println("board controller keyword : " + keyword);
		
		List<BoardVO> list = boardService.searchContentByKeyword(keyword);
		
		model.addAttribute("list", list);
	    
		return "board/boardList";
	}
	
	@RequestMapping(value="/user/boardDetail", method=RequestMethod.GET)
	public String boardDetail(@RequestParam("bno") int BNO, Authentication authentication, Model model) throws Exception {
		
		BoardVO board = boardService.getBoardByBno(BNO);
		
		// 작성자와 로그인한 사용자가 일치할 시 boardDetail 수정 가능한 페이지로 이동
		if(board.getWRITER().equals(authentication.getName())) {
			model.addAttribute("board", board);		
			
			// 댓글 조회 
			List<ReplyVO> reply = replyService.getReplyByBno(BNO);
			model.addAttribute("reply", reply);

			return "board/boardDetailForUpdate";
		} 
		
		// 작성자와 로그인한 사용자가 불일치할 시 boardDetail 수정 불가능한 페이지로 이동
		model.addAttribute("board", board);
	    
		// 댓글 조회
		List<ReplyVO> reply = replyService.getReplyByBno(BNO);
		model.addAttribute("reply", reply);
		
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/user/boardForm", method=RequestMethod.GET)
	public String boardForm(BoardVO boardVO) {
		
		return "board/boardForm";
	}
	
	@RequestMapping(value="/user/writeContent.do", method=RequestMethod.POST)
	public String openBoardWrite(BoardVO boardVO, MultipartFile FILE) throws Exception {
		
		System.out.println("board write con file : " + FILE);
		System.out.println("board write con boardVO : " + boardVO);
		
		int BNO = boardService.WriteBoardContent(boardVO);
		
		System.out.println("board write con BNO : " + BNO);
		
		fileService.insertFile(BNO, FILE);
		
		return "board/boardForm";
	}
	
	@RequestMapping(value="/user/updateContent.do", method=RequestMethod.POST)
	public String updateBoardContent(BoardVO boardVO, Model model) throws Exception {
		
		BoardVO updatedBoard = boardService.updateBoardContent(boardVO);
		
		model.addAttribute("board", updatedBoard);
		
		return "board/boardDetailForUpdate";
	}
	
	@RequestMapping(value="/user/deleteContent", method=RequestMethod.GET)
	public String deleteBoardContent(@RequestParam("bno") int BNO, Model model) throws Exception {
		
		boardService.deleteBoardContentByBno(BNO);
		
		List<BoardVO> list = (List<BoardVO>) boardService.getBoardList();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	

	
}
