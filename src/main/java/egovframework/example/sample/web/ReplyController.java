package egovframework.example.sample.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.reply.ReplyVO;
import egovframework.example.sample.service.reply.impl.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value="/registerReply.do", method=RequestMethod.POST)
	public String registerReply(Model model, ReplyVO replyVO) throws Exception {
		
		System.out.println("/registerReply.do : " + replyVO.getREPLYTEXT());
		
		replyService.registerReply(replyVO);
		
		return "redirect:/user/boardDetail?bno=" + replyVO.getBNO();
		
	}
	
	// 댓글 수정
	@RequestMapping(value="/updateReply.do", method=RequestMethod.POST)
	public String updateReply(ReplyVO replyVO) throws Exception {
		
		System.out.println("/updateReply.do : " + replyVO);
		
		replyService.updateReplyText(replyVO);
		
		return "redirect:/user/boardDetail?bno=" + replyVO.getBNO();
	}

	// 댓글 삭제
	@RequestMapping(value="/deleteReply", method=RequestMethod.GET)
	public String deleteReplyText(@RequestParam("rno") int RNO) throws Exception {
		
		ReplyVO replyVO = replyService.deleteReplyTextByRNO(RNO);
		
		System.out.println("delete reply replyVO BNO : " +replyVO.getBNO());
		
		return "redirect:/user/boardDetail?bno=" + replyVO.getBNO();
	}

}
