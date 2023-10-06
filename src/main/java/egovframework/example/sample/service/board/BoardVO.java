package egovframework.example.sample.service.board;

import java.sql.Date;

public class BoardVO {
	
	private int BNO;
	private String TITLE; 
	private String CONTENT;
	private String WRITER;
	private Date REGDATE;
	private Date MODIDATE;
	
	// getter & setter
	public int getBNO() {
		return BNO;
	}
	public void setBNO(int BNO) {
		this.BNO = BNO;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String WRITER) {
		this.WRITER = WRITER;
	}
	public Date getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Date REGDATE) {
		this.REGDATE = REGDATE;
	}
	public Date getMODIDATE() {
		return MODIDATE;
	}
	public void setMODIDATE(Date mODIDATE) {
		MODIDATE = mODIDATE;
	}
	

}
