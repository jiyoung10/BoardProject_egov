package egovframework.example.sample.service.reply;

import java.sql.Timestamp;

public class ReplyVO {
	
	private int RNO;
	private int BNO;
	private String REPLYTEXT; 
	private String REPLYER;
	private Timestamp REGDATE;
	private Timestamp UPDATEDATE;
	
	// getter & setter
	public int getRNO() {
		return RNO;
	}
	public void setRNO(int RNO) {
		this.RNO = RNO;
	}
	public int getBNO() {
		return BNO;
	}
	public void setBNO(int BNO) {
		this.BNO = BNO;
	}
	public String getREPLYTEXT() {
		return REPLYTEXT;
	}
	public void setREPLYTEXT(String REPLYTEXT) {
		this.REPLYTEXT = REPLYTEXT;
	}
	public String getREPLYER() {
		return REPLYER;
	}
	public void setREPLYER(String REPLYER) {
		this.REPLYER = REPLYER;
	}
	public Timestamp getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Timestamp REGDATE) {
		this.REGDATE = REGDATE;
	}
	public Timestamp getUPDATEDATE() {
		return UPDATEDATE;
	}
	public void setUPDATEDATE(Timestamp UPDATEDATE) {
		this.UPDATEDATE = UPDATEDATE;
	}

}
