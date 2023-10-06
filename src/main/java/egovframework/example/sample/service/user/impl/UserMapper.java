package egovframework.example.sample.service.user.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.sample.service.user.UserVO;


@Mapper("userMapper")
public interface UserMapper {

	void insertUserInfo(UserVO userVO) throws Exception;
	
	UserVO selectUserById(String userId) throws Exception;
	
	UserVO getUserDetailByUserId(String userId) throws Exception;
	
	List<UserVO> selectUserList() throws Exception;
	
	List<UserVO> getUserList() throws Exception;
	
	void deleteUserById(String userId) throws Exception;
	
	String getUserIdById(String userId) throws Exception;
	
	String getUserAuthorityById(String userId) throws Exception;
	
	String getUserNameById(String userId) throws Exception;
	
	void updateUserInfo(UserVO userVO)throws Exception;
	
	
}
