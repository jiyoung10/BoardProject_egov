package egovframework.example.sample.service.reply.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.sample.service.reply.ReplyVO;

@Mapper("replyMapper")
public interface ReplyMapper {
	
	List<ReplyVO> getReplyByBno(int BNO) throws Exception;
	
	void insertReplyText(ReplyVO replyVO) throws Exception;
	
	void updateReplyText(ReplyVO replyVO) throws Exception;
	
	void deleteReplyTextByRNO(int RNO) throws Exception;
	
	void deleteReplyByBno(int BNO) throws Exception;
	
	ReplyVO getReplyByRno(int RNO) throws Exception;

}
