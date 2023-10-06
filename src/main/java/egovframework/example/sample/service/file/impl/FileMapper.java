package egovframework.example.sample.service.file.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import egovframework.example.sample.service.file.FileVO;


@Mapper("fileMapper")
public interface FileMapper {

	// insert content
	void insertFile(FileVO fileVO);
	
	// search file by bno
	FileVO getFileByBno(int BNO);
	
	// delete file
	void deleteFileByBno(int BNO);
	
}
