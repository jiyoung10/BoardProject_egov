package egovframework.example.sample.service.file;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Class Name : FileVO.java
 * @Description : 파일정보 처리를 위한 VO 클래스
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2009. 3. 25.     이삼섭
 *
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 3. 25.
 * @version
 * @see
 *
 */
public class FileVO implements Serializable {

    /**
	 *  serialVersion UID
	 */
	private static final long serialVersionUID = -287950405903719128L;
	/**
     * 첨부파일 아이디
     */
	private int FNO;
	private int BNO;
	private int RNO;
	private String FILE_NAME; 
	private Timestamp REGDATE;
	
	// getter & setter
	public int getFNO() {
		return FNO;
	}
	public void setFNO(int FNO) {
		this.FNO = FNO;
	}
	public int getBNO() {
		return BNO;
	}
	public void setBNO(int BNO) {
		this.BNO = BNO;
	}
	public int getRNO() {
		return RNO;
	}
	public void setRNO(int RNO) {
		this.RNO = RNO;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String FILE_NAME) {
		this.FILE_NAME = FILE_NAME;
	}
	public Timestamp getREGDATE() {
		return REGDATE;
	}
	public void setREGDATE(Timestamp REGDATE) {
		this.REGDATE = REGDATE;
	}

}