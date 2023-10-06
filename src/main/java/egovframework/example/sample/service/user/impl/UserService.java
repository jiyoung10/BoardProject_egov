package egovframework.example.sample.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import egovframework.example.sample.service.user.UserVO;

@Service("userService")
public class UserService implements UserDetailsService{

	@Autowired
	UserMapper userMapper;

	public int insertUserInfo(UserVO userVO) throws Exception {
		
		System.out.println("insertUserInfo : " + userVO.getUSER_ID() + " " + userVO.getUSER_AUTHORITY());
		
		// ID 중복 검증
		if(userMapper.getUserIdById(userVO.getUSER_ID())!= null) {
			System.out.println("이미 존재하는 ID입니다.");
			return 1;
		}
		
		userVO.setUSER_ENABLED(1);
		userVO.setUSER_AUTHORITY(userVO.getUSER_AUTHORITY());
		
		userMapper.insertUserInfo(userVO);
		
		System.out.println("Before Insert UserVO : " + userVO.getUSER_AUTHORITY());
		
		System.out.println("UserService - INSERT_USER_INFO_SUCCESS");
		
		return 0;
		
	}

	// ********** ADMIN **********
	public List<UserVO> getUserList() throws Exception {
		List<UserVO> userList = userMapper.getUserList();
		
		return userList;
	}
	
	public UserVO updateUserInfo(UserVO userVO) throws Exception {
		
		System.out.println("USER SERVICE userVO : " + userVO.getUSER_ID());
		
		userMapper.updateUserInfo(userVO);
		
		UserVO updatedUser = userMapper.getUserDetailByUserId(userVO.getUSER_ID());
		
		System.out.println("UserService - UPDATE_USER_INFO_SUCCESS");
		
		return updatedUser;
		
	}

	public void deleteUserInfo(String userId) throws Exception {
		userMapper.deleteUserById(userId);
		System.out.println("UserService - DELETE_USER_INFO_SUCCESS");
		
	}
	
	public UserVO getUserDetailByUserId(String userId) throws Exception {
		return userMapper.getUserDetailByUserId(userId);
	}
	
	public String getUserIdById(String userId) throws Exception {
		return userMapper.getUserIdById(userId);
	}
	

	public String getUserAuthorityById(String userId) throws Exception {
		return userMapper.getUserAuthorityById(userId);
	}
	
	public String getUserNameById(String userId) throws Exception {
		return userMapper.getUserNameById(userId);
	}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("load before userId :" +  userId);
		
		UserVO user = null;
		try {
			user = userMapper.getUserDetailByUserId(userId);
			System.out.println("load user info : " + user.getUSER_AUTHORITY() + user.getUSER_ID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return user;
	}

}
