package egovframework.example.sample.service.reply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.reply.ReplyVO;

@Service("replyService")
public class ReplyService {
	
	@Autowired
	ReplyMapper replyMapper;
	
	public void registerReply(ReplyVO replyVO) throws Exception {
		
		replyMapper.insertReplyText(replyVO);
		
		System.out.println("ReplyService - INSERT_REPLY_TEXT_SUCCESS");
		
	}
	
	public List<ReplyVO> getReplyByBno(int BNO) throws Exception {
	
		 List<ReplyVO> reply = replyMapper.getReplyByBno(BNO);
		 
		 System.out.println("ReplyService - GET_REPLY_BY_BNO_SUCCESS");
		 
		 return reply;
		
	}
	
	public void updateReplyText(ReplyVO replyVO) throws Exception {
		
		System.out.println("updateReplyText : " + replyVO);
		
		replyMapper.updateReplyText(replyVO);
		
		System.out.println("ReplyService - UPDATE_REPLY_TEXT_SUCCESS");
	}
	
	public ReplyVO deleteReplyTextByRNO(int RNO) throws Exception {
		
		System.out.println("deleteReplyTextByRNO : " + RNO);
		
		replyMapper.deleteReplyTextByRNO(RNO);
		
		ReplyVO reply = replyMapper.getReplyByRno(RNO);
		
		System.out.println("ReplyService - DELETE_REPLY_TEXT_SUCCESS");
		
		return reply;
	}

}
