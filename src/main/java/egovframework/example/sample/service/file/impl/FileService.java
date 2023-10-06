package egovframework.example.sample.service.file.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.sample.service.file.FileVO;
import egovframework.example.sample.service.reply.impl.ReplyMapper;

@Service("fileService")
public class FileService {
	
	@Autowired
	FileMapper fileMapper;
	
	@Autowired
	ReplyMapper replyMapper;
	
	public void insertFile(int BNO, MultipartFile FILE) throws Exception {
		
		System.out.println("insertFile service : " + FILE.getOriginalFilename());
		
		FileVO fileVO = new FileVO();
		
		fileVO.setBNO(BNO);
		fileVO.setFILE_NAME(FILE.getOriginalFilename());
		
		fileMapper.insertFile(fileVO);
		
		System.out.println("FileService - INSERT_FILE_SUCCESS");
		
	}
	
//	public String insertFileInfs(List<?> fvoList) throws Exception {
//		String atchFileId = "";
//
//		if (fvoList.size() != 0) {
//		    atchFileId = fileMapper.insertFileInfs(fvoList);
//		}
//		if(atchFileId == ""){
//			atchFileId = null;
//		}
//		return atchFileId;
//	    }
	
	public FileVO getFileByBno(int BNO) throws Exception {
		
		FileVO file = fileMapper.getFileByBno(BNO);
		
		System.out.println("FileService - GET_FILE_BY_BNO_SUCCESS");
		
		return file;
		
	}

	public void deleteFileByBno(int BNO) throws Exception {
		
		fileMapper.deleteFileByBno(BNO);
		
		System.out.println("FileService - DELETE_FILE_SUCCESS");
		
	}
	
}
