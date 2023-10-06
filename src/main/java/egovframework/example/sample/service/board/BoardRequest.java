package egovframework.example.sample.service.board;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {
	
	private int BNO;
	private MultipartFile FILE;
	private String TITLE; 
	private String CONTENT;
	private String WRITER;
	private Timestamp REGDATE;
	private Timestamp MODIDATE;

}
